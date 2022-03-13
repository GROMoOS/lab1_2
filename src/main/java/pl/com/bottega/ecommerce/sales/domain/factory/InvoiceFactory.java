package pl.com.bottega.ecommerce.sales.domain.factory;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;

public class InvoiceFactory {

    public static Invoice getInvoice(Id invoiceId, ClientData client) {
        return new Invoice(invoiceId,client);
    }
}
