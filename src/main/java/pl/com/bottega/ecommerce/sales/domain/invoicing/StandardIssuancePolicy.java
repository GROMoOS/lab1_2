package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.HashMap;

public class StandardIssuancePolicy implements IssuancePolicy {

    static HashMap<ProductType, BigDecimal> ratioMap;
    static HashMap<ProductType, String> descMap;
    static {
        ratioMap = new HashMap<>();
        ratioMap.put(ProductType.DRUG, BigDecimal.valueOf(0.05));
        ratioMap.put(ProductType.FOOD, BigDecimal.valueOf(0.07));
        ratioMap.put(ProductType.STANDARD, BigDecimal.valueOf(0.23));

        descMap = new HashMap<>();
        descMap.put(ProductType.DRUG, "5% (D)");
        descMap.put(ProductType.FOOD, "7% (F)");
        descMap.put(ProductType.STANDARD, "23%");
    }

    public Money countTaxValue(RequestItem item) {
        BigDecimal ratio = ratioMap.get(item.getProductData().getType());
        if (ratio == null)
            throw new IllegalArgumentException(item.getProductData().getType() + " not handled");

        return item.getTotalCost().multiplyBy(ratio);
    }

    @Override
    public Tax getTax(RequestItem item) {
        return new Tax(countTaxValue(item), descMap.get(item.getProductData().getType()));
    }
}