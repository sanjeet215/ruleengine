package com.iccpl.ruleservice.repository;

import com.iccpl.ruleservice.model.HistoricalRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalRuleRepository extends JpaRepository<HistoricalRule, Long> {
}
