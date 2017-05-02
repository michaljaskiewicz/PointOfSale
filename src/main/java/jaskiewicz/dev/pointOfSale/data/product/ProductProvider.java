package jaskiewicz.dev.pointOfSale.data.product;

import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.Product;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public interface ProductProvider {

    Product provideProductWith(Barcode barcode) throws ProductNotFoundException;
}
