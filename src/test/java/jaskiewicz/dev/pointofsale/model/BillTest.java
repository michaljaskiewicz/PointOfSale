package jaskiewicz.dev.pointofsale.model;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public class BillTest {

    @Test
    public void should_create_bill_with_no_products_and_zero_total_sum() {
        // given
        final Double value = 0d;
        final Money totalSum = new Money(value);
        // when
        final Bill bill = new Bill();
        // then
        assertEquals(totalSum, bill.getTotalSum());
        assertEquals(Collections.emptyList(), bill.getProducts());
    }

    @Test
    public void should_be_possible_to_add_products_and_calculate_total_sum() {
        // given
        final Bill bill = new Bill();
        final Product p1 = new Product(new Barcode("c3c3c3c3c3"), "Frozen pizza", new Money(10.49));
        final Product p2 = new Product(new Barcode("4444444444"), "Eggs 6-pack", new Money(10.00));
        // when
        bill.add(p1);
        bill.add(p2);
        // then
        assertEquals(new Money(20.49), bill.getTotalSum());
    }

    @Test
    public void should_be_possible_to_add_many_products_and_calculate_total_sum() {
        // given
        final Bill bill = new Bill();
        final Product p1 = new Product(new Barcode("c3c3c3c3c3"), "Frozen pizza", new Money(10.49));
        final Product p2 = new Product(new Barcode("4444444444"), "Eggs 6-pack", new Money(10.00));
        final Product p3 = new Product(new Barcode("c3c3c3c3c3"), "Frozen pizza", new Money(10.49));
        final Product p4 = new Product(new Barcode("4444444444"), "Eggs 6-pack", new Money(10.00));
        final Product p5 = new Product(new Barcode("c3c3c3c3c3"), "Frozen pizza", new Money(10.49));
        final Product p6 = new Product(new Barcode("4444444444"), "Eggs 6-pack", new Money(10.00));
        final Product p7 = new Product(new Barcode("c3c3c3c3c3"), "Frozen pizza", new Money(10.49));
        final Product p8 = new Product(new Barcode("4444444444"), "Eggs 6-pack", new Money(10.00));
        // when
        bill.add(p1);
        bill.add(p2);
        bill.add(p3);
        bill.add(p4);
        bill.add(p5);
        bill.add(p6);
        bill.add(p7);
        bill.add(p8);
        // then
        assertEquals(new Money(81.96).getValue(), bill.getTotalSum().getValue());
    }
}