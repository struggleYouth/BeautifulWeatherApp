package com.beautifulweather.app.bean;

/**
 * Created by Sunshine on 2016/10/24.
 */

public class Province {

    private int p_Id;
    private String p_Name;
    private String p_Code;

    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }

    public void setP_Name(String p_Name) {
        this.p_Name = p_Name;
    }

    public void setP_Code(String p_Code) {
        this.p_Code = p_Code;
    }

    public int getP_Id() {
        return p_Id;
    }

    public String getP_Code() {
        return p_Code;
    }

    public String getP_Name() {
        return p_Name;
    }
}
