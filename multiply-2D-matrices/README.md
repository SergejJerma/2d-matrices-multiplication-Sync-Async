# 2D matricų daugyba

Programa sinchnoniškai ir asinchroniškai sudaugina dvi įvesto dydžio kvadratines matricas 

### Back-end 
```
Java SE 11 
Spring Boot 2.2.1
Gradle 6.0.1

```
### Front-end 
```
FreeMarker
Bootstrap 4

```
## Pradžia
Programa paleidžiama iš .jar failo
* [matrices.jar](https://github.com/SergejJerma/2d-matrices-multiplication-Sync-Async/blob/master/multiply-2D-matrices/matrices.jar) 
```
java -jar matrices.jar
```
Paleidus programą, atsidaro (http://localhost:8080/) vartotojo interfeisas, kuriame jis gali įvesti matricos dydį (nemažiau 2). 

## Algoritmas
* pagal vartotojo įvestą dydį sugeneruojamos dvi matricos
* sinchroniškai atliekama dviejų matricų daugyba - fiksuojamas atlikimo laikas
* asinchroniškai (skaičiuojami atskiri naujos matricojs elementai) atliekama dviejų matricų daugyba - fiksuojamas atlikimo laikas
* asinchroniškai (skaičiuojami atskiri naujos matricojs eilučių elementai) atliekama dviejų matricų daugyba - fiksuojamas atlikimo laikas
* patikrinama iš visų metodų gautos matricos, ar jos identiškos
* vartotojui interfeise pateikiami visų skaičiavimų rezultatai

## Pavyzdys
Input:
```
Enter matrices size
1000
```
Output:
```


    Estimated time for multiply SYNC two 2D matrices of square size (1 000):
    4 578 miliseconds

    Estimated time for multiply ASYNC1 two 2D matrices of square size (1 000):
    2 968 miliseconds

    Estimated time for multiply ASYNC2 two 2D matrices of square size (1 000):
    2 563 miliseconds

    SYNC and ASYNC1/ASYNC2 matrices are equals


```
## Testai

Programoje yra paprasti integraciniai, kurie testuoja puslapių veikimą, bei moduliniai, kurie testuoja MatrixService metodus, testai


