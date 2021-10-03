package com.example.listviewadvance_linnerlayout;

public class SinhVien {
    private String ten;
    private String lop;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public SinhVien(String ten, String lop) {
        this.ten = ten;
        this.lop = lop;
    }
    public SinhVien() {
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ten='" + ten + '\'' +
                ", lop='" + lop + '\'' +
                '}';
    }
}
