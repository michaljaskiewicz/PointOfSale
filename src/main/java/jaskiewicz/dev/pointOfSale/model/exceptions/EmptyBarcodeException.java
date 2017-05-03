package jaskiewicz.dev.pointofsale.model.exceptions;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class EmptyBarcodeException extends IllegalArgumentException {

    public EmptyBarcodeException(String message) {
        super(message);
    }
}
