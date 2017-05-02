package jaskiewicz.dev.pointOfSale.data.product;

import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.Money;
import jaskiewicz.dev.pointOfSale.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class MockProductsDatabase implements ProductProvider {

    private static final int INITIAL_PRODUCTS_AMOUNT = 10;
    private List<Product> products;

    public MockProductsDatabase() {
        products = new ArrayList<>(INITIAL_PRODUCTS_AMOUNT);
        products.add(createProductWith("9876543210", "Milk", 2.99));
        products.add(createProductWith("1111111111", "Chocolate", 4.99));
        products.add(createProductWith("2222222222", "Kitkat", 0.99));
        products.add(createProductWith("3333333333", "Bread", 1.99));
        products.add(createProductWith("a1a1a1a1a1", "Potato chips", 2.49));
        products.add(createProductWith("b2b2b2b2b2", "Milkshake", 2.99));
        products.add(createProductWith("c3c3c3c3c3", "Frozen pizza", 10.49));
        products.add(createProductWith("0123456789", "Cheese", 8.45));
        products.add(createProductWith("4444444444", "Eggs 6-pack", 10.00));
        products.add(createProductWith("5555555555", "Butter", 3.99));
    }

    private Product createProductWith(String barcode, String name, Double price) {
        Barcode productBarcode = new Barcode(barcode);
        Money productPrice = new Money(price);
        return new Product(productBarcode, name, productPrice);
    }

    @Override
    public Product provideProductWith(Barcode barcode) throws ProductNotFoundException{
        Optional<Product> product = products.stream()
                .filter(p -> p.getBarcode().equals(barcode))
                .findAny();
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Product with " + barcode + " barcode not found in database!");
        }
    }
}
