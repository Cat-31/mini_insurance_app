package com.insurance.life.sales.front;

import com.insurance.life.sales.remote.ProductService;
import com.insurance.life.sales.remote.UnderwritingService;
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
        customerInfo.add(new TextField("Name"));
        customerInfo.add(new TextField("Age"));
        customerInfo.add(new TextField("Gender"));

        add(customerInfo);

        add(new Hr());

        HorizontalLayout plan = new HorizontalLayout();

        Select<ProductOption> product = new Select();
        product.setLabel("Product");
        product.setItems(productService.queryAllProduct().getBody());
        product.setItemLabelGenerator(ProductOption::getProductName);


        Select<TermOption> term = new Select();
        term.setLabel("Term");
        product.addValueChangeListener(event -> {
            term.setItems(productService.querySupportedTerm(event.getValue().getProductId()).getBody());
            term.setItemLabelGenerator(TermOption::getDescription);
        });

        TextField amount = new TextField("Amount");
        TextField premium = new TextField("Premium");
        premium.addFocusListener(o -> {
            BigDecimal prem = salesService.calculatePremium(
                    product.getValue().getProductId(), new BigDecimal(amount.getValue()));

            o.getSource().setValue(prem.toString());
        });
        plan.add(product, term, amount, premium);
        add(plan);

    }
}

