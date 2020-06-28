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
    public JSONObject json;

    public CallAreaApi(){}

    public CallAreaApi(String  strServiceKey,String  strServiceSigunNm){
        this.strServiceSigunNm = strServiceSigunNm;
        this.strServiceKey = strServiceKey;
    }

    public Object requestApi(){
        if(strServiceKey == null){
            this.strServiceKey = "64e84652a0b14c23b2613ac31c62a42e";
        }
        if(strServiceSigunNm == null){
            this.strServiceSigunNm ="용인시";
        }
        if(strServiceUrl == null){
            this.strServiceUrl = "https://openapi.gg.go.kr/RegionMnyFacltStus";
        }

        strUrl = this.strServiceUrl + "?key=" + this.strServiceKey + "&type=json&SIGUN_NM=" + this.strServiceSigunNm + "&pSize=2";
        System.out.println(strUrl);

        return new DownloadWebpageTask().execute(strUrl);
    }

    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                return (String)downloadUrl((String)urls[0]);
            } catch(IOException e) {
                return "Fail";
            }
        }

        protected void onPostExecute(String result) {
            //objTV.setText(result);
            System.out.println("=============================================");
            System.out.println(result.toString());
            System.out.println("=============================================");
        }

        private String downloadUrl(String myurl) throws IOException {
            HttpURLConnection urlConn = null;
            try {
                URL url = new URL(myurl);
                urlConn = (HttpURLConnection) url.openConnection();
                BufferedInputStream inBuf = new BufferedInputStream(urlConn.getInputStream());
                BufferedReader bufReader = new BufferedReader(new InputStreamReader(inBuf, "utf-8"));

                String strLine = null;
                String strPage = "";
                while((strLine = bufReader.readLine()) != null) {
                    strPage += strLine;
                }

                return strPage;
            } finally {
                urlConn.disconnect();
            }
        }
    }
}
