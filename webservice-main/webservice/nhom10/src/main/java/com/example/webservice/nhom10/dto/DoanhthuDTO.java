package com.example.webservice.nhom10.dto;

public class DoanhthuDTO {
    private int iddonhang;
    private int tonggia;

    public DoanhthuDTO() {}

    public DoanhthuDTO(int iddonhang, int tonggia) {
        this.iddonhang = iddonhang;
        this.tonggia = tonggia;
    }

    public int getIddonhang() {
        return iddonhang;
    }

    public void setIddonhang(int iddonhang) {
        this.iddonhang = iddonhang;
    }

    public int getTonggia() {
        return tonggia;
    }

    public void setTonggia(int tonggia) {
        this.tonggia = tonggia;
    }
}
