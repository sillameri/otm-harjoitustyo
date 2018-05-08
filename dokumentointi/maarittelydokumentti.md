# Vaatimusmäärittely

## Soveluksen tarkoitus

Sovelluksen avulla käyttäjien on mahdollista laskea Bridge korttipelin pisteet. Sovellukseen syötetään korttipelin kulkua erä kerrallaan. Sovellus laskee joukkueille pisteitä ja kertoo kun peli loppuu. Loppuun asti pelatun pelin pisteet voi halutessaan tallentaa pelin päätyttyä. Sovellus tarjoaa mahdollisuudn myös tarkastella huippupisteitä.

## Käyttäjät

Sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä. 

## Käyttöliittymäluonnos

Sovellus koostuu kolmesta näkymästä. Sovellus aukeaa päänäkymään, joka laskee kokonaispelin pisteitä. Päänäkymästä voi siityä näkymään, jossa käyttäjä voi syöttämieen tietojen avulla laskea yhden erän pisteet. Kun pelaaja palaa takaisin päänäkymään päivittyy päänäkymän pistetaulukko. Päänäkymästä on mahdollista siirtyä myös highscore näkymään, joka näyttää sillä hetkellä tilastojen viisi parasta peliä.  



## Perusversion tarjoama toiminnallisuus

### Päänäkymässä käyttäjä voi:
- Lopettaa pelin
- Siirtyä erän pisteet näkymään
- Siirtyä huipputulokset näkymään 
- Aloittaa pelin alusta
- Tallentaa päättyneen peli pisteet

### Laske erän pisteet näkymässä käyttäjä voi:
-palata takaisin päänäkymään   
-laskea pisteitä syöttämällä seuraavat tiedot.
&nbsp -Tarjouskierroksen voittanut joukkue
&nbsp;&nbsp;&nbsp; NS tai EW

&nbsp -Lopullinen tarjous  
  &nbsp;&nbsp;&nbsp; trikkien määrä (1-7)  
  &nbsp;&nbsp;&nbsp; valttimaa (valtiton,pata,hertta,ruutu,risti)  
  
&nbsp -Tarjous vaihtoehdot  
  &nbsp;&nbsp;&nbsp; normaali  
  &nbsp;&nbsp;&nbsp; kahdennus  
  &nbsp;&nbsp;&nbsp; vastakahdennus  
  &nbsp;&nbsp;&nbsp; vaarassa  
  &nbsp;&nbsp;&nbsp; vaaraton  
  
&nbsp -Tulos   
  &nbsp;&nbsp;&nbsp; tikkien määrä (1-7)  
  &nbsp;&nbsp;&nbsp; yli  
  &nbsp;&nbsp;&nbsp; ali  
  
  
### Huippupisteet näkymässä käyttäjä voi: 
-tarkastella viittä parasta peliä
-palata takaisin päänäkymään


## Jatkokehitysideoita

-käyttäjä voisi muuttaa joukkueiden nimi ennen peliä
-kokonaispisteitä laskeavan taulukon tekeminen tyylikkäämmäksi
-pisteet tallentuisivat tietokantaan 
