package com.example.listviewadvance_linnerlayout;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> sinhViens;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhViens) {
        this.context = context;
        this.layout = layout;
        this.sinhViens = sinhViens;
    }

    @Override
    public int getCount() {
        return sinhViens.size();
    }// Số phần tử

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout, null);
        //Ánh xạ phần tử của layout itemlayout.xml
        TextView ten = view.findViewById(R.id.txtTen);
        TextView lop = view.findViewById(R.id.txtlop);

        SinhVien sinhVien = sinhViens.get(i);
        ten.setText(sinhVien.getTen());
        lop.setText(sinhVien.getLop());

        return view;
    }// Ánh xá layout tạo lên view
}
