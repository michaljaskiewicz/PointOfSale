package jaskiewicz.dev.pointOfSale;

import jaskiewicz.dev.pointOfSale.data.product.ProductNotFoundException;
import jaskiewicz.dev.pointOfSale.data.product.ProductProvider;
import jaskiewicz.dev.pointOfSale.dependencies.DependencyProvider;
import jaskiewicz.dev.pointOfSale.input.BarcodeScanner;
import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.Product;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class PointOfSale implements BarcodeScanner.Callback {

    private static PointOfSale instance;

    private BarcodeScanner scanner;
    private final ProductProvider database;

    public static PointOfSale getInstance() {
        if (instance == null) {
            instance = new PointOfSale();
        }
        return instance;
    }

    private PointOfSale() {
        scanner = DependencyProvider.provideBarcodeScanner();
        scanner.setCallback(this);
        database = DependencyProvider.provideProductProvider();
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
            Product product = database.provideProductWith(barcode);
            System.out.println(product.getName() + " " + product.getPrice().getValue());
        } catch (ProductNotFoundException e) {
            System.out.println("Product not found");
        }
    }

    @Override
    public void onScanFailure() {
        System.out.println("Invalid bar-code");
    }
}