package com.spectrosmart.NanoScan.RetrofitSupport;

import java.util.ArrayList;

/**
 * Created by anjal on 12/19/17.
 */

public class LoginResponse {
    private double id;
    private  String csv_url;
    private ArrayList<Values> values;
//
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getCsv_url() {
        return csv_url;
    }

    public void setCsv_url(String csv_url) {
        this.csv_url = csv_url;
    }

    public ArrayList<Values> getValues() {
        return values;
    }

    public void setValues(ArrayList<Values> values) {
        this.values = values;
    }
}

