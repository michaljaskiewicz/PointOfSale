package jaskiewicz.dev.pointOfSale.input;

import jaskiewicz.dev.pointOfSale.model.Barcode;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public interface BarcodeScanner {

    Barcode scan();

    interface Callback {

        void onScanFailed();

        void onScanSuccess();
    }
}
