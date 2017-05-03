package jaskiewicz.dev.pointofsale;

import jaskiewicz.dev.pointofsale.data.product.ProductNotFoundException;
import jaskiewicz.dev.pointofsale.data.product.ProductsDatabase;
import jaskiewicz.dev.pointofsale.dependencies.DependencyProvider;
import jaskiewicz.dev.pointofsale.input.BarcodeScanner;
import jaskiewicz.dev.pointofsale.input.ExitInput;
import jaskiewicz.dev.pointofsale.model.Barcode;
import jaskiewicz.dev.pointofsale.model.Bill;
import jaskiewicz.dev.pointofsale.model.Product;
import jaskiewicz.dev.pointofsale.output.LCDDisplay;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class PointOfSale implements BarcodeScanner.Callback, ExitInput.Callback {

    private static PointOfSale instance;

    private BarcodeScanner scanner;
    private ProductsDatabase database;
    private LCDDisplay lcdDisplay;
    private ExitInput exitInput;
    private Bill currentBill;

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

    private void prepareScanner() {
        scanner = DependencyProvider.provideBarcodeScanner();
        scanner.assignCallback(this);
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
        prepareNewBill();
        scanner.startScanning();
    }

    private void prepareNewBill() {
        currentBill = new Bill();
    }

    public void stopScanningAndShowPurchasesSummary(){
        // TODO
        // implement actions on 'exit' input
        scanner.stopScanning();
        lcdDisplay.showTotalSumFor(currentBill);
        // print receipt
    }

    @Override
    public void onScanSuccess(Barcode barcode) {
        try {
            Product product = database.findProductWith(barcode);
            lcdDisplay.showOnDisplay(product);
            currentBill.add(product);
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