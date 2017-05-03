package jaskiewicz.dev.pointofsale.model;

import jaskiewicz.dev.pointofsale.model.exceptions.EmptyBarcodeException;

import java.util.Objects;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public class Product {

    private Barcode barcode;
    private String name;
    private Money price;

    public Product(Barcode barcode, String name, Money price) {
        if (barcode == null) {
            throw new EmptyBarcodeException("Could not create Product without barcode");
        }

        if (name == null || price == null) {
            throw new IllegalArgumentException("Could not create Product without name or price");
        }

        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null || getClass() != obj.getClass()) return false;
        final Product product = (Product) obj;
        return Objects.equals(barcode, product.barcode) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, name, price);
    }
}
