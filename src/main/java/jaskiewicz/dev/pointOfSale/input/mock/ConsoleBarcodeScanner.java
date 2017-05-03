package jaskiewicz.dev.pointOfSale.input.mock;

import jaskiewicz.dev.pointOfSale.input.BarcodeScanner;
import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.exceptions.EmptyBarcodeException;

import java.util.Scanner;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class ConsoleBarcodeScanner implements BarcodeScanner {

    private Callback callback;
    private Scanner scanner;
    private boolean isScanning = false;

    public ConsoleBarcodeScanner() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void startScanning() {
        isScanning = true;
        while (isScanning) {
            tryToScanBarcode();
        }
    }

    private void tryToScanBarcode() {
        final String code = scanner.nextLine();
        try {
            final Barcode barcode = new Barcode(code);
            callback.onScanSuccess(barcode);
        } catch (EmptyBarcodeException e) {
            callback.onScanFailure();
        }
    }

    @Override
    public void stopScanning() {
        isScanning = false;
    }

    @Override
    public void assignCallback(Callback callback) {
        this.callback = callback;
    }
}
