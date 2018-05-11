# Arkkitehtuurikuvaus

## Rakenne ja luokkakaavio
Ohjelman rakenne on kolmiosainen ja sen luokkakaavio on seuraava.

![](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/kuvat/diagram1.png)

Luokkakaaviossa ylhäällä on käyttöliittymä, keskellä sovelluslogiikka ja alhaalla pysyväistallennus.    

Pakkausrakenne sisältää pakkaukset bridgecalculator.ui (käyttöliittymä) ja bridgecalculator.domain (sovelluslogiikka) ja bridgecalculator.dao (tietojen pysyväistalletus).


## Käyttöliittymä
 
Käyttöliittymä sisältää kolme näkymää.  
-Pelin kokonaispisteet   
-Erän pisteiden laskeminen ja lisääminen   
-Huipputulokset
 
Pakkaus bridgecalculator.ui on toteutettu JavaFXML:llä ja se sisältää luokat MainApp, GamePointsSceneController, RoundPointsSceneController sekä HighPointsSceneController. Näkymät on muodostettu Scenebuilderin avulla.

## Sovelluslogiikka

Sovelluslogiikka sijaitsee pakkauksessa bridgecalculator.domain, joka sisältää neljä luokkaa. RoundPointsCalculator lasekee käyttäjän syöttämien arvojen annettujen arvojen avulla erän pisteet sekä luokan GamePointsCalculator joka laskee pelin kokonaispisteitä.

## Pysyväistalletus

Pysyväistalletus sijaitsee pakkauksessa bridgecalculator.dao. Luokka FileBrigdeCalculatorDao huolehtii tiedon tallettamisesta tiedostoon.

### Tiedosto

Sovellus tallettaa päättyneen pelin lopputuloksen tiedostoon.

Sovellus tallettaa tulokset seuraavassa formaatissa:

```
NS:150:0     
EW:900:140     
EW:160:50     
NS:130:0     
```
Ensin voittanut joukkue tämän jälkeen kaksoispisteellä erotettuna voittajan pisteet ja häviäjän pisteet.

## Päätoiminnallisuudet

Kuvataan seuraavaksi sovelluksen toimintalogiikka muutaman päätoiminnallisuuden osalta sekvenssikaaviona.

### Erän pisteiden laskeminen

Kun eränpisteet näkymässä on syötetty kaikki vaadittavat tiedot ja klikataan painiketta *Laske* etenee sovellus seuraavasti:

![](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/kuvat/sekvenssi1.png)

Painikkeen painamiseen reagoiva tapahtumankäsittelijä testaa ensin onko käyttäjä täyttänyt oikein kaikki vaadittavat kentät. Tämän jälkeen se luo uuden sovelluslogiikan GamePointsCalculator luokan. Luonnin jälkeen kutsutaan luokan toString metodia, joka palauttaa laskimen laskemat arvot. Soveluksen eteneminen päättyy kun palautettu merkkijono on tulostettu tekstikenttään. 

### Pelin tuloksen tallentaminen 

Kun peli on päättynyt on mahdollista tallentaa pelin pisteet painamalla *Tallenna tulos* painiketta. Sovellus etenee tällöon seuraavasti.

![](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/kuvat/sekvenssi2.png)

## Ohjelman rakenteeseen jääneet heikkoudet

Ohjelman rakennetta voisi selventää, ja sovelluslogiikkaa eriyttää vieläkin enemmän käyttöliittymästä. Osa luokista on laajoja, niitä olisi voinut jakaa useammaksi luokaksi. 




