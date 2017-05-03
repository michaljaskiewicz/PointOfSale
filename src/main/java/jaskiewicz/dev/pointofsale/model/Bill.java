package jaskiewicz.dev.pointofsale.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public class Bill {

    private Money totalSum;
    private List<Product> products;

    public Bill() {
        totalSum = new Money(0d);
        products = new LinkedList<>();
    }

    public Money getTotalSum() {
        return totalSum;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
        totalSum = totalSum.plus(product.getPrice());
    }
}
