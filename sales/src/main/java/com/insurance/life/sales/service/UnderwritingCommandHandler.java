package com.insurance.life.sales.service;

import com.insurance.life.sales.common.command.BaseCommandHandler;
import com.insurance.life.sales.common.command.CommandHandler;
import com.insurance.life.sales.remote.UnderwritingService;
import com.insurance.life.sales.service.command.ApplicationCommand;
import com.insurance.life.underwriting.dto.UnderWritingResult;
import org.springframework.stereotype.Component;

@Component
public class UnderwritingCommandHandler implements BaseCommandHandler {

    private UnderwritingService underwritingService;

    public UnderwritingCommandHandler(UnderwritingService underwritingService) {
        this.underwritingService = underwritingService;
    }

    @CommandHandler
    public UnderWritingResult onApplicationCommand(ApplicationCommand cmd) {
        return underwritingService.application(cmd.getApplication()).getBody();
    }
}
