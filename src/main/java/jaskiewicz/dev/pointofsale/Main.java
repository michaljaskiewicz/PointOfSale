package jaskiewicz.dev.pointofsale;

import jaskiewicz.dev.pointofsale.logic.PointOfSale;

/**
 * Created by michaljaskiewicz on 01-May-17.
 */
public class Main {

    public static void main(String[] args) {
	// this loop allows serving next customers
        while(true) {
            PointOfSale.getInstance().startServeNextCustomer();
        }
    }


}
