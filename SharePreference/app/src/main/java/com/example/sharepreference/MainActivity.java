package com.example.sharepreference;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnClick, btnLogin, btnDN,btnThoat,btnView,btnClean;
    TextView textView;
    ImageView imageView;
    CheckBox ckb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = findViewById(R.id.btnClick);
        btnLogin = findViewById(R.id.btnLogin);
        btnClean=findViewById(R.id.btnClean);
        btnView=findViewById(R.id.btnView);
        textView= findViewById(R.id.txtView);
        imageView= findViewById(R.id.imageView);
        ckb= findViewById(R.id.checkBox);
//        btnDN = findViewById(R.id.btnDN);

        //Tạo đối tượng để ghi nhỡ dữ liêu
        SharedPreferences sharedPreferences=getSharedPreferences("dulieu",MODE_PRIVATE);
        //Lấy dữ liệu từ share Preference sau khi đã ghi nhớ trước đó.(File ghi nhớ noidung)
        String nd= sharedPreferences.getString("noidung","");
        textView.setText(nd);
        ckb.setChecked(sharedPreferences.getBoolean("checkNoiDung",false));

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AssetManager assetManager= getAssets();
                try {
                    //Đọc text
                    InputStream is= assetManager.open("LoiNho.txt");
                    int size= is.available();
                    byte[] bytes= new byte[size];
                    is.read(bytes);
                    is.close();
                    textView.setText( new String(bytes));
                    //Đọc image
                    InputStream isImage= assetManager.open("img/hoa.png");
                    Drawable drawable = Drawable.createFromStream(isImage,null);
                    imageView.setImageDrawable(drawable);

                    //Check ghi nhớ data (File ghi nhớ noidung)
                    if(ckb.isChecked()){
                        SharedPreferences.Editor edit= sharedPreferences.edit();
                        edit.putString("noidung",new String(bytes));
                        edit.putBoolean("checkNoiDung",true);
                        edit.commit();
                    }
                    else {
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.remove("noidung").remove("checkNoiDung").commit();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setMessage("Mày có muốn thoát không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Có nèk", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Hông", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });

    }
}