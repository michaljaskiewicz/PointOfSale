package jaskiewicz.dev.pointOfSale;

import jaskiewicz.dev.pointOfSale.data.product.ProductNotFoundException;
import jaskiewicz.dev.pointOfSale.data.product.ProductsDatabase;
import jaskiewicz.dev.pointOfSale.dependencies.DependencyProvider;
import jaskiewicz.dev.pointOfSale.input.BarcodeScanner;
import jaskiewicz.dev.pointOfSale.input.ExitInput;
import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.Product;
import jaskiewicz.dev.pointOfSale.output.LCDDisplay;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class PointOfSale implements BarcodeScanner.Callback, ExitInput.Callback {

    private static PointOfSale instance;

    private BarcodeScanner scanner;
    private ProductsDatabase database;
    private LCDDisplay lcdDisplay;
    private ExitInput exitInput;

    public static PointOfSale getInstance() {
        if (instance == null) {
            instance = new PointOfSale();
        }
        return instance;
    }

    private PointOfSale() {
        prepareScanner();
        prepareDatabase();
        prepareLCDDisplay();
        prepareExitInput();
    }

    private BarcodeScanner prepareScanner() {
        scanner = DependencyProvider.provideBarcodeScanner();
        scanner.assignCallback(this);
        return scanner;
    }

    private void prepareDatabase() {
        database = DependencyProvider.provideProductsDatabase();
    }

    private void prepareLCDDisplay() {
        lcdDisplay = DependencyProvider.provideLCDDisplay();
    }

    private void prepareExitInput() {
        exitInput = DependencyProvider.provideExitInput();
        exitInput.assignCallback(this);
    }

    public void startServeNextCustomer() {
        scanner.startScanning();
    }

    public void stopScanningAndShowPurchasesSummary(){
        // TODO
        // implement actions on 'exit' input
        scanner.stopScanning();
        // calculate purchase cost
        // print receipt
        // display purchase summary on LCD display
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

    @Override
    public void onExit() {
        stopScanningAndShowPurchasesSummary();
    }
}