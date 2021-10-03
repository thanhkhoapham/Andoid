package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThem,btnSua,btnXoa;
    ListView lv;
    GridView gv;
    ArrayList<String> data;
    ArrayAdapter arrayAdapter,arrayAdapter1;
    EditText editText;
    int index=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lvItem);
        gv= findViewById(R.id.grItem);
        editText = findViewById(R.id.editThem);
        btnThem= findViewById(R.id.btbDk);
        btnSua=findViewById(R.id.btbSua);
        btnXoa=findViewById(R.id.btbXoa);

        data = new ArrayList<>();
        data.add("Lap trinh C");
        data.add("Lap trinh C#");
        data.add("Lap trinh C++");
        data.add("Lap trinh java");
        data.add("Lap trinh python");
        //hiển thị lên listView
        //Giao diện hiện tại, giao diện hiện ra, dữ liệu đổ vào
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1, data);
        arrayAdapter1 = new ArrayAdapter(MainActivity.this, android.R.layout.simple_dropdown_item_1line, data);

        lv.setAdapter(arrayAdapter);
        gv.setAdapter(arrayAdapter1);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,data.get(i)+"", Toast.LENGTH_SHORT).show();
                index=i;
                editText.setText(data.get(i));
//                editText.setText(lv.getItemAtPosition(i).toString());
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                data.add(text);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if(index==-1)
                    Toast.makeText(MainActivity.this,"Chua chon! ", Toast.LENGTH_SHORT).show();
                else{
                    data.set(index,text);
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,"Ok ngon!", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index==-1)
                    Toast.makeText(MainActivity.this,"Chua chon! ", Toast.LENGTH_SHORT).show();
                else{
                    data.remove(index);
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,"Ok ngon!", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                }
            }
        });

    }


}