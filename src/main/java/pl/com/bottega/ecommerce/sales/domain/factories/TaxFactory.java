package pl.com.bottega.ecommerce.sales.domain.factories;

import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.HashMap;

public class TaxFactory {

    public static HashMap<ProductType, Double> defaultTaxRatio = new HashMap<>();

    static {
        defaultTaxRatio.put(ProductType.DRUG, 0.05);
        defaultTaxRatio.put(ProductType.FOOD, 0.07);
        defaultTaxRatio.put(ProductType.STANDARD, 0.23);
    }

    public static Tax generateTax(ProductType productType, Money money) {
        return generateTax(productType, money, defaultTaxRatio);
    }

    public static Tax generateTax(ProductType productType, Money money, HashMap<ProductType, Double> taxRatio) {
        if (!taxRatio.containsKey(productType)) {
            throw new IllegalArgumentException(productType + " not handled");
        }

        Double ratio = taxRatio.get(productType);
        Money taxValue = money.multiplyBy(ratio);
        ratio *= 100;
        String desc = ratio.intValue() + "";
        if (productType != ProductType.STANDARD) {
            desc += " (" + productType.toString() + ")";
        }
        return new Tax(taxValue, desc);
    }

}
