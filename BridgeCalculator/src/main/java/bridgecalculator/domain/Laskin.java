/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.domain;

/**
 *
 * @author Meri
 */
public class Laskin {

    private String maa;
    private int trikki;
    private int tikki;
    private String tulos;
    private String tuplaus;
    private String vaara;

    public Laskin(String maa, int trikki, int tikki, String tulos, String tuplaus, String vaara) {
        this.maa = maa;
        this.trikki = trikki;
        this.tikki = tikki;
        this.tulos = tulos;
        this.tuplaus = tuplaus;
        this.vaara = vaara;

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
        return kerroin;
    }

    public int getPisteetAlleValtiton() {
        int pisteet = 0;
        if (maa.equals("Valtiton")) {
            if (getTrikki() == 1) {
                pisteet = 40;
            }
            pisteet = 40;
            for (int i = 0; i < getTrikki() - 1; i++) {
                pisteet += 30;
            }
        }
        return pisteet;
    }

    public int getPisteetYlleValtiton() {
        int pisteet = 0;
        if (maa.equals("Valtiton")) {
            if (getTikki() == 1) {
                pisteet = 40;
            }
            pisteet = 40;
            for (int i = 0; i < getTikki() - 1; i++) {
                pisteet += 30;
            }
            if (getTikki() == 0) {
                pisteet = 0;
            }
        }
        return pisteet;
    }

    public int laskeAlleLinjan() {
        int pisteetAlleLinjan = 0;

        if (tulos.equals("Yli")) {
            if (maa.equals("Valtiton")) {
                pisteetAlleLinjan = getPisteetAlleValtiton();
            } else {
                pisteetAlleLinjan = getTrikki() * getMaaKerroin();
            }
        }
        return pisteetAlleLinjan;
    }

    public int laskeYliLinjan() {
        int pisteetYliLinjan = 0;
        if (tulos.equals("Yli")) {
            if (maa.equals("Valtiton")) {
                pisteetYliLinjan = getPisteetYlleValtiton();
            } else {
                pisteetYliLinjan = getTikki() * getMaaKerroin();
            }
        }
        return pisteetYliLinjan;
    }

    public int laskeHavitytPisteet() {
        int havitytPisteet = 0;

        if (tulos.equals("Ali")) {
            for (int i = 0; i < getTikki(); i++) {
                havitytPisteet += 100;
            }
        }
        return havitytPisteet;
    }

    @Override
    public String toString() {
        return "Tarjous: " + trikki + " " + maa + ". Tulos: " + tikki + " " + tulos + "\n"
                + "Voitetut pisteet alle linjan: " + laskeAlleLinjan() + "\n"
                + "Voitetut pisteet linjan päälle: " + laskeYliLinjan() + "\n"
                + "Hävityt pisteet: " + laskeHavitytPisteet();

    }

}
