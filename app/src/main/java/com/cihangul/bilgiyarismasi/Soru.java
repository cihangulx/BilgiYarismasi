package com.cihangul.bilgiyarismasi;

/**
 * Created by Cihan on 4.11.2016.
 */

public class Soru {
    private String soruMetni;
    private String secenekA;
    private String secenekB;
    private String secenekC;
    private String secenekD;
    private String cevap;

    public Soru(String soruMetni, String secenekA, String secenekB, String secenekC, String secenekD, String cevap) {
        this.soruMetni = soruMetni;
        this.secenekA = secenekA;
        this.secenekB = secenekB;
        this.secenekC = secenekC;
        this.secenekD = secenekD;
        this.cevap = cevap;
    }

    public String getSoruMetni() {
        return soruMetni;
    }

    public void setSoruMetni(String soruMetni) {
        this.soruMetni = soruMetni;
    }

    public String getSecenekA() {
        return secenekA;
    }

    public void setSecenekA(String secenekA) {
        this.secenekA = secenekA;
    }

    public String getSecenekB() {
        return secenekB;
    }

    public void setSecenekB(String secenekB) {
        this.secenekB = secenekB;
    }

    public String getSecenekC() {
        return secenekC;
    }

    public void setSecenekC(String secenekC) {
        this.secenekC = secenekC;
    }

    public String getSecenekD() {
        return secenekD;
    }

    public void setSecenekD(String secenekD) {
        this.secenekD = secenekD;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }
}
