package com.beautifulweather.app.bean;

/**
 * Created by Sunshine on 2016/10/24.
 */

public class County {

    private int co_Id;
    private int co_CityId;
    private String co_Name;
    private String co_Code;

    public int getCo_Id() {
        return co_Id;
    }

    public void setCo_Id(int co_Id) {
        this.co_Id = co_Id;
    }

    public int getCo_CityId() {
        return co_CityId;
    }

    public void setCo_CityId(int co_CityId) {
        this.co_CityId = co_CityId;
    }

    public String getCo_Code() {
        return co_Code;
    }

    public void setCo_Code(String co_Code) {
        this.co_Code = co_Code;
    }

    public String getCo_Name() {
        return co_Name;
    }

    public void setCo_Name(String co_Name) {
        this.co_Name = co_Name;
    }
}
