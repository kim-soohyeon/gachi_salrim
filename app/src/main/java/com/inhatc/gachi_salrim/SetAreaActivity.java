package com.inhatc.gachi_salrim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SetAreaActivity extends AppCompatActivity {

    String area, areaTown;
    ArrayAdapter<CharSequence> adspin1, adspin2;
    Button complete_btn;
    Button gps_btn;
    String SIGUN = "";
    String DONG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        gps_btn = (Button) findViewById(R.id.gps_btn);
        complete_btn = (Button) findViewById(R.id.complete_btn);

        final Spinner spin1 = (Spinner) findViewById(R.id.spinnerArea);
        final Spinner spin2 = (Spinner) findViewById(R.id.spinnerArea2);

        //adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, R.layout.spinneritem);
        adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, R.layout.spinneritem);
        // adspin1.setDropDownViewResource(R.layout.spinneritem);
        adspin1.setDropDownViewResource(R.layout.spinneritem);
        spin1.setAdapter(adspin1);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                area=adspin1.getItem(position).toString();
                if (adspin1.getItem(position).equals("가평군")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Gapyoung, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            areaTown=adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("고양시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Goyang, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("과천시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Gwacheon, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            areaTown=adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("광명시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Gwangmyeong, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("광주시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Gwangju, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("구리시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Guri, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("군포시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Gunpo, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("남양주시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Namyangju, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("동두천시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Dongducheon, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("부천시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Bucheon, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("성남시 분당구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_SeongNamBundang,R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("성남시 수정구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_SeongNamSujeong, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("성남시 중원구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_SeongNamJungwon, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("수원시 권선구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_SuwonGwonseongu, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                else if (adspin1.getItem(position).equals("수원시 영통구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_SuwonYeongtong, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                else if (adspin1.getItem(position).equals("수원시 장안구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_SuwonJangan, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                else if (adspin1.getItem(position).equals("수원시 팔달구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_SuwonPaldal, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("안산시 단원구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_AnsanDanwon, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                else if (adspin1.getItem(position).equals("안산시 상록구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_AnsanSanglok, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("안성시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Anseong, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("안양시 동안구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_AnyangDongan, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                else if (adspin1.getItem(position).equals("안양시 만안구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_AnyangManan, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("양주시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Yangju, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("양평군")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Yangpeong, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("연천군")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Yeonchon, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("오산시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Osan, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("용인시 기흥구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_YonginGiheung, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("용인시 수지구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_YonginSuji, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                else if (adspin1.getItem(position).equals("용인시 처인구")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_YonginCheoin, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("의왕시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Uiwang, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("의정부시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Uijeongbu, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("이천시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Icheon, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("파주시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Paju, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("평택시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Pyeongtaek, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("포천시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Pocheon, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("하남시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Hanam, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (adspin1.getItem(position).equals("화성시")){
                    adspin2 = ArrayAdapter.createFromResource(SetAreaActivity.this, R.array.spinner_do_Hwaseong, R.layout.spinneritem);
                    adspin2.setDropDownViewResource(R.layout.spinneritem);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            areaTown=adspin2.getItem(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AreaMapsActivity.class);
                Bundle mybundle = new Bundle();

                String[] areas = area.split(" ");
                if(areas.length == 2){
                    SIGUN = area.split(" ")[0];
                    DONG = area.split(" ")[1] + " " + areaTown;
                }else {
                    SIGUN = areas[0];
                    DONG = areaTown;
                }

                mybundle.putString("SIGUN", SIGUN);
                mybundle.putString("DONG", DONG);

                intent.putExtras(mybundle);
                startActivity(intent);
                finish();
            }
        });

        gps_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AreaMapsActivity.class);
                startActivity(intent);
            }
        });
    }

}
