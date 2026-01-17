package com.xeasywork.tinyflow.domain.ai;

import lombok.Data;

/**
 * 聊天请求对象
 */
@Data
public class ChatRequest {
    /**
     * 会话ID
     */
    private Long sessionId;
    
    /**
     * 模型ID
     */
    private Long modelId;
    
    /**
     * 聊天文本
     */
    private String text;
}