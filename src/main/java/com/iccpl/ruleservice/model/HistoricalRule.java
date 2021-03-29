package com.iccpl.ruleservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historical_rule", uniqueConstraints = {@UniqueConstraint(columnNames = {"cardType", "effectiveBeginTime", "effectiveEndDate"})})
public class HistoricalRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleDescription;
    private LocalDateTime effectiveBeginTime;
    private LocalDateTime effectiveEndDate;
    private String cardType;
    private BigDecimal pointPerAmountUnit;
}
