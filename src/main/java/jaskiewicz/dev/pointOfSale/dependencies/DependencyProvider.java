package jaskiewicz.dev.pointOfSale.dependencies;

import jaskiewicz.dev.pointOfSale.data.product.mock.MockProductsDatabase;
import jaskiewicz.dev.pointOfSale.data.product.ProductProvider;
import jaskiewicz.dev.pointOfSale.input.BarcodeScanner;
import jaskiewicz.dev.pointOfSale.input.mock.ConsoleBarcodeScanner;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class DependencyProvider {

    public static BarcodeScanner provideBarcodeScanner() {
        return new ConsoleBarcodeScanner();
    }

    public static ProductProvider provideProductProvider() {
        return new MockProductsDatabase();
    }
}
