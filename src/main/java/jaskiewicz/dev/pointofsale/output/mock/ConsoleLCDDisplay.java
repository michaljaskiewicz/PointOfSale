package jaskiewicz.dev.pointofsale.output.mock;

import jaskiewicz.dev.pointofsale.model.Product;
import jaskiewicz.dev.pointofsale.output.LCDDisplay;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public class ConsoleLCDDisplay implements LCDDisplay {

    @Override
    public void showOnDisplay(String message) {
        System.out.println(message);
    }

    @Override
    public void showOnDisplay(Product product) {
        String productName = product.getName();
        String productPrice = product.getPrice().getValue().toString();
        System.out.println(productName + " - " + productPrice);
    }
}
