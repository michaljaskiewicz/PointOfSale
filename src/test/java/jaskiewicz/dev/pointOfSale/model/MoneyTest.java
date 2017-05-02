package jaskiewicz.dev.pointOfSale.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class MoneyTest {

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
}
