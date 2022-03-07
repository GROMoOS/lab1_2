package pl.com.bottega.ecommerce.sales.domain.factory;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class Factory {
    public static Invoice getInvoice(Id invoiceId, ClientData client) {
        return new Invoice(invoiceId, client);
    }

    public static Payment getPayment(Id aggregateId, ClientData clientData, Money amount) {
        return new Payment(aggregateId, clientData, amount);
    }
}
