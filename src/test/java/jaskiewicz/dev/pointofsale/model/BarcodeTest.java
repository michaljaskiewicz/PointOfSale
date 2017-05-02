package jaskiewicz.dev.pointOfSale.model;

import jaskiewicz.dev.pointOfSale.model.exceptions.EmptyBarcodeException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class BarcodeTest {

    @Test
    public void should_create_barcode_with_given_code() {
        // given
        final String code = "0123456789";
        // when
        final Barcode barcode = new Barcode(code);
        // then
        assertEquals(code, barcode.get());
    }

    @Test
    public void should_not_create_barcode_with_empty_code() {
        // given
        final String code = "";
        // when
        try {
            new Barcode(code);
            fail("Should not create barcode with empty code!");
        } catch (EmptyBarcodeException e) {
            // then pass
        }
    }

    @Test
    public void should_not_create_barcode_with_empty_code_after_ignoring_whitespaces() {
        // given
        final String code = "    ";
        // when
        try {
            new Barcode(code);
            fail("Should not create barcode with empty code!");
        } catch (EmptyBarcodeException e) {
            // then pass
        }
    }

    @Test
    public void should_not_create_barcode_without_code() {
        // given
        final String code = null;
        // when
        try {
            new Barcode(code);
            fail("Should not create barcode without code!");
        } catch (EmptyBarcodeException e) {
            // then pass
        }
    }

    @Test
    public void should_barcodes_with_same_code_be_equal() {
        // given
        final String code = "0123456789";
        // when
        final Barcode barcode = new Barcode(code);
        final Barcode barcodeWithSameCode = new Barcode(code);
        // then
        assertEquals(barcode, barcodeWithSameCode);
    }

    @Test
    public void should_barcode_be_printable() {
        // given
        final String code = "0123456789";
        // when
        final Barcode barcode = new Barcode(code);
        // then
        assertEquals(code, barcode.toString());

    }
}
