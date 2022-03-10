import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class PaymentFactory {
    public Payment newPayment(ClientData clientData, Money amount)
    {
        return new Payment(Id.generate(), clientData, amount);
    }
}
