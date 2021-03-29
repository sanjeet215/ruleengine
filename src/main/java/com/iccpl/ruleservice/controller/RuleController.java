package com.iccpl.ruleservice.controller;

import com.iccpl.ruleservice.dto.request.CreateRuleRequest;
import com.iccpl.ruleservice.dto.request.UpdateRuleRequest;
import com.iccpl.ruleservice.dto.response.CreateRuleResponse;
import com.iccpl.ruleservice.dto.response.RuleResponse;
import com.iccpl.ruleservice.dto.response.UpdateRuleResponse;
import com.iccpl.ruleservice.service.RuleServices;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ruleService")
@Slf4j
public class RuleController {

    @Autowired
    RuleServices ruleService;

    @PostMapping("/rule")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRuleResponse createRuleForCreditCard(@Validated @RequestBody CreateRuleRequest createRuleRequest) {
        return ruleService.createRuleService(createRuleRequest);
    }

    @GetMapping("/rule")
    @ResponseStatus(HttpStatus.OK)
    public List<RuleResponse> getAllRuleResponse() {
        return ruleService.getAllRuleService();
    }

    @PutMapping("/rule")
    @ResponseStatus(HttpStatus.OK)
    public UpdateRuleResponse updateRuleForCreditCardEvaluation(@Validated @RequestBody UpdateRuleRequest updateRuleRequest) {
        return ruleService.updateRuleService(updateRuleRequest);
    }
}
