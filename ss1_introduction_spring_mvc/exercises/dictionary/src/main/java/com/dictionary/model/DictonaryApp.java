package com.dictionary.model;

public class DictonaryApp {
    private String en;
    private String vie;

    public DictonaryApp() {
    }

    public DictonaryApp(String en, String vie) {
        this.en = en;
        this.vie = vie;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVie() {
        return vie;
    }

    public void setVie(String vie) {
        this.vie = vie;
    }
}
