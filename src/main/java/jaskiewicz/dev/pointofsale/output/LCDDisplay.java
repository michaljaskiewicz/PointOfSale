package jaskiewicz.dev.pointofsale.output;

import jaskiewicz.dev.pointofsale.model.Product;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public interface LCDDisplay {

    void showOnDisplay(String message);

    void showOnDisplay(Product product);
}
