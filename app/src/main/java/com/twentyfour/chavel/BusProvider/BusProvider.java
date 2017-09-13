package com.twentyfour.chavel.BusProvider;

/**
 * Created by Bas on 9/3/2017 AD.
 */

import com.squareup.otto.Bus;

public class BusProvider {
    private static Bus sBus;
    public static Bus getBus() {
        if (sBus == null)
            sBus = new Bus();
        return sBus;
    }

}
