package enums;

public enum PaymentMethods {
    PAY_BY_BANK_WIRE("BANK-WIRE PAYMENT."),
    PAY_BY_CHECK("CHECK PAYMENT");

    public String methodName;

    PaymentMethods(String metthodName) {
        this.methodName = metthodName;
    }

}
