package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class TaxCalculator implements ITaxCalculator {
    @Override
    public Tax getTax(ProductType productType, Money netCost) {

        String desc = null;
        BigDecimal ratio = null;

        switch (productType) {
            case DRUG:
                ratio = BigDecimal.valueOf(0.05);
                desc = "5% (D)";
                break;
            case FOOD:
                ratio = BigDecimal.valueOf(0.07);
                desc = "7% (F)";
                break;
            case STANDARD:
                ratio = BigDecimal.valueOf(0.23);
                desc = "23%";
                break;
            default:
                throw new IllegalArgumentException(productType + " not handled");
        }

        return new Tax(netCost.multiplyBy(ratio), desc);
    }
}
