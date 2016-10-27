package com.beautifulweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sunshine on 2016/10/24.
 */

public class BeautifulWeatherOpenHelper extends SQLiteOpenHelper {

    /**
     * Province表*建表语句
     */
    public static final String CREATE_PROVINCE = "create table Province(province_id integer primary key autoincrement,province_name text,province_code text)";
    /**
     * C表*建表语句
     */
    public static final String CREATE_CITY = "create table City(city_id integer primary key autoincrement,city_name text,city_code text,city_province_id integer)";
    /**
     * County表*建表语句
     */
    public static final String CREATE_COUNTY = "create table County(county_id integer primary key autoincrement,county_name text,county_code text,county_city_id integer)";

    public BeautifulWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PROVINCE); //创建Province表
        sqLiteDatabase.execSQL(CREATE_CITY);  //创建City表
        sqLiteDatabase.execSQL(CREATE_COUNTY);  //创建County表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
