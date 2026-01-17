package com.xeasywork.tinyflow.domain.ai;

import com.xeasywork.tinyflow.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Agent环境配置对象 agent_env
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AgentEnv extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 环境ID
     */
    private Long id;

    /**
     * 环境名称
     */
    private String name;

    /**
     * 环境描述
     */
    private String description;

    /**
     * 环境配置
     */
    private String config;

    /**
     * 状态（0正常 1停用）
     */
    private String status;
}