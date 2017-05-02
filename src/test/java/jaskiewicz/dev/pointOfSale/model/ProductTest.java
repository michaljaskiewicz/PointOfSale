package jaskiewicz.dev.pointOfSale.model;

import jaskiewicz.dev.pointOfSale.model.exceptions.EmptyBarcodeException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class ProductTest {

    @Test
    public void  should_create_product_with_given_values() {
        // given
        final Barcode barcode = new Barcode("123456789");
        final String name = "Milk";
        final Money price = new Money(2.99);
        // when
        Product product = new Product(barcode, name, price);
        // then
        assertEquals(barcode, product.getBarcode());
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void  should_not_create_product_without_barcode() {
        // given
        final Barcode barcode = null;
        final String name = "Milk";
        final Money price = new Money(2.99);
        // when
        try {
            new Product(barcode, name, price);
            fail("Should not create product without barcode");
        } catch (EmptyBarcodeException e) {
            // then pass
        }
    }

    @Test
    public void  should_not_create_product_without_name() {
        // given
        final Barcode barcode = new Barcode("123456789");
        final String name = null;
        final Money price = new Money(2.99);
        // when
        try {
            new Product(barcode, name, price);
            fail("Should not create product without name");
        } catch (IllegalArgumentException e) {
            // then pass
        }
    }

    @Test
    public void  should_not_create_product_without_price() {
        // given
        final Barcode barcode = new Barcode("123456789");
        final String name = "Milk";
        final Money price = null;
        // when
        try {
            new Product(barcode, name, price);
            fail("Should not create product without price");
        } catch (IllegalArgumentException e) {
            // then pass
        }
    }

    @Test
    public void should_products_with_same_values_be_equal() {
        // given
        final Barcode barcode = new Barcode("123456789");
        final String name = "Milk";
        final Money price = new Money(2.99);
        // when
        Product product = new Product(barcode, name, price);
        Product productWithSameValues = new Product(barcode, name, price);
        // then
        assertEquals(product, productWithSameValues);
    }


}