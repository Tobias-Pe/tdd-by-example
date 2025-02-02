package guru.springframework;

import java.util.Objects;

public class Money implements Expression {
    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currencyToString() {
        return this.currency;
    }

    public Expression times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return this.amount == money.amount && Objects.equals(this.currency, money.currency);
    }

    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount +
            ", currency='" + currency + '\'' +
            '}';
    }

    @Override
    public Expression plus(Expression money) {
        return new Sum(this, money);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(this.amount / bank.rate(this.currency, to), to);
    }
}
