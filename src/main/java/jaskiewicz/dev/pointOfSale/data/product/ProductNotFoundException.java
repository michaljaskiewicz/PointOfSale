package jaskiewicz.dev.pointOfSale.data.product;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
