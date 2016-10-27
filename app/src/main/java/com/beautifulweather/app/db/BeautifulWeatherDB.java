package com.beautifulweather.app.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.beautifulweather.app.bean.City;
import com.beautifulweather.app.bean.County;
import com.beautifulweather.app.bean.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunshine on 2016/10/24.
 */

public class BeautifulWeatherDB {

    /*
	 * 数据库名
	 */
    public static final String DB_NAME = "cool_weather";

    /**
     * 数据库版本
     */
    public static final int VERSION = 1;
    private static BeautifulWeatherDB beautifulWeatherDB;
    private static SQLiteDatabase sqlData;

    /**
     * 将构造函数私有化
     */
    public BeautifulWeatherDB(Context context) {
        // TODO Auto-generated constructor stub

        BeautifulWeatherOpenHelper dbHelper = new BeautifulWeatherOpenHelper(context, DB_NAME, null, VERSION);
        sqlData = dbHelper.getWritableDatabase();
    }

    /**
     * 获取CoolWeatherDB实例
     */
    public synchronized static BeautifulWeatherDB getInstance(Context context){
        if (beautifulWeatherDB == null) {
            beautifulWeatherDB = new BeautifulWeatherDB(context);
        }
        return beautifulWeatherDB;
    }

    /**
     * 将Province实例存储到数据库
     */
    public void saveProvince(Province province){
        if(province != null){
            ContentValues valuesP= new ContentValues();
            valuesP.put("province_name", province.getP_Name());
            valuesP.put("province_code", province.getP_Code());
            sqlData.insert("Province", null, valuesP);
        }
    }

    /**
     * 从数据库读取全国所有省份信息
     */
    public List<Province> getlistProvince(){

        List<Province> listProvince = new ArrayList<Province>();

        Cursor cursor = sqlData.query("Province", null, null, null, null, null, null);

        if(cursor.moveToFirst()){
            do {
                Province province = new Province();
                province.setP_Id(cursor.getInt(cursor.getColumnIndex("province_id")));
                province.setP_Name(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setP_Code(cursor.getString(cursor.getColumnIndex("province_code")));
                listProvince.add(province);
            } while (cursor.moveToNext());
        }
        if(cursor != null){
            cursor.close();
        }
        return listProvince;
    }

    /**
     * 将City实例存储到数据库
     */
    public void saveCity(City city){
        if(city != null){
            ContentValues valuesC = new ContentValues();
            valuesC.put("city_name", city.getC_Name());
            valuesC.put("city_code", city.getC_Code());
            valuesC.put("city_province_id", city.getC_ProvinceId());
            sqlData.insert("City", null, valuesC);
        }
    }

    /**
     * 从数据库读取某个省下所有的城市信息
     */
    public List<City> getlistCityByPid(int provinceId){

        List<City> listCity = new ArrayList<City>();

        Cursor cursor = sqlData.query("City", null, "city_province_id = ?", new String[] {String.valueOf(provinceId)}, null, null, null);

        if(cursor.moveToFirst()){
            do {
                City city = new City();
                city.setC_Id(cursor.getInt(cursor.getColumnIndex("city_id")));
                city.setC_Name(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setC_Code(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setC_ProvinceId(provinceId);
                listCity.add(city);
            } while (cursor.moveToNext());
        }
        if(cursor != null){
            cursor.close();
        }
        return listCity;
    }

    /**
     * 将County实例存储到数据库
     */
    public void saveCounty(County county){
        if(county != null){
            ContentValues valuesCC = new ContentValues();
            valuesCC.put("county_name", county.getCo_Name());
            valuesCC.put("county_code", county.getCo_Code());
            valuesCC.put("county_city_id", county.getCo_CityId());
            sqlData.insert("County", null, valuesCC);
        }
    }

    /**
     * 从数据库读取某城市下所有的县级信息
     */
    public List<County> getlistCountyByCid(int cityId){

        List<County> listCounty = new ArrayList<County>();

        Cursor cursor = sqlData.query("County", null, "county_city_id = ?", new String[]{String.valueOf(cityId)}, null, null, null);

        if(cursor.moveToFirst()){
            do {
                County county = new County();
                county.setCo_Id(cursor.getInt(cursor.getColumnIndex("county_id")));
                county.setCo_Name(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCo_Code(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCo_CityId(cityId);
                listCounty.add(county);
            } while (cursor.moveToNext());
        }
        if(cursor != null){
            cursor.close();
        }
        return listCounty;
    }

}
