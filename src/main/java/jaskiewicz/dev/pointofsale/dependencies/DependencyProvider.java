package jaskiewicz.dev.pointofsale.dependencies;

import jaskiewicz.dev.pointofsale.data.product.mock.MockProductsDatabase;
import jaskiewicz.dev.pointofsale.data.product.ProductsDatabase;
import jaskiewicz.dev.pointofsale.input.BarcodeScanner;
import jaskiewicz.dev.pointofsale.input.ExitInput;
import jaskiewicz.dev.pointofsale.input.mock.MockConsoleInput;
import jaskiewicz.dev.pointofsale.output.LCDDisplay;
import jaskiewicz.dev.pointofsale.output.mock.ConsoleLCDDisplay;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class DependencyProvider {

    public static BarcodeScanner provideBarcodeScanner() {
        return MockConsoleInput.getInstance();
    }

    public static ProductsDatabase provideProductsDatabase() {
        return new MockProductsDatabase();
    }

    public static LCDDisplay provideLCDDisplay() {
        return new ConsoleLCDDisplay();
    }

    public static ExitInput provideExitInput() {
        return MockConsoleInput.getInstance();
    }
}
