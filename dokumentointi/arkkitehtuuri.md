# Arkkitehtuurikuvaus

## Rakenne
Ohjelman rakenne on tällä hetkellä kaksiosainen, pakkausrakenne sisältää pakkaukset bridgecalculator.ui (käyttöliittymät) ja bridgecalculator.domain (sovelluslogiikka).
bridgecalculator.ui on toteutettu JavaFXML:llä ja sisältää luokat MainApp, RoundPointsController ja GamePintsController.
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
