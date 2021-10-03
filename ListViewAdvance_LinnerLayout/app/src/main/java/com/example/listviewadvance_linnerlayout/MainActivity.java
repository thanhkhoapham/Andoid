package com.example.listviewadvance_linnerlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    List<SinhVien> sinhViens;
    SinhVienAdapter sinhVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= findViewById(R.id.lvItem);
        sinhViens= new ArrayList<>();
        sinhViens.add(new SinhVien("Khoa","K13"));
        sinhViens.add(new SinhVien("Thanh","K14"));
        sinhViens.add(new SinhVien("Pham","K15"));


        sinhVienAdapter = new SinhVienAdapter(MainActivity.this,R.layout.itemlayout,sinhViens);
        lv.setAdapter(sinhVienAdapter);
    }
}