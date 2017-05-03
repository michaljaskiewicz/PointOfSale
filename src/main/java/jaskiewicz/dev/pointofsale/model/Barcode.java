package jaskiewicz.dev.pointofsale.model;

import jaskiewicz.dev.pointofsale.model.exceptions.EmptyBarcodeException;

import java.util.Objects;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class Barcode {

    private String code;

    public Barcode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new EmptyBarcodeException("Could not create Barcode with empty code");
        }
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public String get() {
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null || getClass() != obj.getClass()) return false;
        final Barcode barcode = (Barcode) obj;
        return Objects.equals(code, barcode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
