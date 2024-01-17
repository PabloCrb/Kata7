package software.ulpgc.MoneyCalculator;

public class Money {
    private String amount;
    private Currency currency;

    public Money() {
    }

    public Money(String amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return this.amount + " " + this.currency;
    }
}
