package com.inhatc.gachi_salrim;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.telecom.Call;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        geocoder = new Geocoder(this);
        //실습 IV : Current Position 구현
        long minTime = 1000;
        float minDistance = 1;


        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        updateMap(null); // 구글 맵 업데이트

        // ----------------------------------------------------------
        LocationManager locationManager = (LocationManager) this.
                getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //updateMap(location); // 구글 맵 업데이트
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                alertStatus(provider);
            }

            @Override
            public void onProviderEnabled(String provider) {
                alertProvider(provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                checkProvider(provider);
            }
        };

        String strLocationProvider = LocationManager.NETWORK_PROVIDER;
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED){
            return;
        }
        locationManager.requestLocationUpdates(strLocationProvider,
                minTime, minDistance, locationListener);
    }

    // 구글 맵 업데이트 (현재위치로 맵 이동, api로 마커 찍기)
    public void updateMap(Location location){

        // TODO : 현재위치 == null or 설정된거주지역  == null => 기본으로 경기도 용인시로 설정
        // TODO : 설정된거주지역  != null => 설정된 거주지역으로
        // TODO : 현재위치 != null  and (현재위치 리스트 보기 버튼 클릭) => 현재위치로 설정

        CallAreaApi callAreaApi = new CallAreaApi();
        new DownloadWebpageTask().execute(callAreaApi.requestApi());

        // 지도 중앙설정 (테스트 : 용인시청)
        double latitude = 37.241139; // location.getLatitude()
        double longitude = 127.177932; // location.getLongitude()
        try{
            List<Address> adrList = new ArrayList<>();
            String locationNm = callAreaApi.strServiceSigunNm + "청";
            adrList = geocoder.getFromLocationName(locationNm,1);
            System.out.println("==============================================");
            System.out.println(adrList.get(0).toString());
            System.out.println("==============================================");

            // 콤마를 기준으로 split
            String latStr = adrList.get(0).toString().split("latitude=")[1].split(",")[0];
            String lonStr = adrList.get(0).toString().split("longitude=")[1].split(",")[0];
            System.out.println("==============================================");
            System.out.println( locationNm + " : " + latStr + " , " + lonStr);
            System.out.println("==============================================");
            // 좌표(위도, 경도) 생성

            if(latStr != null && lonStr != null){
                if(latStr.length() > 0 && lonStr.length() > 0){
                    latitude = Double.parseDouble(latStr);
                    longitude = Double.parseDouble(lonStr);
                }
            }
            else{
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }


        }catch(IOException e){
            e.printStackTrace();
        }

        final LatLng objLocation = new LatLng(latitude, longitude); // 경기도청 위경도


        // ==================================== 테스트 버전 =====================================
//        List<Map<String,Object>> makerList = new ArrayList<>();
//        for(int i =0;i<10;i++){
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("lat",latitude + i);
//            map.put("long",longitude + i);
//            map.put("title", "title (" + i + ")");
//
//            makerList.add(map);
//        }

        // 마커 리스트 가져와서 마커 생성후 표시하기 으으으으음
//        for(Map<String,Object> m : makerList){
//            String title = m.get("title").toString();
//            Double lat = Double.parseDouble(m.get("lat").toString());
//            Double lon = Double.parseDouble(m.get("long").toString());
//            LatLng loc = new LatLng(lat,lon);
//
//            MarkerOptions makerOptions = new MarkerOptions();
//            makerOptions
//                    .position(loc)
//                    .title(title);
//
//            mMap.addMarker(makerOptions);
//        }

        // ==================================== 테스트 버전 =====================================

        // 맵 이동, 확대
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(objLocation, 10));

    }

    public void checkProvider(String strProvider){
        Toast.makeText(this, strProvider + "에 의한 turn off position service. "+
                "Please Turn on position service...", Toast.LENGTH_SHORT).show();
        Intent objIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(objIntent);
    }

    public void alertProvider(String strProvider){
        Toast.makeText(this, strProvider + "Starting Position service !",
                Toast.LENGTH_SHORT).show();
    }

    public void alertStatus(String strProvider){
        Toast.makeText(this, "Changing position service : "+strProvider,
                Toast.LENGTH_LONG).show();
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
            try{
                JSONObject json = new JSONObject(result);
                JSONArray jArry = json.getJSONArray("RegionMnyFacltStus");
                JSONObject row = jArry.getJSONObject(1);
                JSONArray realData = row.getJSONArray("row");
                JSONObject jo;

                for(int i = 0;i<realData.length();i++){
                    jo = realData.getJSONObject(i);
                    if(jo != null){
                        if(jo.get("REFINE_WGS84_LAT").toString() != "null" && jo.get("REFINE_WGS84_LOGT").toString() != "null" && jo.get("CMPNM_NM").toString() != "null"){
                            String title = jo.get("CMPNM_NM").toString();
                            Double lat = Double.parseDouble(jo.get("REFINE_WGS84_LAT").toString());
                            Double lon = Double.parseDouble(jo.get("REFINE_WGS84_LOGT").toString());
                            LatLng loc = new LatLng(lat,lon);

                            MarkerOptions makerOptions = new MarkerOptions();
                            makerOptions
                                    .position(loc)
                                    .title(title);

                            mMap.addMarker(makerOptions);
                        }
                    }
                }
            }
            catch(JSONException je){
                System.out.println(je.toString());
            }
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
