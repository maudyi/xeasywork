export function streamChat(sessionId, modelId, text, token) {
  return new Promise(async (resolve, reject) => {
    try {
      const response = await fetch(`${import.meta.env.VITE_APP_BASE_API}/ai/chat/streamChat`, {
        method: 'POST',
        headers: {
          Authorization: 'Bearer ' + token,
          Accept: 'text/event-stream',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          sessionId,
          modelId,
          text
        })
      });

      if (!response.ok) {
        if (response.status === 401) {
          reject(new Error('认证失败，请重新登录'));
        } else {
          reject(new Error(`HTTP error! status: ${response.status}`));
        }
        return;
      }

      const reader = response.body.getReader();
      const decoder = new TextDecoder('utf-8');
      let buffer = '';

      // 创建一个模拟EventSource的对象
      const eventSource = {
        onmessage: null,
        onopen: null,
        onerror: null,
        close: () => {
          reader.cancel();
          isClosed = true;
        }
      };

      let isClosed = false;

      // 触发onopen事件
      if (eventSource.onopen) {
        eventSource.onopen();
      }

      // 开始读取流
      (async function readStream() {
        while (!isClosed) {
          try {
            const { done, value } = await reader.read();
            if (done) {
              if (eventSource.onerror) {
                eventSource.onerror(new Error('Connection closed'));
              }
              break;
            }

            buffer += decoder.decode(value, { stream: true });
            
            // 处理SSE事件
            const lines = buffer.split('\n');
            buffer = lines.pop(); // 保留不完整的行

            for (const line of lines) {
              if (line.trim() === '') continue;
              if (line.startsWith('data:')) {
                const data = line.substring(5).trim();
                if (eventSource.onmessage) {
                  eventSource.onmessage({ data });
                }
              }
            }
          } catch (error) {
            if (eventSource.onerror) {
              eventSource.onerror(error);
            }
            break;
          }
        }
      })();

      resolve(eventSource);
    } catch (error) {
      reject(error);
    }
  });
}
