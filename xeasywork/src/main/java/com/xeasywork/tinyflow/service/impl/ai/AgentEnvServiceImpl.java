package com.xeasywork.tinyflow.service.impl.ai;

import com.xeasywork.tinyflow.domain.ai.AgentEnv;
import com.xeasywork.tinyflow.mapper.ai.AgentEnvMapper;
import com.xeasywork.tinyflow.service.ai.IAgentEnvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Agent环境配置ServiceImpl
 */
@Service
public class AgentEnvServiceImpl implements IAgentEnvService {
    @Resource
    private AgentEnvMapper agentEnvMapper;

    @Override
    public AgentEnv selectAgentEnvById(Long id) {
        return agentEnvMapper.selectAgentEnvById(id);
    }

    @Override
    public List<AgentEnv> selectAgentEnvList(AgentEnv agentEnv) {
        return agentEnvMapper.selectAgentEnvList(agentEnv);
    }

    @Override
    public int insertAgentEnv(AgentEnv agentEnv) {
        return agentEnvMapper.insertAgentEnv(agentEnv);
    }

    @Override
    public int updateAgentEnv(AgentEnv agentEnv) {
        return agentEnvMapper.updateAgentEnv(agentEnv);
    }

    @Override
    public int deleteAgentEnvByIds(Long[] ids) {
        return agentEnvMapper.deleteAgentEnvByIds(ids);
    }

    @Override
    public int deleteAgentEnvById(Long id) {
        return agentEnvMapper.deleteAgentEnvById(id);
    }
}