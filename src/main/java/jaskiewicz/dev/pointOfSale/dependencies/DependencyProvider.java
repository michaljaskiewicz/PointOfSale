package jaskiewicz.dev.pointOfSale.dependencies;

import jaskiewicz.dev.pointOfSale.data.product.MockProductsDatabase;
import jaskiewicz.dev.pointOfSale.data.product.ProductProvider;
import jaskiewicz.dev.pointOfSale.input.BarcodesScanner;
import jaskiewicz.dev.pointOfSale.input.mock.ConsoleBarcodesScanner;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class DependencyProvider {

    public static BarcodesScanner provideBarcodeScanner() {
        return new ConsoleBarcodesScanner();
    }

    public static ProductProvider provideProductProvider() {
        return new MockProductsDatabase();
    }
}
