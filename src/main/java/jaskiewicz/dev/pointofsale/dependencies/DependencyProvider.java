package jaskiewicz.dev.pointofsale.dependencies;

import jaskiewicz.dev.pointofsale.data.product.mock.MockProductsDatabase;
import jaskiewicz.dev.pointofsale.data.product.ProductsDatabase;
import jaskiewicz.dev.pointofsale.input.BarcodeScanner;
import jaskiewicz.dev.pointofsale.input.ExitInput;
import jaskiewicz.dev.pointofsale.input.mock.ConsoleInput;
import jaskiewicz.dev.pointofsale.output.ScreenDisplay;
import jaskiewicz.dev.pointofsale.output.ReceiptPrinter;
import jaskiewicz.dev.pointofsale.output.mock.ConsoleScreenDisplay;
import jaskiewicz.dev.pointofsale.output.mock.ConsoleReceiptPrinter;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class DependencyProvider {

    public static BarcodeScanner provideBarcodeScanner() {
        return ConsoleInput.getInstance();
    }

    public static ProductsDatabase provideProductsDatabase() {
        return new MockProductsDatabase();
    }

    public static ScreenDisplay provideScreenDisplay() {
        return new ConsoleScreenDisplay();
    }

    public static ExitInput provideExitInput() {
        return ConsoleInput.getInstance();
    }

    public static ReceiptPrinter provideReceiptPrinter() {
        return new ConsoleReceiptPrinter();
    }
}
