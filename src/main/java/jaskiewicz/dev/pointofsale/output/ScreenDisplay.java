package jaskiewicz.dev.pointofsale.output;

import jaskiewicz.dev.pointofsale.logic.Bill;
import jaskiewicz.dev.pointofsale.model.Product;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public interface ScreenDisplay {

    void showOnDisplay(String message);

    void showOnDisplay(Product product);

    void showTotalSumFor(Bill bill);
}
