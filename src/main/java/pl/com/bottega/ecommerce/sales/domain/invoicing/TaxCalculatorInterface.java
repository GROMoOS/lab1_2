package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxCalculatorInterface {
    Tax calculateTax(RequestItem item);
}
