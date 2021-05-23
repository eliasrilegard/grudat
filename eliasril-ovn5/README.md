# Övning 5

## 1 Rita grafer

Se [`upg1.pdf`](upg1.pdf).

## 2 Räkna kanter

#### Hur många kanter kan det som mest finnas i en graf med n stycken hörn?

Då det inte är specificerat om grafen är enkel eller inte kan vi anta att den inte behöver vara det. Således kan vi
alltså alltid lägga till en till kant från vilket hörn som helst till vilket annat som helst, inklusive samma hörn
själv. Det finns alltså inte någon övre gräns på hur många kanter som kan förekomma i denna typ av graf.

#### Hur många kanter kan det som mest finnas i en enkel graf med n stycken hörn?

I en enkel graf förekommer det maximalt antal kanter då varje hörn är granne med alla andra hörn, dvs vi måste betrakta
den kompletta grafen *K<sub>n</sub>*. Formeln för antalet kanter i *K<sub>n</sub>* är känd: __*n* \* (*n* - 1) / 2__.

#### Hur många kanter kan det som mest finnas i ett träd med n stycken hörn?

Här kan vi matcha varje hörn i grafen till en unik kant, med undantag för roten av trädet. Således förekommer det 
__*n* - 1__ kanter i ett träd med *n* hörn.

## 3 DFS och BFS

För DFS kommer noderna besökas (markeras som besökta) i ordning 1, 2, 3, 4, 5, 6. 

Dock kommer det ske betydligt fler anrop till funktionen än endast 6 gånger, om koden är implementerad likt den är på
[yourbasic](https://yourbasic.org/algorithms/graph/). Den fullständiga listan för vilka noder som DFS anropas på blir
då: 1, 1, 2, 1, 3, 2, 4, 3, 5, 1, 2, 4, 6, 4, 5, 5. Det beror bara på var någonstans som checken om noden är besökt
eller inte sitter någonstans.

För BFS kommer noderna besökas (markeras som besökta) i ordning 1, 2, 5, 3, 4, 6.

Närhetslistan kan ses som en matris med olika rader där raderna blir kortare ju färre grannar ett givet hörn har,
jämfört med närhetsmatrisen som alltid kommer ha rader lika långa som antalet hörn i grafen. På så sätt kommer vi spara
tid på att inte loopa igenom värstafallet och bara genom antalet grannar för det givna hörnet.

I det fallet då alla rader i närhetslistan är ungefär lika långa som raderna i matrisen (dvs när matrisen nästan inte
har några 0or) kommer tidskomplexiteten bli densamma. Det infallet när grafen är nära en komplett graf. Närhetslistan
kommer ta *O*(*n* - 1) att gå igenom (-1 då vi inte tillåter hörn att vara granne med sig själv) och närhetsmatrisen
*O*(*n*). Dessa tider blir dock asymptotiskt lika för stora n.

## 4 En noggrann lärare

Vi modellerar eleverna som en graf. Om två elever känner varandra har motsvarange hörn i grafen en kant mellan sig. För
att testa om det räcker med två uppgifter för att inga elever som känner varandra ska få samma uppgift måste vi leta
efter en delgraf som är en udda cykel. En udda cykel kan inte färgläggas så angränsande hörn har olika färger, med
endast två färger (det krävs tre), där vi kan dra analogin av en färg med en av uppgifterna som ska ges ut.

<pre><code><b>Algorithm</b> oddLoopExists(G)
  <b>for</b> src ← every vertex of G   // O(V)
    src.color ← 1
    Q ← new empty FIFO queue
    Add src to Q
    <b>while</b> Q is not empty   // O(2E)
      u ← Next of Q
      <b>for</b> v ← every neighbor of u   // O(1)*
        <b>if</b> v.color is undefined
          // Set to opposite of u.color
          v.color ← 1 - u.color
          Add v to queue
        <b>else if</b> v.color == u.color
          <b>return</b> true
  <b>return</b> false
</code></pre>

Vi antar här att grafen är relativt gles. Vi kommer iterera genom alla hörn i grafen - *O*(|V|) - och för varje
iteration kommer kön gå igenom alla kanter (med hjälp av forloopen, som endast går igenom alla grannar), alltså
*O*(2|E|). Således kommer tidskomplexiteten för algoritmen bli *O*(|V||E|). Notera även att algoritmen tar hänsyn till
om grafen inte är sammanhängande.
