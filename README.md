# Bridge Pistelaskuri

Ohjelma jolla peljaajat voivat laskea Bridge-korttipelin pisteet.


## Dokumentaatio
[Käyttöohje](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/k%C3%A4yttoohje.md)

[Maarittelydokumentti](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/maarittelydokumentti.md)

[Arkkitehtuuri](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/testaus.md)

[Työaikakirjanpito](https://github.com/sillameri/otm-harjoitustyo/blob/master/dokumentointi/ty%C3%B6aikakirjanpito.md)

## Releaset

[viikko 5](https://github.com/sillameri/otm-harjoitustyo/releases/tag/viikko5)  
[viikko 6](https://github.com/sillameri/otm-harjoitustyo/releases/tag/viikko6)

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

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla:

```
mvn jxr:jxr checkstyle:checkstyle
```
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/checkstyle.html

### Suoritettavan jarin generointi

Jar-tiedosto luodaan komennolla:

```
mvn package  
```
Tämän jälkeen ohjelman voi suorittaa komennolla: java -jar BridgeCalculator-1.0-SNAPSHOT.jar

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc 
```
JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

