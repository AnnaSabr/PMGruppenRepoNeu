
---
title: "Lerntagebuch zur Bearbeitung der Dungeon-Aufgaben "textbasiertes Inventar" und "Items"
author:
-   "Anna Heim (anna_sabrina.heim@fh-bielefeld.de)"
-   "Leonie Terlutter (leonie.terlutter@fh-bielefeld.de)"
-   "Waldemar Schäfer (waldemar.schaefer@fh-bielefeld.de)"
    hidden: true
---

<!--
Führen Sie zu jeder Woche zur Bearbeitung der Dungeon-Aufhaben ein
Lerntagebuch in Ihrem Team. Kopieren Sie dazu diese Vorlage und füllen
Sie den Kopf entsprechend aus.

Im Lerntagebuch sollen Sie Ihr Vorgehen bei der Bearbeitung der jeweiligen
Dungeon-Aufgaben vom ersten Schritt bis zur Abgabe der Lösung dokumentieren,
d.h. wie sind Sie die gestellte Aufgabe angegangen (und warum), was war
Ihr Plan und auf welche Probleme sind Sie bei der Umsetzung gestoßen und
wie haben Sie diese Probleme gelöst. Beachten Sie die vorgegebene Struktur.

Für jede Abgabe sollte ungefähr eine DIN-A4-Seite Text erstellt werden,
d.h. ca. 400 Wörter umfassen. Wer das Lerntagebuch nur ungenügend führt
oder es gar nicht mit abgibt, bekommt für die betreffende Abgabe 0 Punkte.

Checken Sie das Lerntagebuch mit in Ihr Projekt/Git-Repo ein.

Schreiben Sie den Text mit [Markdown](https://pandoc.org/MANUAL.html#pandocs-markdown).
Tipp: VSCode bringt einen vergleichsweise guten Markdown-Support (inkl. Preview)
bereits in der Grundinstallation mit.

Geben Sie das Lerntagebuch stets mit ab. Achtung: Wenn Sie Abbildungen
einbetten (etwa UML-Diagramme), denken Sie daran, diese auch abzugeben!
-->


# Aufgabe
Items: sollen vom Spieler gesammelt und verwendet werden können. Gesammelte Items werden in einem Inventar gespeichert. Items können aus dem Inventar entfernt 
oder aufgenommen werden.

Fallen: Fallen sollen sowohl von Monstern als auch dem Spieler ausgelöst werden und unterschiedliche Effekte auslösen.

Da die Fähigkeiten bereits implementiert wurden musste nun zusätzlich der Nahkampf hinzugefügt um den Hitt-Skill anzuwenden. Auch wurde das HUD soweit implementiert, sodass drei verschiden Fähigkeiten angezeit werden können.
<!--
Bitte hier die zu lösende Aufgabe kurz in eigenen Worten beschreiben.
-->



# Ansatz und Modellierung

<!--
Bitte hier den Lösungsansatz kurz beschreiben:
-   Wie sollte die Aufgabe gelöst werden?
-   Welche Techniken wollten Sie einsetzen?
-   Wie sah Ihre Modellierung aus (UML-Diagramm)?
-   Worauf müssen Sie konkret achten?
-->
Alle Item-Klassen sind Unterklassen der Klasse "Items". Dadurch können alle Items in einer ArrayList, die als Inventar dient, gespeichert werden.
Dadurch, dass alle Tränke von der Klasse "Potion" erben, können alle ausgerüsteten Tränke die Methode "usePotion" nutzen.
Das Inventar verwendet die Konsole. Falsche Benutzereingaben müssen abgefangen werden, damit das Programm nicht abstürzt.

Die Fallen können ähnlich wie die Monster über ein FactoryPattern implemtiert werden, sodass jederzeit mit wenig aufwand neue Fallen Arten mit unterschiedlichen Effekten ergänzt werden können.

Bei einem Treffer soll das Ziel wenn möglich zurückgestoßen werden. Dabei wurde der Verktor zwischen den Objekten berechnen um die Richtung des Stoßes darzustellen. Ein Interface welches die Monster implementieren gibt an ob diese von einem Nahkampangriff getroffen werden können und dabei Lebenspunkte verlieren.
# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->
Zuerst wurde die Superklasse "Items" mit einer Unterklasse erstellt. Die Unterklasse "Potion" hat weitere Unterklassen um die eigentlichen Trank-Objekte zu erzeugen.
Diese Objekte konnten am 02.05. zufällig im Dungeon verteilt werden. Die Objekte können vom Spieler mit einer Taste eingesammelt werden. In jedem Level wird ein neues, zufälliges Objekt platziert. Am 03.05. wurde eine weitere Unterklasse von "Items" erstellt, in deren Unterklassen Waffen implementiert wurden. Da die Funktion der Waffen von dem Kampfsystem abhängig ist, konnte diese noch nicht implementiert werden. Am 04.05. und 05.05. wurde das Inventar implementiert. Das Inventar ist eine ArrayList vom Typ Items, in der gesammelte Items gespeichert werden. Das Inventar kann über Eingaben in der Konsole gesteuert werden. Um Tränke zu benutzen, müssen die Tränke zuerst ausgerüstet werden. 

Wie geplant konnten die Fallen nach dem FactoryPattern implementiert werden. Zu Problemen kam es erst beim Mergen mit der ItemAufgabe, da die Positions-Variable dort static war. Nach einigen Abänderungen und Entfernung doppelter Eigenschaften, konnten die Konflikte behoben werden.

Die Interfaces , welche bereits mit der Implementierung der Fähigkeiten vorhanden waren mussten nochmals überarbeitet werden. Das Interface welches den Benutzer einer Fähigkeit angibt ist soweit geschrumpf, dass es im nächsten refactoring entfernt werden kann. Die Zusammenführung der Monster und des Helden in eine Oberklasse wird eine weitere überarbeitung der Fähigkeiten erfordern. Es soll das Strategy pattern erhalten bleiben und auf die einzelnen Gegenstände, weche der Held anlegen kann, übertragen werden. Das HUD soll die Benutzung der Tränke auf den 2 Slott anzeigen. Auf den 3 Slott weden die Magischen Fähigkeiten angezeigt.
# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->
Das Inventar konnte ohne Probleme implementiert werden. Das Inventar und die Tränke können benutzt werden. Items anderer Kategorien wie z.B. Waffen konnten zuerst nicht implementiert werden, weil die Waffen die Variablen des Kampfes (z.B. Schlagkraft) beeinflussen sollen und die Variablen und die Items nicht von der gleichen Person programmiert wurden. Eine weitere Item-Kategorie hätte implementiert werden sollen, da diese aber noch keine Funktion gehabt hätte, muss sie später hinzugefügt werden. Genauere Absprachen mit dem Team wären von Vorteil gewesen, damit beispielsweise Waffen so implementiert werden können, dass sie das Kampfsystem ergänzen. Dieses Problem konnte durch eine genauere Absprache im Team gelöst werden.

Die Fallen funktionieren sowohl bei Monstern auch als beim Helden selber. Bei Items ist bisher keine Funktion vorgesehen. Dafür gibt es bereits zwei Arten von Fallen die jeweils unterschiedliche Auswirkungen auf das Spiel haben.

Das Zusammenführen der verschiedenen Implementierungen hat viel Zeit in Anspruch genummen. Da die gesammte Logit in einer Klasse gebündelt wurde war es sehr aufwendig die einzelnen teilaufgaben voneinander zu trennen. Die Implementierung der Controller für die Teilbereiche wurde angestoßen.