package com.insurance.life.sales.front;

import com.insurance.life.sales.remote.ProductService;
import com.insurance.life.sales.remote.UnderwritingService;
import com.insurance.life.sales.remote.dto.PaymentTypeOption;
import com.insurance.life.sales.remote.dto.PremiumCalculateParam;
import com.insurance.life.sales.remote.dto.ProductOption;
import com.insurance.life.sales.remote.dto.TermOption;
import com.insurance.life.sales.service.SalesService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.math.BigDecimal;

@Route("/main")
class MainView extends VerticalLayout {

    private SalesService salesService;
    private ProductService productService;
    private UnderwritingService underwritingService;

    MainView(SalesService salesService, ProductService productService, UnderwritingService underwritingService) {
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

        HorizontalLayout plan = new HorizontalLayout();

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
        plan.add(product, term, amount, premium);
        add(plan);

        add(paymentType);
    }
}

