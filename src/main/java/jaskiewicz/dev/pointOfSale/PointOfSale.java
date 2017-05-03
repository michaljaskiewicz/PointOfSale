package jaskiewicz.dev.pointOfSale;

import jaskiewicz.dev.pointOfSale.data.product.ProductNotFoundException;
import jaskiewicz.dev.pointOfSale.data.product.ProductsDatabase;
import jaskiewicz.dev.pointOfSale.dependencies.DependencyProvider;
import jaskiewicz.dev.pointOfSale.input.BarcodeScanner;
import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.Product;
import jaskiewicz.dev.pointOfSale.output.LCDDisplay;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class PointOfSale implements BarcodeScanner.Callback {

    private static PointOfSale instance;

    private final BarcodeScanner scanner;
    private final ProductsDatabase database;
    private final LCDDisplay lcdDisplay;

    public static PointOfSale getInstance() {
        if (instance == null) {
            instance = new PointOfSale();
        }
        return instance;
    }

    private PointOfSale() {
        scanner = DependencyProvider.provideBarcodeScanner();
        scanner.assignCallback(this);
        database = DependencyProvider.provideProductsDatabase();
        lcdDisplay = DependencyProvider.provideLCDDisplay();
    }

    public void startServeNextCustomer() {
        scanner.startScanning();
    }

    public void makePayment(){
        // TODO
        // implement actions on 'exit' input
        scanner.stopScanning();
        // calculate purchase cost
        // print receipt
        // display purchase summary on LCD display
        // startServeNextCustomer()
    }

    @Override
    public void onScanSuccess(Barcode barcode) {
        try {
            Product product = database.findProductWith(barcode);
            lcdDisplay.showOnDisplay(product);
        } catch (ProductNotFoundException e) {
            lcdDisplay.showOnDisplay("Product not found");
        }
    }

    @Override
    public void onScanFailure() {
        lcdDisplay.showOnDisplay("Invalid bar-code");
    }
}