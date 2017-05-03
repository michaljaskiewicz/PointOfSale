package jaskiewicz.dev.pointOfSale.data;

import jaskiewicz.dev.pointOfSale.data.product.ProductNotFoundException;
import jaskiewicz.dev.pointOfSale.data.product.ProductProvider;
import jaskiewicz.dev.pointOfSale.dependencies.DependencyProvider;
import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.Money;
import jaskiewicz.dev.pointOfSale.model.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class ProductProviderTest {

    private ProductProvider database;

    @Before
    public void setup() {
        database = DependencyProvider.provideProductProvider();
    }

    @Test
    public void should_provide_product_with_given_barcode_when_it_is_in_database() {
        // given
        final Barcode barcode = new Barcode("a1a1a1a1a1");
        final String name = "Potato chips";
        final Money price = new Money(2.49);
        // when
        final Product product = database.provideProductWith(barcode);
        // then
        assertEquals(barcode, product.getBarcode());
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void should_throw_exception_when_there_is_no_product_with_given_barcode_in_database() {
        // given
        final Barcode barcode = new Barcode("qwertyuiop");
        // when
        try {
            database.provideProductWith(barcode);
            fail("Should throw an exception when there is no product with given barcode in database!");
        } catch (ProductNotFoundException e) {
            // then pass
        }
    }
}
