package jaskiewicz.dev.pointOfSale.input.mock;

import jaskiewicz.dev.pointOfSale.input.BarcodeScanner;
import jaskiewicz.dev.pointOfSale.input.ExitInput;
import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.exceptions.EmptyBarcodeException;

import java.util.Scanner;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class MockConsoleInput implements BarcodeScanner, ExitInput {

    private static MockConsoleInput instance;

    private BarcodeScanner.Callback barcodeScannerCallback;
    private ExitInput.Callback exitInputCallback;
    private Scanner scanner;
    private boolean isScanning = false;

    private MockConsoleInput() {
        scanner = new Scanner(System.in);
    }

    public static MockConsoleInput getInstance() {
        if (instance == null) {
            instance = new MockConsoleInput();
        }
        return instance;
    }

    @Override
    public void startScanning() {
        isScanning = true;
        while (isScanning) {
            scanInput();
        }
    }

    private void scanInput() {
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            exit();
        } else {
            tryToScanBarcode(input);
        }
    }

    private void tryToScanBarcode(String code) {
        try {
            final Barcode barcode = new Barcode(code);
            barcodeScannerCallback.onScanSuccess(barcode);
        } catch (EmptyBarcodeException e) {
            barcodeScannerCallback.onScanFailure();
        }
    }

    @Override
    public void stopScanning() {
        isScanning = false;
    }

    @Override
    public void assignCallback(BarcodeScanner.Callback callback) {
        this.barcodeScannerCallback = callback;
    }

    @Override
    public void exit() {
        exitInputCallback.onExit();
    }

    @Override
    public void assignCallback(ExitInput.Callback callback) {
        exitInputCallback = callback;
    }
}
