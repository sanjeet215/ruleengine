package com.iccpl.ruleservice.serviceImpl;

import com.iccpl.ruleservice.dto.request.CreateRuleRequest;
import com.iccpl.ruleservice.dto.request.UpdateRuleRequest;
import com.iccpl.ruleservice.dto.response.CreateRuleResponse;
import com.iccpl.ruleservice.dto.response.RuleResponse;
import com.iccpl.ruleservice.dto.response.UpdateRuleResponse;
import com.iccpl.ruleservice.exception.InternalServerError;
import com.iccpl.ruleservice.exception.ResourceNotFoundException;
import com.iccpl.ruleservice.model.CalculationRule;
import com.iccpl.ruleservice.model.HistoricalRule;
import com.iccpl.ruleservice.repository.HistoricalRuleRepository;
import com.iccpl.ruleservice.repository.RuleRepository;
import com.iccpl.ruleservice.service.RuleServices;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class RuleServiceImpl implements RuleServices {

    @Autowired
    RuleRepository ruleRepository;

    @Autowired
    HistoricalRuleRepository historicalRuleRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public CreateRuleResponse createRuleService(CreateRuleRequest createRuleRequest) {

        try {
            CalculationRule rule = new CalculationRule();
            rule.setRuleDescription(createRuleRequest.getRuleDescription());
            rule.setEffectiveBeginTime(createRuleRequest.getEffectiveDate());
            rule.setPointPerAmountUnit(createRuleRequest.getAmount()); // Amount value for 1 point
            rule.setCardType(createRuleRequest.getCardType());
            rule.setEffectiveEndDate(LocalDateTime.now().plusYears(10));

            ruleRepository.save(rule);
        } catch (Exception exception) {
            log.error("Error while creating the rule", exception.getMessage());
            throw new InternalServerError("ERROR : Contact system admin");
        }
        return new CreateRuleResponse("Rule created successfully.");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public UpdateRuleResponse updateRuleService(UpdateRuleRequest updateRuleRequest) {

        // Step 1 : Get the record using id and then update and save
        ruleRepository.findByRuleId(updateRuleRequest.getRuleId())
                .ifPresentOrElse(record -> updateRuleRecord(record, updateRuleRequest)
                        , () -> new ResourceNotFoundException("No records found to update"));
        return new UpdateRuleResponse("Record updated successfully");

    }

    private void updateRuleRecord(CalculationRule record, UpdateRuleRequest request) {

        HistoricalRule historicalRule = new HistoricalRule();
        historicalRule.setRuleDescription(record.getRuleDescription());
        historicalRule.setCardType(record.getCardType());
        historicalRule.setEffectiveBeginTime(record.getEffectiveBeginTime());
        historicalRule.setEffectiveEndDate(record.getEffectiveEndDate());
        historicalRule.setPointPerAmountUnit(record.getPointPerAmountUnit());
        historicalRuleRepository.save(historicalRule);

        record.setRuleDescription(request.getRuleDescription());
        record.setEffectiveBeginTime(request.getEffectiveDate());
        record.setPointPerAmountUnit(BigDecimal.valueOf(request.getPoints()));
        ruleRepository.save(record);

    }

    @Override
    public List<RuleResponse> getAllRuleService() {
        return ruleRepository.findAll().stream().map(this::generateRuleResponse).collect(Collectors.toList());
    }

    private RuleResponse generateRuleResponse(CalculationRule record) {

        RuleResponse response = new RuleResponse();
        response.setRuleId(record.getRuleId());
        response.setRuleDescription(record.getRuleDescription());
        response.setEffectiveStartTime(record.getEffectiveBeginTime());
        response.setEffectiveEndTime(record.getEffectiveEndDate());
        response.setCardType(record.getCardType());
        response.setAmountUnit(record.getPointPerAmountUnit());

        return response;
    }


}
