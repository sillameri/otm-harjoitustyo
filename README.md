# Bridge Pistelaskuri

Ohjelma jolla peljaajat voivat laskea Bridge-korttipelin pisteet.


## Dokumentaatio
[maarittelydokumentti.md](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/maarittelydokumentti.md)

[työaikakirjanpito.md](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/ty%C3%B6aikakirjanpito.md)

[arkkitehtuuri.md](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)


## Releaset

[viikko5](https://github.com/sillameri/otm-harjoitustyo/releases/tag/viikko5)  
[viikko6](https://github.com/sillameri/otm-harjoitustyo/releases/tag/viikko6)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla: 

```
mvn test  
```
Testikattavuusraportti luodaan komennolla: 
```
mvn jacoco:report    
```
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html


### Checkstyle

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla: mvn jxr:jxr checkstyle:checkstyle
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/checkstyle.html

### Suoritettavan jarin generointi

Jar-tiedosto luodaan komennolla: mvn package  
Tämän jälkeen ohjelman voi suorittaa komennolla: java -jar BridgeCalculator-1.0-SNAPSHOT.jar
