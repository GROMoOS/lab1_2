public class InvoiceFactory {
    public Invoice newInvoice(ClientData client)
    {
        return new Invoice(Id.generate, client);
    }
}
