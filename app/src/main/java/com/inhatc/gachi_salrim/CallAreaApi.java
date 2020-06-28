package com.inhatc.gachi_salrim;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallAreaApi {
    // TODO : 선택한 지역의 api를 데이터베이스에서 가져와서 호출하는 Class

    public String strServiceUrl, strServiceKey, strServiceSigunNm, strUrl;
    public JSONObject responseData;
    public String responseDataStr;

    public CallAreaApi(){}

    public CallAreaApi(String  strServiceKey,String  strServiceSigunNm){
        this.strServiceSigunNm = strServiceSigunNm;
        this.strServiceKey = strServiceKey;
    }

    public String requestApi(){
        if(strServiceKey == null){
            this.strServiceKey = "64e84652a0b14c23b2613ac31c62a42e";
        }
        if(strServiceSigunNm == null){
            this.strServiceSigunNm ="용인시";
        }
        if(strServiceUrl == null){
            this.strServiceUrl = "https://openapi.gg.go.kr/RegionMnyFacltStus";
        }
        // https://openapi.gg.go.kr/RegionMnyFacltStus?key=64e84652a0b14c23b2613ac31c62a42e&type=json&SIGUN_NM=용인시&pSize=2
        strUrl = this.strServiceUrl + "?key=" + this.strServiceKey + "&type=json&SIGUN_NM=" + this.strServiceSigunNm;
        System.out.println(strUrl);

        return strUrl;
        //return new DownloadWebpageTask().execute(strUrl);
    }

}
