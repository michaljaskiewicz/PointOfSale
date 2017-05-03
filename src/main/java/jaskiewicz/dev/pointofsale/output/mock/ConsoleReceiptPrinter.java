package jaskiewicz.dev.pointofsale.output.mock;

import jaskiewicz.dev.pointofsale.logic.Bill;
import jaskiewicz.dev.pointofsale.model.Product;
import jaskiewicz.dev.pointofsale.output.ReceiptPrinter;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public class ConsoleReceiptPrinter implements ReceiptPrinter {

    @Override
    public void printReceiptFrom(Bill bill) {
        System.out.println("Receipt:");
        bill.getProducts().forEach(this::print);
        System.out.println("Total: " + bill.getTotalSum());
    }

    private void print(Product product) {
        System.out.println(product.getName() + " = " + product.getPrice());
    }
}
