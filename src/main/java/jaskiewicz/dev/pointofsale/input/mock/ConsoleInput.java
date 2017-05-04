package jaskiewicz.dev.pointofsale.input.mock;

import jaskiewicz.dev.pointofsale.input.BarcodeScanner;
import jaskiewicz.dev.pointofsale.input.ExitInput;
import jaskiewicz.dev.pointofsale.model.Barcode;
import jaskiewicz.dev.pointofsale.model.exceptions.EmptyBarcodeException;

import java.util.Scanner;

/**
 * Created by michaljaskiewicz on 02-May-17.
 *
 * This class is a bit confusing and complicated because I needed to use console as two
 * different input devices.
 *
 * This class is responsible for scanning barcodes - so it is mock of barcode scanner.
 * It is also responsible for taking 'exit' user input and notify PointOfSale
 * about 'exit' action.
 *
 * I'm aware that this class violates Single Responsibility Principle,
 * but I was forced to handle both barcode scanner and 'exit' input from
 * one device which is a single console.
 */
public class ConsoleInput implements BarcodeScanner, ExitInput {

    private static ConsoleInput instance;

    private BarcodeScanner.Callback barcodeScannerCallback;
    private ExitInput.Callback exitInputCallback;
    private Scanner scanner;
    private boolean isScanning = false;

    private ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    public static ConsoleInput getInstance() {
        if (instance == null) {
            instance = new ConsoleInput();
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

    @Override
    public void exit() {
        exitInputCallback.onExit();
    }

    @Override
    public void assignCallback(ExitInput.Callback callback) {
        exitInputCallback = callback;
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
    public void assignCallback(BarcodeScanner.Callback callback) {
        this.barcodeScannerCallback = callback;
    }

    @Override
    public void stopScanning() {
        isScanning = false;
    }
}
