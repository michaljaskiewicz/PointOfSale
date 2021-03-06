package jaskiewicz.dev.pointofsale.input;

import jaskiewicz.dev.pointofsale.model.Barcode;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public interface BarcodeScanner {

    void startScanning();

    void stopScanning();

    void assignCallback(Callback callback);

    interface Callback {

        void onScanSuccess(Barcode barcode);

        void onScanFailure();
    }
}
