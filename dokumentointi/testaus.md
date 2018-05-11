# Testausdokumentti

Ohjelmaa on testattu yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Automatisoitujen testien ytimen moudostavat sovelluslogiikkaa testaavat testit. 
Testikansiossa DomainTest sijaitsevat testiluokat GamePointsTest, RoundPointsTest sekä WinnerResultTest 
Luokat RoundPointsTest ja WinnerResultTest koostuvat yksikkötesteistä, jotka testaavat ovatko metodien palauttamat arvot oikeita eri syötteillä.
Luokka GamePointsTest koostuun yksikkötestien lisäksi integraatiotesteistä, joissa pisteitä haetaan ensin RoundPointsCalculator luokalta ja käsitellään tämän jälkeen.

### Dao

Dao luokan testaus tapahtuu testikansiossa DaoTest, luokassa FileDaoTest. Luokkan testit hyödyntävät testiejä varten luotua "testdata.txt" tiedostoa.

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 85% ja haarautumakattavuus 80%


## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus

Sovellus on asennettu ja sitä on testattu käyttöohjeen kuvaamalla tavalla OSX-, Linux ja Windows-ympäristöissä.


### Toiminnallisuudet

Kaikki määrittelydokumentin ja käyttöohjeen toiminnallisuudet on käyty läpi.    
Läpikäynnin yhteydessä on syötekentät yritetty täyttää myös virheellisillä arvoilla.
