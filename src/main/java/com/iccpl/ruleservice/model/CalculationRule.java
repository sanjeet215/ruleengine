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
@Table(name = "rule_table", uniqueConstraints = {@UniqueConstraint(columnNames = {"cardType", "effectiveBeginTime", "effectiveEndDate"})})
public class CalculationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;
    private String ruleDescription;
    private LocalDateTime effectiveBeginTime;
    private LocalDateTime effectiveEndDate;

    @Column(unique = true)
    private String cardType;
    private BigDecimal pointPerAmountUnit;
}
