package com.inhatc.gachi_salrim;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SelectActivity extends Activity {
    private TextView objTV;
    private String strServiceUrl, strServiceKey, strServiceSigunNm, strUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        objTV = (TextView) findViewById(R.id.txtTest);

        strServiceUrl = "https://openapi.gg.go.kr/RegionMnyFacltStus";
        strServiceKey = "64e84652a0b14c23b2613ac31c62a42e";
        strServiceSigunNm ="용인시";

        strUrl = strServiceUrl + "?key=" + strServiceKey + "&type=json&SIGUN_NM=" + strServiceSigunNm + "&pSize=2";
        System.out.println(strUrl);

        new DownloadWebpageTask().execute(strUrl);
    };

    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                return (String)downloadUrl((String)urls[0]);
            } catch(IOException e) {
                return "Fail";
            }
        }

        protected void onPostExecute(String result) {objTV.setText(result);}

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
