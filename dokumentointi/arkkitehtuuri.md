# Arkkitehtuurikuvaus

## Rakenne ja luokkakaavio
Ohjelman rakenne on kolmiosainen ja sen luokkakaavio on seuraava.

![](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/kuvat/diagram1.png)

Luokkakaaviossa ylhäällä on käyttöliittymä, keskellä sovelluslogiikka ja alhaalla pysyväistallennus.    

pakkausrakenne sisältää pakkaukset bridgecalculator.ui (käyttöliittymä) ja bridgecalculator.domain (sovelluslogiikka) ja bridgecalculator.dao (tietojen pysyväistalletus).


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

## Luokkakaavio
Alla luokkakaavio, jossa luokka Kokonaispisteet(GamePoints) ja luokka Eränpisteet(RoundPoints). 

![kuva](https://yuml.me/442a1aa3.jpg)


