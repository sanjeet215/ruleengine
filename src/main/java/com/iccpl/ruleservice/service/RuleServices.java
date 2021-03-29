package com.iccpl.ruleservice.service;

import com.iccpl.ruleservice.dto.request.CreateRuleRequest;
import com.iccpl.ruleservice.dto.request.UpdateRuleRequest;
import com.iccpl.ruleservice.dto.response.CreateRuleResponse;
import com.iccpl.ruleservice.dto.response.RuleResponse;
import com.iccpl.ruleservice.dto.response.UpdateRuleResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface RuleServices {

    CreateRuleResponse createRuleService(CreateRuleRequest createRuleRequest);

    UpdateRuleResponse updateRuleService(UpdateRuleRequest updateRuleRequest);

    List<RuleResponse> getAllRuleService();

}
