package com.inhatc.gachi_salrim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private static final String STORESKEY = "stores_key";
    private ArrayList<Store> listStores = new ArrayList<>();

    String SIGUN = "";
    String DONG = "";
    int size = 0;

    private MapView mapView = null;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle args = getArguments();
        if(args == null){
            Toast.makeText(getActivity(), "위치 정보를 받아오고 있습니다.", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getActivity(), "지도를 불러오고 있습니다.", Toast.LENGTH_SHORT).show();
            listStores = args.getParcelableArrayList(STORESKEY);
            SIGUN = args.getString("SIGUN");
            DONG = args.getString("DONG");
        }

        View rootView = inflater.inflate(R.layout.map_fragment, container, false);

        mapView = (MapView)rootView.findViewById(R.id.map);
        mapView.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //액티비티가 처음 생성될 때 실행되는 함수

        if(mapView != null)
        {
            mapView.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        long minTime = 1000;
        float minDistance = 1;

        MarkerOptions markerOptions = new MarkerOptions();


        if(listStores.size() == 0){
            Toast.makeText(getActivity(), "가맹점이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
        } else {
            for (Store store : listStores) {
                if (store.getLat() != null && store.getLongt() != null) {
                    double newLat = Double.valueOf(store.getLat());
                    double newLongt = Double.valueOf(store.getLongt());
                    LatLng STORE = new LatLng(newLat, newLongt);


                    markerOptions.position(STORE);
                    markerOptions.title(store.getName());
//                    markerOptions.snippet("수도");
                    googleMap.addMarker(markerOptions);
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(STORE));
                    googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
                }
            }
        }
    }
}

