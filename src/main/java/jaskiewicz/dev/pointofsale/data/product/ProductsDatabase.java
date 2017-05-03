package jaskiewicz.dev.pointofsale.data.product;

import jaskiewicz.dev.pointofsale.model.Barcode;
import jaskiewicz.dev.pointofsale.model.Product;

/**
 * Created by michaljaskiewicz on 02-May-17.
 */
public interface ProductsDatabase {

    Product findProductWith(Barcode barcode) throws ProductNotFoundException;
}
