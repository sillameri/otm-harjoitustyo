/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bridgepointcalculator;

/**
 *
 * @author Meri
 */
public class Laskin {

    private String maa;
    private int trikki;
    private int tikki;
    private String tulos;

    public Laskin(String maa, int trikki, int tikki, String tulos) {
        this.maa = maa;
        this.trikki = trikki;
        this.tikki = tikki;
        this.tulos = tulos;

    }

    public int getTrikki() {
        return this.trikki;
    }

    public int getTikki() {
        return this.tikki;
    }

    public int getMaaKerroin() {
        int kerroin = 0;
        if (maa.equals("Pata") || maa.equals("Hertta")) {
            kerroin = 30;
        }
        if (maa.equals("Ruutu") || maa.equals("Risti")) {
            kerroin = 20;
        }
        if (maa.equals("valtition")) {

        }
        return kerroin;
    }

    public int laskeAlleLinjan() {
        int pisteetAlleLinjan = 0;

        pisteetAlleLinjan = getTrikki() * getMaaKerroin();

        return pisteetAlleLinjan;
    }

    public void laskeyliLinjan() {

    }

    @Override
    public String toString() {
        return "Tarjous: " + trikki +  " " + maa + ". Tulos: " + tikki + " " + tulos
                + " Voitetut pisteet alle linjan: " + laskeAlleLinjan()
                + " Voitetun pisteet linjan päälle: ";
    }

}
