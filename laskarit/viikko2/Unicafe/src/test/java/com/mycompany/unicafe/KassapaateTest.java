/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meri
 */
public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void palauttaaRahamaaran() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void palauttaaMaukkaatLounaat() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void palauttaaEdullisetLounaat() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void EdullinenRahamääräKasvaaOstettaessa() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void EdullinenLounasmääräKasvaaOstettaessa() {
        kassa.syoEdullisesti(420);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void EdullinenRahamääräEiKasvaaPienelläOstolla() {
        kassa.syoEdullisesti(100);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void EdullinenLounasmääräEiKasvaaPienelläOstolla() {
        kassa.syoEdullisesti(100);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void MaukasRahamääräKasvaaOstettaessa() {
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void MaukasLounasmääräKasvaaOstettaessa() {
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void MaukasRahamääräEiKasvaaPienelläOstolla() {
        kassa.syoMaukkaasti(100);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void MaukasLounasmääräEiKasvaaPienelläOstolla() {
        kassa.syoEdullisesti(100);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void KortillaSyödäänEdullinenPalauttaTrue() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }

    @Test
    public void KortillaSyödäänEdullinenOtaRaha() {
        kassa.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }

    @Test
    public void KortillaSyödäänEdullinenLounasKasvaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void KorttiEdullinenEiRahaaPalautaFalse() {
        Maksukortti kortti1 = new Maksukortti(100);
        kassa.syoEdullisesti(kortti1);
        assertEquals(false, kassa.syoEdullisesti(kortti1));
    }

    @Test
    public void KorttiEdullinenEiRahaaRahamääräPysyy() {
        Maksukortti kortti1 = new Maksukortti(100);
        kassa.syoEdullisesti(kortti1);
        assertEquals(100, kortti1.saldo());
    }

    @Test
    public void KorttiEdullinenEiRahaaLounaatPysyy() {
        Maksukortti kortti1 = new Maksukortti(100);
        kassa.syoEdullisesti(kortti1);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void KortillaSyödäänMaukasPalauttaTrue() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void KortillaSyödäänMaukasOtaRaha() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }

    @Test
    public void KortillaSyödäänMaukkaastiLounasKasvaa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void KorttiMaukasEiRahaaPalautaFalse() {
        Maksukortti kortti1 = new Maksukortti(100);
        kassa.syoMaukkaasti(kortti1);
        assertEquals(false, kassa.syoMaukkaasti(kortti1));
    }

    @Test
    public void KorttiMaukasEiRahaaRahamääräPysyy() {
        Maksukortti kortti1 = new Maksukortti(100);
        kassa.syoMaukkaasti(kortti1);
        assertEquals(100, kortti1.saldo());
    }

    @Test
    public void KorttiMaukasEiRahaaLounaatPysyy() {
        Maksukortti kortti1 = new Maksukortti(100);
        kassa.syoMaukkaasti(kortti1);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void KorttiEdullinenEiMuutaKassanRahamäärää() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void KorttiMaukasEiMuutaKassanRahamäärää() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void lataaRahaaKortinSaldoKasvaa() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
    }

    @Test
    public void lataaRahaaKassanRahamääräKasvaa() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, kassa.kassassaRahaa());
    }

    @Test
    public void lataaNegatiivistaKortinSaldoSäilyy() {
        kassa.lataaRahaaKortille(kortti, -10000);
        assertEquals(1000, kortti.saldo());
    }

}
