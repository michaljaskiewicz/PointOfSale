package jaskiewicz.dev.pointofsale.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class MoneyTest {

    @Test
    public void test_fractional_part_calculating() {
        // given
        final Double value = 11.78;
        final int expectedFractionalPart = 78;
        // when
        final Money money = new Money(value);
        // then
        assertEquals(expectedFractionalPart, money.getFractionalPartOf(value));
    }

    @Test
    public void should_create_money_with_given_value() {
        // given
        final Double value = 2.54;
        // when
        Money money = new Money(value);
        // then
        assertEquals(value, money.getValue());
    }

    @Test
    public void should_not_create_money_without_value() {
        // given
        final Double value = null;
        // when
        try {
            new Money(value);
            fail("Should not create money without value!");
        } catch (Exception e) {
            // then pass
        }
    }

    @Test
    public void should_not_create_money_with_negative_value() {
        // given
        final Double value = -34.71;
        // when
        try {
            new Money(value);
            fail("Should not create money with negative value!");
        } catch (Exception e) {
            // then pass
        }
    }

    @Test
    public void should_money_with_same_value_be_equal() {
        // given
        final Double value = 2.54;
        // when
        final Money money = new Money(value);
        final Money moneyWithSameValue = new Money(value);
        // then
        assertEquals(money, moneyWithSameValue);
    }

    @Test
    public void should_be_possible_to_add_money() {
        // given
        final Double value = 17.89;
        final Money money = new Money(value);
        final Double anotherValue = 2.99;
        final Money anotherMoney = new Money(anotherValue);
        // when
        final Money sum = money.plus(anotherMoney);
        // then
        assertEquals(new Money(value + anotherValue), sum);
    }

    @Test
    public void should_be_possible_to_add_money_with_bigger_values() {
        // given
        final Double value = 17273.89;
        final Money money = new Money(value);
        final Double anotherValue = 2090808.99;
        final Money anotherMoney = new Money(anotherValue);
        final double result = 2108082.88;
        // when
        final Money sum = money.plus(anotherMoney);
        // then
        assertEquals(new Money(result), sum);
    }
}
