---
title: "Lerntagebuch zur Bearbeitung der Dungeon-Aufgaben "Items"
author:
-   "Leonie Terlutter (leonie.terlutter@fh-bielefeld.de)"
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
Gruppe B: Monster und Kampf Schlaue Monster
Ziel war es unterschiedliche Bewegungsmuster fuer die Monster zu erstellen.

Crafting: Über das Inventar soll mit einem Rezept und den darin beschriebenen Zutaten ein neues Item erzeugt werden.

Die Fähigkeiten Aufgabe muss überarbeitet werden da der Held nun verschiedenene Gegenstände tragen kann und diese dann die Fähigkeiten implementieren sollen.
Die HUD muss auch soweit verändert werden dass die verschiedenen Fähigkeiten angezeigt werden.
Das Inventar soll übetarbeitet weden und eine Grafische Oberfläche implementieren.


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

Zur Umsetzung der Bewegungen eignet sich besonders gut das StrategyPattern. Dabei wird eine 
Vererbungshirachie genutzt, bei der exakt eine Methode weiter gegeben wird. Da es in diesem Fall expliziet 
nur um die Bewegung der Monster und sonst keinerlei Attribute doer Faehigkeiten ging, konnte so 
der Aufgabe effizient gestaltet werden.


Crafting: Die Rezepte müssen Items erweitern, damit sie in das Inventar aufgenommen werden können. Die Items, die als Zutat dienen, haben keine weitere Funktionalität. Der Spieler muss über das Inventar die Items selbst auswählen. Dies ist bisher nur über die Konsole möglich. Damit der Spieler den Inhalt des Rezepts lesen kann, muss
eine Methode implementiert werden, die den Inhalt ausgibt und die der Spieler aufrufen kann.

Die Implementierung der Grafischen Oberfläche wird von libGDX mithilfe der Klasse DragAndDrop vorgegeben. Das Inventar muss soweit verändert werden dass die Elemente den Anforderungen entsprechen.

# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->

Wie vorab ausfuehrlich geplant, konnte das StrategyPattern angewendet werden. Je nach Bewegungsstrategie
musste zwar der ein oder andere Parameter angepasst werden. Dies stellte allerdings keine grosse Herausforderung da.


Crafting: Die Items ohne Funktionaliät mussten grafisch dargestellt und im Inventar sichtbar sein. Dafür mussten sie "Items" erweitern.
Dem Inventar musste eine neue Methode hinzugefügt werden, um das Crafting zu steuern. In dieser Methode wird der Spieler aufgefordert, über die Konsole Items auszuwählen, mit denen das Rezept durchgeführt werden kann. Ungültige Eingaben mussten abgefangen werden.

Die Klasse DragAndDropp setzt verschiedene Hilfklassen voraus welche für die Funktionalität benötigt werden. Diese Klassen mussten erweitert weden.

# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->

Bis auf den kleinen Fehler, dass die Monster noch an Waenden feststucken, laufen alle Bewegung einwandfrei und genau nach Plan.

Crafting: Einige Fehler hätten vermieden werden können, wenn der neue Code öfter getestet worden wäre. Ein Problem trat beispielsweise auf, weil einer Variable mehrmals
der falsche Typ zugewiesen wurde, was zu einem Absturz des Programms führte.
Zaubersprüche können durch das Crafting nicht erzeugt werden, weil es noch keine Items von diesem Typ im Spiel gibt. Dies hätte durch eine andere Einteilung der Arbeit
verhindert werden können.

Das Zusammenspiel der Einzelnen Klassen bezüglich des Inventars funktioniert noch nicht korrekt.
