package com.iccpl.ruleservice.repository;

import com.iccpl.ruleservice.model.CalculationRule;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<CalculationRule, Long> {

    Optional<CalculationRule> findByRuleId(long ruleId);
}
