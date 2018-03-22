package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void palauttaaSaldon() {
        assertEquals(1000, kortti.saldo(), 0);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }

    @Test
    public void LataaminenKasvattaaSaldoa() {
        kortti.lataaRahaa(2500);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }

    @Test
    public void OttaminenVahentaaSaldoa() {
        kortti.otaRahaa(500);
        assertEquals("Kortilla on rahaa 5.0 euroa", kortti.toString());
    }

    @Test
    public void OttaminenEiOnnistuJosRahaaLiianVähän() {
        kortti.otaRahaa(5000);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }

    @Test
    public void RahaRiittääPalautaTrue() {
        kortti.otaRahaa(500);
        assertEquals(true, kortti.otaRahaa(500));
    }

    @Test
    public void RahaEiRiitäPalautaFalse() {
        kortti.otaRahaa(5000);
        assertEquals(false, kortti.otaRahaa(5000));
    }

}
