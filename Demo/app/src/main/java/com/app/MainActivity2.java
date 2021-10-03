package com.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends Activity {

    Button bBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Ánh xạ bnt Next sau khi khai báo
        bBack=findViewById(R.id.btnBack);
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity2.this,MainActivity.class);
                //Gia lập gọi điện thoại.
//                Intent it=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:084521"));
                startActivity(it);
            }
        });
        Log.d("A1", "onStart 1 called");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("A1", "onStart 1 called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("A1", "onRestart 1 called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("A1", "onResume 1 called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("A1", "onPause 1 called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("A1", "onStop 1 called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("A1", "onDestroy: ");
    }
}