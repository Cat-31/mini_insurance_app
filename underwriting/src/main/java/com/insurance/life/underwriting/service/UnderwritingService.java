package com.insurance.life.underwriting.service;

import com.insurance.life.underwriting.dto.ApplicationDTO;
import com.insurance.life.underwriting.dto.UnPassedReason;
import com.insurance.life.underwriting.dto.UnderWritingResult;
import com.insurance.life.underwriting.entity.Application;
import com.insurance.life.underwriting.repository.ApplicationRepository;
import com.insurance.life.underwriting.service.rule.RuleManager;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnderwritingService {
    private RuleManager ruleManager;
    private ApplicationRepository repository;

    public UnderwritingService(RuleManager ruleManager, ApplicationRepository repository) {
        this.ruleManager = ruleManager;
        this.repository = repository;
    }

    public UnderWritingResult createAndCheck(ApplicationDTO application) {
        UnderWritingResult result = new UnderWritingResult();

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Application entity = mapper.map(application, Application.class);

        List<UnPassedReason>  unPassedReasons = ruleManager.getRuleList()
                .stream().map(item -> item.check(entity)
        ).filter(unPassedReason ->  unPassedReason != null).collect(Collectors.toList());

        repository.save(entity);

        result.setUnPassedReasonList(unPassedReasons);
        result.setApplicationId(entity.getId().toString());

        return result;
    }
}
