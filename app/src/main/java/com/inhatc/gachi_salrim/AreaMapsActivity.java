package com.inhatc.gachi_salrim;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class AreaMapsActivity extends AppCompatActivity {

    public static Context context;

    // Buttons
    Button list_btn;
    Button map_btn;
//    Button search_btn;
    Button info_btn;
    Button favorite_btn;
    Button findAdr_btn;

    // Fragments
    ListViewFragment listViewFragment;
    MapFragment mapFragment;
    InfoFragment infoFragment;
    LocalFragment localFragment;

    TextView loadingMessage;
    ArrayList<Store> stores = new ArrayList<>();
    String SIGUN = "";
    String DONG = "";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_maps);
        context = this;


        Toolbar toolbar = findViewById(R.id.my_toolbar);
        //toolbar.setTitleTextColor(Color.parseColor("#ffff33")); //제목의 칼라
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.logo1); //제목앞에 아이콘 넣기'
        setSupportActionBar(toolbar);

        // add_btn = (ImageButton) findViewById(R.id.add_btn);
        map_btn = (Button) findViewById(R.id.map_btn);
        list_btn = (Button) findViewById(R.id.list_btn);
//        search_btn = (Button) findViewById(R.id.info_btn);
        info_btn = (Button) findViewById(R.id.info_btn);
        favorite_btn=(Button) findViewById(R.id.favorite_btn);
        findAdr_btn = (Button) findViewById(R.id.findAdr_btn);

        loadingMessage = (TextView) findViewById(R.id.loadingMessage);

        listViewFragment = new ListViewFragment();
        mapFragment = new MapFragment();
        infoFragment = new InfoFragment();
        localFragment = new LocalFragment();

        Intent data = getIntent();
        if(data != null) {
            Bundle bundle = data.getExtras();
            SIGUN = bundle.getString("SIGUN");
            DONG = bundle.getString(("DONG"));
            String location = SIGUN + " " + DONG;
            findAdr_btn.setText(location);

//            stores = bundle.getParcelableArrayList("all_stores");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    CallAreaApi parser = new CallAreaApi();
                    stores = parser.getAllXmlData(SIGUN, DONG);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loadingMessage.setText("");
                            map_btn.performClick();
                        }
                    });
                }
            }).start();
        }

        //지도 보기 버튼 클릭시
        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingMessage.setText("");
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("stores_key", stores);
                bundle.putString("SIGUN", SIGUN);
                bundle.putString("DONG", DONG);
                mapFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
                map_btn.setBackgroundColor(Color.parseColor("#F2F2F2"));
                list_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                info_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                favorite_btn.setBackgroundColor(Color.parseColor("#00ff0000"));

            }
        });

        //리스트 보기 버튼 클릭시
        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("stores_key", stores);
                bundle.putString("SIGUN", SIGUN);
                bundle.putString("DONG", DONG);
                listViewFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, listViewFragment).commit();
                map_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                list_btn.setBackgroundColor(Color.parseColor("#F2F2F2"));
                info_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                favorite_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
            }
        });

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, infoFragment).commit();
                map_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                list_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                info_btn.setBackgroundColor(Color.parseColor("#F2F2F2"));
                favorite_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
            }
        });

        favorite_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, localFragment).commit();
                map_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                list_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                info_btn.setBackgroundColor(Color.parseColor("#00ff0000"));
                favorite_btn.setBackgroundColor(Color.parseColor("#F2F2F2"));
            }
        });
    }
}