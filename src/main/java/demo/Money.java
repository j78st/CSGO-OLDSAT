package demo;

import java.util.Objects;

public class Money {
    public int amount;
    public String currency;

    public Money(int inAmount, String inCurrency){
        this.amount = inAmount;
        this.currency = inCurrency;
    }

    public Money add(Money that) {
        return new Money(this.amount+that.amount,this.currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
