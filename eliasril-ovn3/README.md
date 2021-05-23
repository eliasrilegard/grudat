# Övning 3

## 3.1 Fakultet i repris

Vi bevisar att koden är korrekt med hjälp av stark induktion:

`factorial()` returnerar antingen 1 om input är 0, eller k * `factorial(k-1)` om k > 0, vilket är en egenskap hos fakultetsfunktionen. Således:

Induktionsbas: `factorial(0)` = 1

Induktionsantagande: Vi antar att `factorial(k)` = k! för alla k < n.

Induktionssteg: `factorial(n)` = n * `factorial(n-1)` = n * (n-1)! = n!

n kan nu väljas godtyckligt stort, och induktionsantagandet tillsammans med induktionssteget garanterar att koden
kommer returnera rätt värde. Vi har nu bevisat m.h.a stark induktion att funktionen och koden är korrekt.
