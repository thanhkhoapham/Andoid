package com.example.dialog_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnClick, btnLogin, btnDN,btnThoat,btnView,btnClean;
    TextView textView;
    ImageView imageView;


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
//        btnDN = findViewById(R.id.btnDN);
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
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_login);
                dialog.setCancelable(false);

                EditText name = dialog.findViewById(R.id.txtName);
                EditText password = dialog.findViewById(R.id.txtPass);
                btnDN= dialog.findViewById(R.id.btnDN);
                btnThoat= dialog.findViewById(R.id.btnThoat);

               btnDN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"Exit",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
               btnThoat.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       finish();
                   }
               });

                dialog.show();
            }
        });

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
                }catch (Exception e){
                    e.printStackTrace();
                }
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