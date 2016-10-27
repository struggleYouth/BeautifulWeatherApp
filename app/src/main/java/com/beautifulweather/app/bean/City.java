package com.beautifulweather.app.bean;

/**
 * Created by Sunshine on 2016/10/24.
 */

public class City {

    private int c_Id;
    private int c_ProvinceId;
    private String c_Name;
    private String c_Code;

    public int getC_Id() { return c_Id; }

    public void setC_Id(int c_Id) {
        this.c_Id = c_Id;
    }

    public int getC_ProvinceId() {
        return c_ProvinceId;
    }

    public void setC_ProvinceId(int c_ProvinceId) {
        this.c_ProvinceId = c_ProvinceId;
    }

    public String getC_Code() {
        return c_Code;
    }

    public void setC_Code(String c_Code) {
        this.c_Code = c_Code;
    }

    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }
}
