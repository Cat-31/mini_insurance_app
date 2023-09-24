package com.insurance.life.sales.service;

import com.insurance.life.sales.common.command.BaseCommandHandler;
import com.insurance.life.sales.common.command.CommandHandler;
import com.insurance.life.sales.common.dto.ApplicationRecordDTO;
import com.insurance.life.sales.entity.ApplicationRecord;
import com.insurance.life.sales.repository.ApplicationRecordRepository;
import com.insurance.life.sales.service.command.QueryApplicationRecordCommand;
import com.insurance.life.sales.service.command.SaveApplicationRecordCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class SalesCommadHandler implements BaseCommandHandler {
    private ApplicationRecordRepository repository;

    public SalesCommadHandler(ApplicationRecordRepository repository) {
        this.repository = repository;
    }

    @CommandHandler
    public List<ApplicationRecordDTO> onQueryApplicationRecordCommand(QueryApplicationRecordCommand command) {
        List<ApplicationRecordDTO> records = new ArrayList<>();
        repository.findAll().forEach(
                item -> records.add(new ApplicationRecordDTO(item.getApplicationId(),
                        item.getStatus().getDescription(),
                        new SimpleDateFormat("yyyy/MM/dd").format(item.getApplicationDate()))));
        return records;
    }

    @CommandHandler
    public void onSaveApplicationRecordCommand(SaveApplicationRecordCommand command) {
        ApplicationRecord applicationRecord = new ApplicationRecord();
        BeanUtils.copyProperties(command, applicationRecord);
        repository.save(applicationRecord);
    }
}
