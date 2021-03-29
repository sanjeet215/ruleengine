package com.iccpl.ruleservice.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateForPointsRequests {

    private String cardType;
    private BigDecimal amount;
    private LocalDateTime transactionTime;
}
