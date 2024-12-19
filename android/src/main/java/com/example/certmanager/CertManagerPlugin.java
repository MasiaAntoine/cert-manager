package com.example.certmanager;

import android.util.Log;

public class CertManagerPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
