package jaskiewicz.dev.pointOfSale.dependencies;

import jaskiewicz.dev.pointOfSale.data.product.mock.MockProductsDatabase;
import jaskiewicz.dev.pointOfSale.data.product.ProductsDatabase;
import jaskiewicz.dev.pointOfSale.input.BarcodeScanner;
import jaskiewicz.dev.pointOfSale.input.mock.ConsoleBarcodeScanner;
import jaskiewicz.dev.pointOfSale.output.LCDDisplay;
import jaskiewicz.dev.pointOfSale.output.mock.ConsoleLCDDisplay;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class DependencyProvider {

    public static BarcodeScanner provideBarcodeScanner() {
        return new ConsoleBarcodeScanner();
    }

    public static ProductsDatabase provideProductsDatabase() {
        return new MockProductsDatabase();
    }

    public static LCDDisplay provideLCDDisplay() {
        return new ConsoleLCDDisplay();
    }
}
