package com.insurance.life.sales.front;

import com.insurance.life.sales.entity.ApplicationRecord;
import com.insurance.life.sales.front.vo.ApplicationRecordVO;
import com.insurance.life.sales.remote.ProductService;
import com.insurance.life.sales.remote.UnderwritingService;
import com.insurance.life.sales.remote.dto.PaymentTypeOption;
import com.insurance.life.sales.remote.dto.PremiumCalculateParam;
import com.insurance.life.sales.remote.dto.ProductOption;
import com.insurance.life.sales.remote.dto.TermOption;
import com.insurance.life.sales.repository.ApplicationRecordRepository;
import com.insurance.life.sales.service.SalesService;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Route("/main")
class MainView extends VerticalLayout {

    // bad smell
    private SalesService salesService;
    private ProductService productService;
    private UnderwritingService underwritingService;
    private ApplicationRecordRepository repository;

    MainView(SalesService salesService,
             ProductService productService,
             UnderwritingService underwritingService,
             ApplicationRecordRepository repository) {

        this.salesService = salesService;
        this.productService = productService;
        this.underwritingService = underwritingService;

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

        Select<ProductOption> product = new Select();
        product.setLabel("Product");
        product.setItems(productService.queryAllProduct().getBody());
        product.setItemLabelGenerator(ProductOption::getProductName);

        Select<PaymentTypeOption> paymentType = new Select();
        paymentType.setLabel("PaymentType");

        Select<TermOption> term = new Select();
        term.setLabel("Term");
        product.addValueChangeListener(event -> {
            term.setItems(productService.querySupportedTerm(event.getValue().getProductId()).getBody());
            term.setItemLabelGenerator(TermOption::getDescription);

            paymentType.setItems(productService.querySupportedPaymentType(event.getValue().getProductId()).getBody());
            paymentType.setItemLabelGenerator(PaymentTypeOption::getDescription);

        });

        TextField amount = new TextField("Amount");
        TextField premium = new TextField("Premium");

        premium.addFocusListener(o -> {
            PremiumCalculateParam param = new PremiumCalculateParam();
            // param.setAge(age);
            param.setAmount(new BigDecimal(amount.getValue()));
            param.setTerm(term.getValue().getTerm());
            param.setPaymentType(param.getPaymentType());
            param.setAge(Integer.valueOf(age.getValue()));
            param.setGender(gender.getValue());
            param.setTerm(term.getValue().getTerm());
            param.setPaymentType(paymentType.getValue().getPaymentType());

            BigDecimal prem = productService.premiumCalculate(
                    product.getValue().getProductId(), param).getBody();
            premium.setValue(prem.toString());
        });
        playLayout.add(product, term, amount, premium);
        add(playLayout);
        add(paymentType);


        Grid<ApplicationRecordVO> grid = new Grid<>(ApplicationRecordVO.class, false);
        grid.addColumn(ApplicationRecordVO::getApplicationId).setHeader("Id");
        grid.addColumn(ApplicationRecordVO::getApplicationDate).setHeader("Date");
        grid.addColumn(ApplicationRecordVO::getStatus).setHeader("Status");



        Button button = new Button("Application");
        button.addClickListener(event -> {

            ApplicationRecord record = new ApplicationRecord();

            Applicant applicant = new Applicant(name.getValue(), gender.getValue(), Integer.valueOf(age.getValue()));
            Insured insured = new Insured(name.getValue(), gender.getValue(), Integer.valueOf(age.getValue()));
            Plan plan = new Plan(product.getValue().getProductId(),
                    term.getValue().getTerm(), new BigDecimal(amount.getValue()), new BigDecimal(premium.getValue()));

            Application application = new Application();
            application.setApplicant(applicant);
            application.setInsured(insured);
            application.setPaymentType(paymentType.getValue().getPaymentType());
            application.getPlanList().add(plan);
            UnderWritingResult result = underwritingService.application(application).getBody();

            record.setApplicationId(result.getApplicationId());
            record.setApplicationDate(new Date());

            if (result.isPass()) {
                record.setStatus(UnderWritingStatus.PASS);
            } else {
                record.setStatus(UnderWritingStatus.UNPASS);
            }
            repository.save(record);

            showRecords(repository, grid);
        });

        add(button);
        add(grid);

        showRecords(repository, grid);
    }

    private static void showRecords(ApplicationRecordRepository repository, Grid<ApplicationRecordVO> grid) {
        List<ApplicationRecordVO> records = new ArrayList<>();
        repository.findAll().forEach(
                item -> records.add(new ApplicationRecordVO(item.getApplicationId(),
                        item.getStatus().getDescription(),
                        new SimpleDateFormat("yyyy/MM/dd").format(item.getApplicationDate()))));

        grid.setItems(records);
    }
}

