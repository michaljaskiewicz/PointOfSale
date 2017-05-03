package jaskiewicz.dev.pointofsale.model;

import java.util.Objects;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class Money {

    private int integerPart;
    private int fractionalPart;

    public Money(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Money must have positive or zero value!");
        }
        integerPart = (int)value;
        fractionalPart = getFractionalPartOf(value);
    }

    private Money(int integerPart, int fractionalPart) {
        this.integerPart = integerPart;
        this.fractionalPart = fractionalPart;
    }

    protected int getFractionalPartOf(double value) {
        return (int) (value * 100) % 100;
    }

    public Money plus(Money money) {
        int sumOfFractionalParts = fractionalPart + money.fractionalPart;
        int sumOfIntegerParts = integerPart + money.integerPart;
        int integerPartOfSum = sumOfIntegerParts + sumOfFractionalParts/100;
        int fractionalPartOfSum = sumOfFractionalParts % 100;
        return new Money(integerPartOfSum, fractionalPartOfSum);
    }

    public Double getValue() {
        return integerPart + (double)fractionalPart/100d;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", integerPart, fractionalPart);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null || getClass() != obj.getClass()) return false;
        final Money money = (Money) obj;
        return integerPart == money.integerPart
                && fractionalPart == money.fractionalPart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(integerPart, fractionalPart);
    }
}
