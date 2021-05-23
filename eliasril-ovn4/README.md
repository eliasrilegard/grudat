# Övning 4

## 1 Tidskomplexitet för rekursiva funktioner

### Teori

#### pow( )

Här ser vi att tiden för basfallet är T(0) = 1 (*)

För T(n) har vi att T(n) = T(n/2) + 1 (**)

Alltså får vi att T(n) = T(n/2) + 1 = (\*\*) = T(n/4) + 1 + 1 = (\*\*) = T(n/2<sup>_k_</sup>) + k

n/2<sup>_k_</sup> < 1 då _k_ = log _n_, vilket ger att T(_n_) = log _n_ + 1 = _Θ_(log _n_)

#### sum1( )

Som innan, basfallet är T(1) = 1 (*)

T(n) = 2 * (_n_/2 + T(_n_/2)) (\*\*)

Alltså får vi T(n) = n + 2 T(_n_/2) = (\*\*) = n + 2 * (_n_/2 + 2 T(_n_/4)) = 2<i>n</i> + 4 T(_n_/4) = (\*\*) = 
2<i>n</i> + 4 * (_n_/4 + 2 T(_n_/8)) = 3<i>n</i> + 8 T(_n_/8) = _k_<i>n</i> + 2<sup>_k_</sup> T(_n_/2<sup>_k_</sup>)

n/2<sup>_k_</sup> = 1 då _k_ = log _n_, vilket ger att T(_n_) = _n_ log _n_ + _n_ T(1) = (*) = _n_ log _n_ + _n_ = 
_Θ_(_n_ log _n_)

#### sum2( )

T(1) = 1 (*)

T(_n_) = 1 + 2 T(_n_/2) (\*\*)

T(_n_) = (\*\*) = 1 + 2 * (1 + 2 T(_n_/4)) = 3 + 4 T(_n_/4) = (\*\*) = 3 + 4 * (1 + 2 T(_n_/8)) = 7 + 8 T(_n_/8) =
2<sup>_k_</sup> - 1 + 2<sup>_k_</sup> T(_n_/2<sup>_k_</sup>)

n/2<sup>_k_</sup> = 1 då _k_ = log _n_, vilket ger att T(_n_) = _n_ - 1 + _n_ T(1) = (*) = 2<i>n</i> - 1 = _Θ_(_n_)

### Praktik

Se den bifogade bilden för ett diagram över hur exekveringshastigheten beror på storleken på input för de 
olika funktionerna. Notera att x-axeln är storleken på input och y-axeln är tiden för att köra funktionen i sekunder.

### Diskussion

Från testning av koden på olika datorer är det uppenbart att körtiden för koden beror starkt på datorns prestanda, men
även på andra processer som kan vara körandes i bakgrunden. Att lagra information i variabler (and by extension, i
minnet) tar också lite tid som inte heller alltid är exakt densamma mellan körningar. Det är därför rimligt att kurvorna
i bilden inte är helt jämna eller raka. Vi noterar att `sum1()` och `sum2()` båda ser väldigt lika ut, detta tack vare
att de är O(n log n) respektive O(n), och att log(x) växer väldigt långsamt jämfört med x. `pow()` däremot går mycket snabbare att köra då den går på _O_(log _n_) tid.

## 2 Linjärtidssortering av små tal

Se `CountingSort.java` för själva implementationen av algoritmen.

### För vilka k blir algoritmen linjär?

Algoritmen kommer vara linjär för alla värden på k ∈ _O_(_n_), alltså när k är i samma storleksordning (eller
mindre) som n. För större värden på k - säg <i>n</i><sup>2</sup>, alltså om talen varierar kraftigt och inte är
särskilt många - kommer tidskomplexiteten bli <i>O</i>(<i>n</i> + <i>n</i><sup>2</sup>) = 
<i>O</i>(<i>n</i><sup>2</sup>), vilket inte längre är linjärt.

## 3 Linjärtidssortering när det finns många dubbletter

<pre><code><b>Algorithm</b> sort(array):
  Create a hashmap -> "map"
  <b>for</b> elem <b>of</b> array:
    <b>if</b> map[elem] is already a key:
      map[elem] += 1
    <b>else</b>:
      map[elem] = 1
  Sort the keyset of map -> "keys"
  Create vector -> "output"
  <b>for</b> key <b>of</b> keys:
    Add key to output map(key) times
  return output
</code></pre>

För att beskriva algoritmen ännu mer kortfattat så räknar vi hur många gånger varje element förekommer och lagrar det i
en hashtabell. Vi sorterar sedan listan med alla nycklar (dvs alla unika tal som förekommer i listan), och efter det
går vi igenom den sorterade nyckellistan och lägger till nyckeln antalet gånger (lagrat i tabellen) i en separat array
som sedan returneras. Det som till slut returneras är en sorterad array.

Arrayen sorteras på tiden <i>O</i>(<i>n</i> + <i>k</i> log <i>k</i>), där det förekommer k olika element, totalt n
stycken. Detta eftersom det tar <i>O</i>(<i>n</i>) tid att iterera genom alla element i den givna listan. Att lagra
antalet gånger varje tal förekommer på går på <i>O</i>(1) tid, och att sortera nyckellistan (som har <i>k</i> unika
element i sig) går på <i>O</i>(<i>k</i> log <i>k</i>) tid.

#### UPPDATERING - KOMPLETTERING
Vi vet att det totala antal olika tal i listan är k, det vill säga att nyckellistan (listan med alla unika tal) som genereras kommer ha k element i sig.

Från början var jag inte specifik med vilken algoritm som användes för att sortera listan, utan jag tänkte att det var underförstått att en algoritm med tidskomplexitet O(n log n) för en lista med längd n skulle användas. Jag förtydligade detta senare med att specificera algoritmen till Heapsort, en känd algoritm som har värstafallstidskomplexitet O(n log n) för en lista med längd n.

Att sedan kalla Heapsort på vår nyckellista (som har längd k, ty det finns k unika tal i originallistan) kommer göra att sorteringen går på O(k log k) tid.

Efter det så läggs nyckeln till ett bestämt antal gånger i
en separat array, detta går på <i>O</i>(1) tid per gång. Totalt kommer det vara <i>n</i> tilläggningar i output, vilket
resulterar i <i>O</i>(<i>n</i>) tid. Allt som allt har vi då <i>O</i>(<i>n</i> + <i>k</i> log <i>k</i>) tid.

### För vilka k blir algoritmen linjär?
Algoritmen kommer vara linjär då k relativt n är litet. Det vill säga, algoritmen kommer bara vara linjär så länge som
det finns många dubbletter i listan som ska sorteras. Om antalet unika element i listan närmar sig antalet totala
element (dvs nästan alla element i listan är unika), kommer tidskomplexiteten istället bli <i>O</i>(<i>n</i> + <i>n</i>
log <i>n</i>) = <i>O</i>(<i>n</i> * (1 + log <i>n</i>)) = <i>O</i>(<i>n</i> log <i>n</i>), det vill säga vi har landat
tillbaka på en mer traditionell jämförande sorteringsalgoritm som körs på <i>O</i>(<i>n</i> log <i>n</i>) tid.
