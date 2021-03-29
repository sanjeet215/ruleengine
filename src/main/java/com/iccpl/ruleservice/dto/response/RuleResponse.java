package com.iccpl.ruleservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleResponse {

    private Long ruleId;
    private String ruleDescription;
    private LocalDateTime effectiveStartTime;
    private LocalDateTime effectiveEndTime;
    private String cardType;
    private BigDecimal amountUnit;
}
