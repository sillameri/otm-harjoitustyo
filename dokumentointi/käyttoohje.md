# Käyttöohje

Lataa tiedosto [BridgeCalculator.jar](./BridgeCalcularor.jar)  ei toimi!!!

## Konfigurointi ???

## Ohjelman käynnistäminen 

Ohjelma käynnistetään komennolla:

```
java -jar BridgeCalculator.jar
```

## Taustatietoa Bridgepelistä    

Oletuksena on että käyttäjä tuntee bridge pelin säännöt. Pisteiden laskuun käytettän Rubber Bridge sääntöjä.     
Huomioitavaa on myös ettei sovellus laske ylimääräisiä bonuksia (esim. slam tai 4 ässsää on yhdessä kädessä).     
  
Bridge on nelihenkinen korttipeli, jossa kaksi joukkuetta NS (North-South) ja EW (East-West) pelaavat toisiaan vastaan.    
&nbsp;&nbsp;&nbsp;&nbsp; Jokainen erä alkaa tarjouskierroksella, jonka lopputuloksena suurin tarjous asettaa alkuvaatimukset alkavalle pelierälle. Esimerkkitapaus: jos joukkue NS voitta tarjouskierroksen tarjouksella "3 Pata", tarkoittaa tämä että tulevan pelierän valttimaa on Pata ja että joukkueen NS on kerättävä itselleen vähintään 9 tikkiä (6+3) voittaakeen erän. Erän päätyttä lasketaan montako tikkiä tarjouskierroksen voittanut joukkue (NS) keräsi pelin aikana ja onko määrä yli vai alle sen määrän, jonka joukkue lupasi tarjouskierroksella itselleen voittaa (9).   
&nbsp;&nbsp;&nbsp;&nbsp; Pisteitä kerttyy molemmille joukkueille viivan alle ja viivan päälle. Jos esimerkkitapaus päättyy tilanteeseen "2 yli", saa joukkue (NS)  viivan alle pisteitä, jotka vastaavat kolmea tikkiä. Kaksi tikkiä jotka saatiin yli tarjouksesta kerryttävät pisteitä viivan päälle. Joukkue häviää, jos se ei onnistu pelin aikana keräämään tarjouksen verran tikkejä (9), tällöin tulos merkataan "ali". Näissä tapauksissa hävittyt pisteet lisätään vastakkaisen joukkueen viivan yllä oleviin pisteisiin.     
&nbsp;&nbsp;&nbsp;&nbsp; Kun joukkue saa kerättyä viivan alle yli 100 pistettä, voittaa joukkue ensimmäisen pelin ja pisteiden alle vedetään uusi viiva jonka alle ryhdytään keräämään toisen pelin pisteitä. Kokonaispeli loppuu kun toinen joukkueista voittaa kaksi tällaista sadan pisteen peliä. Lopulliset pisteet lasketaan joukkueelle summaamalla viivan yläpuolella ja alapuolella olevat pisteet. Jos joukkue voittaa kaksi peliä (viivan alle yli 100 pistettä) peräkkäin, lisätään joukkueen lopullisiin pisteisiin 700 pistettä. Muussa tapauksessa voittava joukku saa 500:n pisteen bonuksen.       
&nbsp;&nbsp;&nbsp;&nbsp; Erikoisolosuhteista. Tarjouskierroksella on mahdolista myös kahdentaa tai vastakahdentaa pisteet, tällöin pelataan suuremmista pisteitstä.    
Joukkue joka saa ensimmäisenä viivan alle 100 pistettä on "vaarassa" kunnes toinen joukkue saa myös 100 pistettä viivan alle tai kunnes koko peli loppuu. "Vaarassa" oleva joukkue kerryttää hävitessään enemmän pisteitä vastustajalle, kuin "vaarattomana".  



## Kokonaispelin pisteet 

Sovellus aukee näkymään, jossa näkyy pelin kokonaispisteet.

![](/dokumentointi/kuvat/tyhjäpeli.png) 

Painamalla nappulaa *Lopeta peli* sovellus sulkeuttuu.   
Nappulan *Aloita uusi peli* kautta voi aloittaa pelin uudelleen.  
Nappulan *Tallenna tulos* kautta on mahdollista tallentaa pelin pisteet, tämä on mahdollista vasta kun peli on pelattu loppuun.

## Erän pisteet   

Kokonaispisteetnäkymästä on mahdollista siirtyä erän pisteet näkymään panikkeella *Lisää kierroksen pisteet*.    

![](/dokumentointi/kuvat/pisteeterä.png)

Erän pisteet lasketaan täyttämällä vaaditut kentät ja painamalla nappulaa *laske*. Jos kaikkia kentät on täytetty, näkyy lasketut pisteet näkymän alalaidassa. Mikäli kaikkia kenttiä ei ole täytetty tulostuu virheteksti "Täytä kaikki kentät".     
Painamalla nappulaa *Lisää pisteet ja palaa* siirrytään takaisin kokonaispisteet näkymään ja juuri lasketut pisteet ovat päivittyneet kokonaispisteisiin. 

## Huipputulokset

Huipputulokset pop-up ikkuna aukeaa painamalla painiketta *Huipputulokset*

![](/dokumentointi/kuvat/Huippu.png)

Ikkuna näyttää käyttäjälle viisi parasta peliä. 

## Pelin päättyminen 

Peli päättyy kun jompikumpi joukkue saa kaksi kertaa yli 100 pistettä viivan alle. Pelin päättymisestä ilmoitetaan tekstikentässä. 

![](/dokumentointi/kuvat/Peliloppu.png)

Pelin päätyttyä uusia erän pisteitä ei ole enää mahdollista lisätä. Sen sijaan käyttäjä voi tallentaa lopputuloksen painamalla *Tallenna tulos*, tämän jälkeen on myös mahdollista tarkasetella ovatko omat pisteet yltäneet huipputulosten joukkoon.





