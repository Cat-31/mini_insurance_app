package com.insurance.life.sales.front;

import com.insurance.life.sales.remote.ProductService;
import com.insurance.life.sales.remote.UnderwritingService;
import com.insurance.life.sales.service.SalesService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/main")
class MainView extends VerticalLayout {

    private SalesService salesService;
    private ProductService productService;
    private UnderwritingService underwritingService;

    MainView(SalesService salesService, ProductService productService, UnderwritingService underwritingService) {
        this.salesService = salesService;
        this.productService = productService;
        this.underwritingService = underwritingService;

        Button button = new Button("Test Product");
        button.addClickListener(o -> {
            o.getSource().setText(productService.ok() + (int) (Math.random()*100));
        });

        add(button);

        button = new Button("Test Underwriting");
        button.addClickListener(o -> {
            o.getSource().setText(underwritingService.ok() + (int) (Math.random()*100));
        });

        add(button);
    }
}

