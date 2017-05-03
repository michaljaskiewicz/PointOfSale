package jaskiewicz.dev.pointOfSale.output;

import jaskiewicz.dev.pointOfSale.model.Product;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public interface LCDDisplay {

    void showOnDisplay(String message);

    void showOnDisplay(Product product);
}
