package jaskiewicz.dev.pointOfSale.data.product;

import jaskiewicz.dev.pointOfSale.model.Barcode;
import jaskiewicz.dev.pointOfSale.model.Product;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public interface ProductsDatabase {

    Product findProductWith(Barcode barcode) throws ProductNotFoundException;
}
