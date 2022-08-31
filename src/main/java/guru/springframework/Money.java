package guru.springframework;

import java.util.Objects;

public abstract class Money {
    protected int amount;

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public abstract Money times(int multiplier);

    public static Money franc(int amount) {
        return new Franc(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amount == money.amount && this.getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
