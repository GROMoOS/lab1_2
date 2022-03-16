package pl.com.bottega.ecommerce.sales.domain.service;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;

public class InvoiceFactory {
    public static Invoice createInvoice(Id invoiceId, ClientData client){
        return new Invoice(invoiceId, client);
    }
}
