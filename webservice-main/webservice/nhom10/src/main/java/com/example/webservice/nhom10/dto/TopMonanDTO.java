package com.example.webservice.nhom10.dto;

public class TopMonanDTO {

    private int idmonan;
    private String tenmon;
    private Long monanCount;

    public TopMonanDTO(int idmonan, String tenmon, Long monanCount) {
        this.idmonan = idmonan;
        this.tenmon = tenmon;
        this.monanCount = monanCount;
    }

    // Getters and Setters
    public int getIdmonan() {
        return idmonan;
    }

    public void setIdmonan(int idmonan) {
        this.idmonan = idmonan;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public Long getMonanCount() {
        return monanCount;
    }

    public void setMonanCount(Long monanCount) {
        this.monanCount = monanCount;
    }
}
