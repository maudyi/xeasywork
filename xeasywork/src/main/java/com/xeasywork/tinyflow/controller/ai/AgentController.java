package com.xeasywork.tinyflow.controller.ai;

import com.xeasywork.tinyflow.common.core.controller.BaseController;
import com.xeasywork.tinyflow.common.core.domain.AjaxResult;
import com.xeasywork.tinyflow.domain.ai.AgentEnv;
import com.xeasywork.tinyflow.service.ai.IAgentEnvService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Agent环境配置Controller
 */
@RestController
@RequestMapping("/ai/console/agent")
public class AgentController extends BaseController {

    @Resource
    private IAgentEnvService agentEnvService;

    /**
     * 根据ID获取Agent环境配置
     */
    @PreAuthorize("@ss.hasPermi('ai:agent:env:query')")
    @GetMapping("/env/{id}")
    public AjaxResult getAgentEnv(@PathVariable("id") Long id) {
        return success(agentEnvService.selectAgentEnvById(id));
    }
}