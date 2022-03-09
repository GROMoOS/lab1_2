package pl.com.bottega.ecommerce.sales.domain.service;

import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxCalculator;

public class TaxCalculatorFactory {
    public static TaxCalculator createTaxCalculator(){
        return new TaxCalculator();
    }
}
