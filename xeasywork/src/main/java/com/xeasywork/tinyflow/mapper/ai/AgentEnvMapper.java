package com.xeasywork.tinyflow.mapper.ai;

import com.xeasywork.tinyflow.domain.ai.AgentEnv;

import java.util.List;

/**
 * Agent环境配置Mapper接口
 */
public interface AgentEnvMapper {
    /**
     * 查询Agent环境配置
     *
     * @param id Agent环境配置主键
     * @return Agent环境配置
     */
    AgentEnv selectAgentEnvById(Long id);

    /**
     * 查询Agent环境配置列表
     *
     * @param agentEnv Agent环境配置
     * @return Agent环境配置集合
     */
    List<AgentEnv> selectAgentEnvList(AgentEnv agentEnv);

    /**
     * 新增Agent环境配置
     *
     * @param agentEnv Agent环境配置
     * @return 结果
     */
    int insertAgentEnv(AgentEnv agentEnv);

    /**
     * 修改Agent环境配置
     *
     * @param agentEnv Agent环境配置
     * @return 结果
     */
    int updateAgentEnv(AgentEnv agentEnv);

    /**
     * 批量删除Agent环境配置
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAgentEnvByIds(Long[] ids);

    /**
     * 删除Agent环境配置
     *
     * @param id Agent环境配置主键
     * @return 结果
     */
    int deleteAgentEnvById(Long id);
}