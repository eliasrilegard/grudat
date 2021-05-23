# Övning 6

## Dynamisk programmering

#### Förklara varför rekursionen fungerar
Den maximala inkomsten som man kan tjäna genom att sticka halsdukar av *n* meter garn fungerar genom att betrakta alla
olika kombinationer av halsdukar. Exempelvis för 3 meter garn behöver vi bl.a. jämföra inkomsten av att sticka
halsdukar för 1 + 2 meter eller att sticka en enda halsduk för alla 3 meter. Värdet som returneras är alltså det
största värdet av alla möjliga kombinationer.

#### Implementera en rekursiv funktion som beräknar p(n)
Se [`Scarf.java`](Scarf.java). Notera att jag här har använt värdena på h som är givna nedan.

#### Beräkna p(5) när h[1] = 2, h[2] = 5, h[3] = 6, h[4] = 9 och h[n] = 0 när n > 4. Simulera beräkningen för hand och rita ett träd över alla funktionsanrop.

För att beräkna p(5) behöver vi beräkna följande:

<ul>
<li>h[1] + p(4)</li>
<li>h[2] + p(3)</li>
<li>h[3] + p(2)</li>
<li>h[4] + p(1)</li>
<li>h[5] + p(0) = 0</li>
</ul>

För att beräkna p(4) behöver vi beräkna följande:

<ul>
<li>h[1] + p(3)</li>
<li>h[2] + p(2)</li>
<li>h[3] + p(1)</li>
<li>h[4] + p(0) = 9</li>
</ul>

För att beräkna p(3) behöver vi beräkna följande:

<ul>
<li>h[1] + p(2)</li>
<li>h[2] + p(1)</li>
<li>h[3] + p(0) = 6</li>
</ul>

För att beräkna p(2) behöver vi beräkna följande:

<ul>
<li>h[1] + p(1)</li>
<li>h[2] + p(0) = 5</li>
</ul>

För att beräkna p(1) behöver vi beräkna följande:

<ul>
<li>h[1] + p(0) = 2</li>
</ul>

Detta leder till att p(2) = max(2+2, 5) = 5, vilket låter oss beräkna p(3) = max(2+5, 5+2, 6) = 7, osv tillbaka upp.
p(4) = max(2+7, 5+5, 6+2, 9) = 10, och till slut kommer vi till att p(5) = max(2+10, 5+7, 6+5, 9+2, 0) = 12.

För ett träd av alla funktionsanrop, se [`tree.txt`](tree.txt).

#### Förklara varför tidskomplexiteten för denna funktion är exponentiell.
Vid en ökning av *n* med 1 så görs dubbelt så många funktionsanrop (hänvisar till [`tree.txt`](tree.txt)). Om vi
betraktar varje funktionsanrop som en elementaroperation kommer tidskomplexiteten alltså minst därför bli
*O*(2<sup>*n*</sup>)

#### Förbättra tidskomplexiteten genom att skriva en version av programmet som cachar delresultat.

Se [`ScarfCached.java`](ScarfCached.java).

#### Räkna ut en tabell över p(n) för n = 0, 1, 2, 3, 4, 5 (med samma h som ovan)

Se detaljerna kring implementationen av beräkningen och processen vid beräkningen av p(5), alla värden är beräknade där.

```
n | p(n)
--------
0 | 0
1 | 2
2 | 5
3 | 7
4 | 10
5 | 12
```

#### Visa att tidskomplexiteten för den uppdaterade koden är O(n<sup>2</sup>).

Vi har en forloop som går igenom 1 tom n, och en nestad forloop som går från 1 till `i`. Resten av funktionen är i
princip elementäroperationer, dvs tidskomplexiteten blir *O*(*n*<sup>2</sup>).

#### Mer dynamisk programmering

Se [`ScarfCached.java`](ScarfCached.java).

#### Projekt

Se `eliasril-ovn7`