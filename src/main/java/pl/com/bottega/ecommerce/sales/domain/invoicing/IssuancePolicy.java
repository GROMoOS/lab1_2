package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface IssuancePolicy {
    Tax getTax(RequestItem item);
}
