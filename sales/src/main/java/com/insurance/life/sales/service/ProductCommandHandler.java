package com.insurance.life.sales.service;

import com.insurance.life.product.dto.PaymentTypeDTO;
import com.insurance.life.product.dto.ProductDTO;
import com.insurance.life.product.dto.TermDTO;
import com.insurance.life.sales.common.command.BaseCommandHandler;
import com.insurance.life.sales.common.command.CommandHandler;
import com.insurance.life.sales.remote.ProductService;
import com.insurance.life.sales.service.command.PremiumCalculateCommand;
import com.insurance.life.sales.service.command.QueryAllProductCommand;
import com.insurance.life.sales.service.command.QuerySupportedPaymentTypeCommand;
import com.insurance.life.sales.service.command.QuerySupportedTermCommand;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductCommandHandler implements BaseCommandHandler {

    private ProductService productService;

    public ProductCommandHandler(ProductService productService) {
        this.productService = productService;
    }

    @CommandHandler
    public List<TermDTO> onQuerySupportedTermCommand(QuerySupportedTermCommand cmd) {
        return productService.querySupportedTerm(cmd.getProductId()).getBody();
    }

    @CommandHandler
    public List<PaymentTypeDTO> onQuerySupportedPaymentTypeCommand(QuerySupportedPaymentTypeCommand cmd) {
        return productService.querySupportedPaymentType(cmd.getProductId()).getBody();
    }

    @CommandHandler
    public List<ProductDTO> onQueryAllProduct(QueryAllProductCommand cmd) {
        return productService.queryAllProduct().getBody();
    }

    @CommandHandler
    public BigDecimal onPremiumCalculateCommand(PremiumCalculateCommand cmd) {
        return productService.premiumCalculate(cmd.getProductId(), cmd.getParam()).getBody();
    }
}
