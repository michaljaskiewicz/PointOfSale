package jaskiewicz.dev.pointOfSale.model;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class Barcode {

    private String code;

    public Barcode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Could not create Barcode with empty code");
        }
        this.code = code;
    }

    public String get() {
        return code;
    }
}
