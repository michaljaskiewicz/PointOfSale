package jaskiewicz.dev.pointofsale.output;

import jaskiewicz.dev.pointofsale.logic.Bill;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public interface ReceiptPrinter {

    void printReceiptFrom(Bill bill);
}
