package com.example.checkbox_radio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox ck1, ck2;
    Button btndk;
    RadioButton rdNam, rdNu;
    RadioGroup rdGroup;
    TextView txtTime;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ
        ck1 = findViewById(R.id.chkLTC);
        ck2 = findViewById(R.id.chkTDD);
        btndk = findViewById(R.id.btnDk);
        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);
        rdGroup = findViewById(R.id.rdGroup);
        txtTime= findViewById(R.id.txtTime);
        seekBar= findViewById(R.id.seekBar);

        //Xử lý thời gian
        //Thay đổi Thumd trong Common Attributes để có nút đẹp hơn
        CountDownTimer countDownTimer=new CountDownTimer(10000,1000) {

            @Override  //Cứ mỗi giây nó làm gì
            public void onTick(long l) {
                int so=Integer.parseInt(txtTime.getText().toString());
                so-=1;
                txtTime.setText(so+"");
                int tg= seekBar.getProgress();
                tg+=10;
                seekBar.setProgress(tg);
            }

            @Override
            public void onFinish() {
                txtTime.setText("0");
                Toast.makeText(MainActivity.this,"Het gio",Toast.LENGTH_SHORT).show();
                seekBar.setProgress(seekBar.getMax());//Lấy max của seekbar
            }
        }.start();
        //Load lên là chơi lun
//        countDownTimer.start();
        //================
        //Xử lý cho button
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Mon hoc dang ky:\n";
                if (ck1.isChecked()) {
                    str += ck1.getText().toString() + "\n";
                }
                if (ck2.isChecked()) {
                    str += ck2.getText().toString() + "\n";
                }
                if (!ck1.isChecked() && !ck2.isChecked())
                    str = "Chua dang ky!";
//                else
//                    Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();

                //Xử lý radio button
                if (rdNam.isChecked())
                    Toast.makeText(MainActivity.this, rdNam.getText().toString(), Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, rdNu.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        //=====================================
        //Check ngay khi click trong checkBox
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(MainActivity.this, ck1.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(MainActivity.this, ck2.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        //=================
        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rdNam:
                        Toast.makeText(MainActivity.this, rdNam.getText().toString(), Toast.LENGTH_LONG).show();
                        break;
                    case R.id.rdNu:
                        Toast.makeText(MainActivity.this, rdNu.getText().toString(), Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}