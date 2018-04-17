# Arkkitehtuurikuvaus

## Rakenne
Ohjelman rakenne on tällä hetkellä kaksiosainen, pakkausrakenne sisältää pakkaukset bridgecalculator.ui (käyttöliittymät) ja bridgecalculator.domain (sovelluslogiikka).
bridgecalculator.ui on toteutettu JavaFXML:llä ja sisältää luokat MainApp, FXMLController ja AloitusSivuController.
bridgecalculator.domain sisältää luokan laskin, joka lasekee annettujen arvojen avulla erän pisteet.

Pakkaus bridgecalculator.dao tulee sisältämään koodin, joka vastaa pysyväistalletuksesta.

## Käyttöliittymä
 
Käyttöliittymä sisältää kaksi erilaista näkymää.  
-Pelin kokonaispisteiden näkymä   
-Erän pisteiden lisääminen   
 
Näkymät on muodostettu Scenebuilderin avulla ja käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta.

## Luokkakaavio
Tällä hetkellä ohjelmassa on käyttöiliittymäluokkien lisäksi vain yksi luokka "Laskin", joka laskee erän aikana saadut pisteet.
Alla alustava luokkakaavio, jossa Eränpisteet luokka toteuttaa samaa toiminnallisuutta, jota luokka "Laskin" toteuttaa tällä hetkellä.

![kuva](https://yuml.me/442a1aa3.jpg)
