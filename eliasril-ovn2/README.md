# Övning 2

## 2.1 Ordo-notation

### Del 1

De givna funktionerna är:

<ul>
<li><i>f<sub>1</sub>(n)</i>&nbsp;=&nbsp;<i>n</i><sup>1.5</sup>
</li>
<li><i>f<sub>2</sub>(n)</i>&nbsp;=&nbsp;10<sup><i>n</i></sup>
</li>
<li><i>f<sub>3</sub>(n)</i>&nbsp;=&nbsp;<i>n</i>&nbsp;log&nbsp;<i>n</i>
</li>
<li><i>f<sub>4</sub>(n)</i>&nbsp;=&nbsp;<i>n</i>&nbsp;+&nbsp;100
</li>
<li><i>f<sub>5</sub>(n)</i>&nbsp;=&nbsp;2<sup><i>n</i></sup>
</li>
</ul>

Vi ser direkt att 2<sup><i>n</i></sup> ∈ <i>O</i>(10<sup><i>n</i></sup>) vilket implicerar att <i>f<sub>5</sub>(n)</i> ska listas innan
<i>f<sub>2</sub>(n)</i>.

Det gäller generellt för större n att log<i><sub>a</sub></i>&nbsp;<i>n</i> < <i>n<sup>a</sup></i> < <i>a<sup>n</sup></i> < <i>n</i>!
< <i>n<sup>n</sup></i>, för något godtyckligt tal a. Detta talar om att <i>n</i><sup>1.5</sup> växer långsammare än 2<sup><i>n</i></sup>,
men snabbare än <i>n</i>&nbsp;+&nbsp;100. Det återstår bara att placera <i>n</i>&nbsp;log&nbsp;<i>n</i> på rätt plats relativt de andra.

För att bestämma rätt plats för <i>n</i>&nbsp;log&nbsp;<i>n</i> börjar vi med att konstatera att funktionen inte växer snabbare än
2<sup><i>n</i></sup>, men att den kanske växer ungefär i takt med <i>n</i><sup>1.5</sup>. Oavsett så växer den garanterat snabbare än
<i>n</i>&nbsp;+&nbsp;100. Vi kan använda gränsvärdet då n går mot ∞ för (<i>n</i>&nbsp;log&nbsp;<i>n</i>)&nbsp;/&nbsp;(<i>n</i><sup>1.5
</sup>) = (log&nbsp;<i>n</i>)&nbsp;/&nbsp;(sqrt&nbsp;<i>n</i>) vilket kan evalueras till 0. Detta säger att <i>n</i><sup>1.5</sup> växer
fortare än <i>n</i>&nbsp;log&nbsp;<i>n</i>, vilket är ekvivalent med <i>f<sub>3</sub>(n)</i> ∈ <i>O</i>(<i>f<sub>1</sub>(n)</i>).

Vi kan nu lista funktionerna i rätt ordning: &nbsp;<i>f<sub>4</sub>(n)</i>,&nbsp;<i>f<sub>3</sub>(n)</i>,&nbsp;<i>f<sub>1</sub>(n)</i>,&nbsp;<i>f<sub>5</sub>(n)</i>,&nbsp;<i>f<sub>2</sub>(n)</i>

### Del 2

Följande påståenden ska evalueras:
<ul>
<li><i>n</i>(<i>n</i>&nbsp;+&nbsp;1)&nbsp;/&nbsp;2 = <i>O</i>(<i>n</i><sup>3</sup>)</li>
<li><i>n</i>(<i>n</i>&nbsp;+&nbsp;1)&nbsp;/&nbsp;2 = <i>O</i>(<i>n</i><sup>2</sup>)</li>
<li><i>n</i>(<i>n</i>&nbsp;+&nbsp;1)&nbsp;/&nbsp;2 = &Theta;(<i>n</i><sup>3</sup>)</li>
<li><i>n</i>(<i>n</i>&nbsp;+&nbsp;1)&nbsp;/&nbsp;2 = &Omega;(<i>n</i>)</li>
</ul>

Låt oss gå igenom dessa påståenden ett i taget:

<i>n</i>(<i>n</i>&nbsp;+&nbsp;1)&nbsp;/&nbsp;2 = <i>O</i>(<i>n</i><sup>3</sup>)&nbsp; - Sant. Den ledande termen i det polynomet kan
skrivas som <i>n</i><sup>2</sup>&nbsp;/&nbsp;2, vilket växer långsammare eller lika snabbt som <i>n</i><sup>3</sup>.

<i>n</i>(<i>n</i>&nbsp;+&nbsp;1)&nbsp;/&nbsp;2 = <i>O</i>(<i>n</i><sup>2</sup>)&nbsp; - Sant. Samma argument som ovan, <i>n</i><sup>2</sup>
&nbsp;/&nbsp;2 växer långsammare eller lika snabbt som <i>n</i><sup>2</sup>.

<i>n</i>(<i>n</i>&nbsp;+&nbsp;1)&nbsp;/&nbsp;2 = &Theta;(<i>n</i><sup>3</sup>)&nbsp; - Falskt. Den ledande termen kan skrivas som
<i>n</i><sup>2</sup>&nbsp;/&nbsp;2, vilket inte växer lika fort som <i>n</i><sup>3</sup>.

<i>n</i>(<i>n</i>&nbsp;+&nbsp;1)&nbsp;/&nbsp;2 = &Omega;(<i>n</i>)&nbsp; - Sant. Samma ledande term igen, och
<i>n</i><sup>2</sup>&nbsp;/&nbsp;2 växer fortare än <i>n</i>.

Självklart går det att använda definitionen av O- och &Omega;-notation för att komma fram till dessa resultat, men dessa exempel är så pass simpla att det blir lättare att bara resonera sig fram till resultatet. I nästa sektion kommer definitionen användas dock användas.

## 2.2 Prefixsumma

<pre><code><b>for</b> i = 0 <b>to</b> n-1
    Add the numbers A[0] thru A[i].
    Store the result in B[i].
</code></pre>

Vi noterar här att för varje gång `i` ökas med ett steg måste hela listan A summeras igenom igen. Detta talar om att denna algoritms tidskomplexitet kan uttryckas som <i>n</i><sup>2</sup>&nbsp;/&nbsp;2 (ignorerar termer av lägre ordning), vilket vi även kan skriva som att algoritmen har tidskomplexiteten <i>O</i>(<i>n</i><sup>2</sup>). Detta kan vi motivera genom att med hjälp av definitionen välja konstanterna M&nbsp;=&nbsp;1&nbsp;/&nbsp;2 och n<sub>0</sub>&nbsp;=&nbsp;1. Med dessa värden håller egenskapen att <i>n</i><sup>2</sup>&nbsp;/&nbsp;2&nbsp;≤&nbsp;1&nbsp;/&nbsp;2&nbsp;*&nbsp;<i>n</i><sup>2</sup> för alla n&nbsp;≥&nbsp;1, vilket bekräftar det vi vill visa.

Ett väldigt liknande argument kan användas för att visa att <i>n</i><sup>2</sup>&nbsp;/&nbsp;2 ∈ &Omega;(<i>n</i><sup>2</sup>): Enligt definitionen av &Omega;-notation väljer vi konstanterna M&nbsp;=&nbsp;1&nbsp;/&nbsp;2 och n<sub>0</sub>&nbsp;=&nbsp;1. Då följer det att för n&nbsp;≥&nbsp;1 gäller det att <i>n</i><sup>2</sup>&nbsp;/&nbsp;2&nbsp;≥&nbsp;1&nbsp;/&nbsp;2&nbsp;*&nbsp;<i>n</i><sup>2</sup>, vilket bekräftar påståendet ovan.

### En bättre algoritm

Denna algoritm är mycket lik algoritmen ovan, men den har en stor skillnad:

<pre><code><b>let</b> sum = 0
<b>for</b> i = 0 <b>to</b> n-1
    sum += A[i]
    B[i] = sum
</code></pre>

Istället för att vid varje iteration beräkna summan av alla element i A fram till index `i`, så lagras summan kontinuerligt i en (temporär) variabel som uppdateras med värdet på A vid nuvarande index innan värdet lagras i B. På så sätt behöver vi bara komma åt varje element i A en enda gång, och likt innan kommer vi också åt varje element i B en enda gång. Räknar vi antalet elementäroperationer i denna algoritm inklusive att uppdatera index-variablen får vi en tidskomplexitet på 3<i>n</i>, vilket också kan skrivas som &Theta;(<i>n</i>).

## 2.4 En ovanlig funktion?

Låt <i>f</i>(<i>n</i>)&nbsp;=&nbsp;1 om n primtal, och <i>f</i>(<i>n</i>)&nbsp;=&nbsp;<i>n</i><sup>2</sup> om n ej är ett primtal. För denna funktion kan vi varken specificera konstanter för O-notation eller &Omega;-notation som alltid kommer gälla. <i>f</i> växer både fortare och långsammare än <i>g</i>(<i>n</i>)&nbsp;=&nbsp;n. Vi kan skissa en snabb idé för hur detta fungerar på följande sätt:

Betrakta mängden primtal. För denna mängd kommer <i>f</i>(<i>n</i>)&nbsp;=&nbsp;1, alltså kan vi välja konstanter som uppfyller kraven för O(<i>n</i>). Ta t.ex. <i>n</i><sub>0</sub>&nbsp;=&nbsp;1 och <i>M</i>&nbsp;=&nbsp;2. För alla <i>n</i> primtal håller dessa parametrar, men för <i>n</i> icke primtal fallerar det direkt, då <i>n</i><sup>2</sup> för stora tal växer mycket fortare än <i>n</i>. Motsvarande argument kan göras för &Omega;(<i>n</i>) för mängden <i>n</i> icke primtal. Men som innan fallerar det också för <i>n</i> primtal då 1 (betraktat som funktion) för stora tal <i>n</i> växer mycket långsammare än <i>n</i>. Notera nu att valet av parametrar (som exempel) här var helt godtyckligt, och att olikheten som skall uppfyllas kommer eventuellt brytas oavsett värden på parametrar. Vi kan alltså inte säga att <i>f</i> tillhör varken O(<i>n</i>) eller &Omega;(<i>n</i>).
