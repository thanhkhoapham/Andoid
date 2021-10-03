package com.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    //Khai báo
    Button bnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ bnt Next sau khi khai báo
        bnext=findViewById(R.id.btnNext);
        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,MainActivity2.class);
                //Gia lập gọi điện thoại.
//                Intent it=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:084521"));
                startActivity(it);
            }
        });
        Log.d("A", "onCreate called ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("A", "onStart called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("A", "onRestart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("A", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("A", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("A", "onStop called");
    }

}