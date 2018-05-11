# Arkkitehtuurikuvaus

## Rakenne
Ohjelman rakenne on kolmiosainen, pakkausrakenne sisältää pakkaukset bridgecalculator.ui (käyttöliittymät) ja bridgecalculator.domain (sovelluslogiikka) ja brbridgecalculator.dao (tietojen pysyväistalletus).
Pakkaus bridgecalculator.ui on toteutettu JavaFXML:llä ja se sisältää luokat MainApp, RoundPointsSceneController, GamePointsSceneController sekä HighPointsSceneController.
bridgecalculator.domain sisältää luokat RoundPointsCalculator, joka lasekee annettujen arvojen avulla erän pisteet sekä luokan GamePointsCalculator joka laskee pelin kokonaispisteitä.

Pakkaus bridgecalculator.dao tulee sisältämään luokan, joka vastaa pysyväistalletuksesta.

## Käyttöliittymä
 
Käyttöliittymä sisältää kaksi erilaista näkymää.  
-Pelin kokonaispisteiden näkymä   
-Erän pisteiden lisääminen   
 
Näkymät on muodostettu Scenebuilderin avulla ja käyttöliittymä on pyritty eristämään sovelluslogiikasta.

## Luokkakaavio
Alla luokkakaavio, jossa luokka Kokonaispisteet(GamePoints) ja luokka Eränpisteet(RoundPoints). 

![kuva](https://yuml.me/442a1aa3.jpg)

![](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/kuvat/diagram1.png)
