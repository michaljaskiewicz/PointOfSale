package jaskiewicz.dev.pointOfSale.model;

import java.util.Objects;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class Money {

    private Double value;

    public Money(Double value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Money must have positive or zero value!");
        }
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null || getClass() != obj.getClass()) return false;
        final Money money = (Money) obj;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Money plus(Money money) {
        double sum = getValue() + money.getValue();
        return new Money(sum);
    }
}
