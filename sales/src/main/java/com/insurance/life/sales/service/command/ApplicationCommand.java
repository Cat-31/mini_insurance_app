package com.insurance.life.sales.service.command;

import com.insurance.life.sales.common.command.Command;
import com.insurance.life.underwriting.dto.ApplicationDTO;

public class ApplicationCommand implements Command {
    private ApplicationDTO application;

    public ApplicationCommand(ApplicationDTO application) {
        this.application = application;
    }

    public ApplicationDTO getApplication() {
        return application;
    }
}
