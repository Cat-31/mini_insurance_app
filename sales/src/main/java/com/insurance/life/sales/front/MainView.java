package com.insurance.life.sales.front;

import com.insurance.life.product.dto.PaymentTypeDTO;
import com.insurance.life.product.dto.PremiumCalculateParam;
import com.insurance.life.product.dto.ProductDTO;
import com.insurance.life.product.dto.TermDTO;
import com.insurance.life.sales.common.command.CallBack;
import com.insurance.life.sales.common.command.CommandExecutor;
import com.insurance.life.sales.common.dto.ApplicationRecordDTO;
import com.insurance.life.sales.service.command.*;
import com.insurance.life.underwriting.UnderWritingStatus;
import com.insurance.life.underwriting.dto.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Route("/main")
class MainView extends VerticalLayout {

    private CommandExecutor commandExecutor;

    MainView(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;

        add(new H1("Mini Life Insurance System"));
        add(new Hr());

        add(new H3("Customer Info"));
        HorizontalLayout customerInfo = new HorizontalLayout();
        TextField name = new TextField("Name");
        TextField age = new TextField("Age");
        TextField gender = new TextField("Gender");

        customerInfo.add(name);
        customerInfo.add(age);
        customerInfo.add(gender);

        add(customerInfo);

        add(new Hr());

        HorizontalLayout playLayout = new HorizontalLayout();

        Select<ProductDTO> product = new Select();
        product.setLabel("Product");

        commandExecutor.execute(
                new QueryAllProductCommand(),
                (CallBack<List<ProductDTO>>) o -> product.setItems(o)
        );

        product.setItemLabelGenerator(ProductDTO::getProductName);

        Select<PaymentTypeDTO> paymentType = new Select();
        paymentType.setLabel("PaymentType");
        paymentType.setItemLabelGenerator(PaymentTypeDTO::getDescription);

        Select<TermDTO> term = new Select();
        term.setLabel("Term");
        term.setItemLabelGenerator(TermDTO::getDescription);

        product.addValueChangeListener(event -> {
            commandExecutor.execute(
                new QuerySupportedTermCommand(event.getValue().getProductId()),
                (CallBack<List<TermDTO>>) o -> term.setItems(o)
            );

            commandExecutor.execute(
                    new QuerySupportedPaymentTypeCommand(event.getValue().getProductId()),
                    (CallBack<List<PaymentTypeDTO>>) o -> paymentType.setItems(o)
            );
        });

        TextField amount = new TextField("Amount");
        TextField premium = new TextField("Premium");

        premium.addFocusListener(o -> {
            PremiumCalculateParam param = new PremiumCalculateParam();
            param.setAmount(new BigDecimal(amount.getValue()));
            param.setTerm(term.getValue().getTerm());
            param.setAge(Integer.valueOf(age.getValue()));
            param.setGender(gender.getValue());
            param.setTerm(term.getValue().getTerm());
            param.setPaymentType(paymentType.getValue().getPaymentType());

            commandExecutor.execute(
                    new PremiumCalculateCommand(product.getValue().getProductId(), param),
                    (CallBack<BigDecimal>) prem -> premium.setValue(prem.toString())
            );
        });

        playLayout.add(product, term, amount, premium);
        add(playLayout);
        add(paymentType);


        Grid<ApplicationRecordDTO> grid = new Grid<>(ApplicationRecordDTO.class, false);
        grid.addColumn(ApplicationRecordDTO::getApplicationId).setHeader("Id");
        grid.addColumn(ApplicationRecordDTO::getApplicationDate).setHeader("Date");
        grid.addColumn(ApplicationRecordDTO::getStatus).setHeader("Status");


        Grid<UnPassedReason> unPassedReasonGrid = new Grid<>(UnPassedReason.class, true);


        Button button = new Button("Application");
        button.addClickListener(event -> {

            SaveApplicationRecordCommand saveApplicationRecordCommand = new SaveApplicationRecordCommand();

            ApplicantDTO applicant = new ApplicantDTO(name.getValue(), gender.getValue(), Integer.valueOf(age.getValue()));
            InsuredDTO insured = new InsuredDTO(name.getValue(), gender.getValue(), Integer.valueOf(age.getValue()));
            PlanDTO plan = new PlanDTO(product.getValue().getProductId(),
                    term.getValue().getTerm(), new BigDecimal(amount.getValue()), new BigDecimal(premium.getValue()));

            ApplicationDTO application = new ApplicationDTO();
            application.setApplicant(applicant);
            application.setInsured(insured);
            application.setPaymentType(paymentType.getValue().getPaymentType());
            application.getPlanList().add(plan);

            ApplicationCommand applicationCommand = new ApplicationCommand(application);

            commandExecutor.execute(applicationCommand, (CallBack<UnderWritingResult>) result -> {
                    saveApplicationRecordCommand.setApplicationId(result.getApplicationId());
                    saveApplicationRecordCommand.setApplicationDate(new Date());

                    if (result.isPass()) {
                        saveApplicationRecordCommand.setStatus(UnderWritingStatus.PASS);
                    } else {
                        saveApplicationRecordCommand.setStatus(UnderWritingStatus.UNPASS);
                    }

                    unPassedReasonGrid.setItems(result.getUnPassedReasonList());
                }
            );

            commandExecutor.execute(saveApplicationRecordCommand);

            commandExecutor.execute(
                    new QueryApplicationRecordCommand(),
                    (CallBack<List<ApplicationRecordDTO>>) records ->  grid.setItems(records)
            );
        });

        add(button);

        unPassedReasonGrid.setAllRowsVisible(true);
        grid.setAllRowsVisible(true);
        add(unPassedReasonGrid);
        add(grid);

        commandExecutor.execute(
                new QueryApplicationRecordCommand(),
                (CallBack<List<ApplicationRecordDTO>>) records ->  grid.setItems(records)
        );
    }
}

