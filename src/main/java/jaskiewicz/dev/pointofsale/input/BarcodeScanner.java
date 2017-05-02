package jaskiewicz.dev.pointOfSale.input;

import jaskiewicz.dev.pointOfSale.model.Barcode;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public interface BarcodeScanner {

    void startScanning();

    void stopScanning();

    void setCallback(Callback callback);

    interface Callback {

        void onScanSuccess(Barcode barcode);

        void onScanFailure();
    }
}
