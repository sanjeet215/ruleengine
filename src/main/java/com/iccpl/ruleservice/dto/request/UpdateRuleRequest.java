package com.iccpl.ruleservice.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRuleRequest {

    private Long ruleId;
    private String ruleDescription;
    private String cardType;
    private LocalDateTime effectiveDate;
    private BigDecimal amount;
    private int points;
}
