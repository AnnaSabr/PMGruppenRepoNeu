
---
title: "Lerntagebuch zur Bearbeitung der Dungeon-Aufgaben "Schatzkisten" und "Taschen"
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
<!--
Bitte hier die zu lösende Aufgabe kurz in eigenen Worten beschreiben.
-->
Crafting: Über das Inventar soll mit einem Rezept und den darin beschriebenen Zutaten ein neues Item erzeugt werden.



# Ansatz und Modellierung

<!--
Bitte hier den Lösungsansatz kurz beschreiben:
-   Wie sollte die Aufgabe gelöst werden?
-   Welche Techniken wollten Sie einsetzen?
-   Wie sah Ihre Modellierung aus (UML-Diagramm)?
-   Worauf müssen Sie konkret achten?
-->
Crafting: Die Rezepte müssen Items erweitern, damit sie in das Inventar aufgenommen werden können. Die Items, die als Zutat dienen, haben keine weitere Funktionalität. Der Spieler muss über das Inventar die Items selbst auswählen. Dies ist bisher nur über die Konsole möglich. Damit der Spieler den Inhalt des Rezepts lesen kann, muss
eine Methode implementiert werden, die den Inhalt ausgibt und die der Spieler aufrufen kann.


# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->
Crafting: Die Items ohne Funktionaliät mussten grafisch dargestellt und im Inventar sichtbar sein. Dafür mussten sie "Items" erweitern. 
Dem Inventar musste eine neue Methode hinzugefügt werden, um das Crafting zu steuern. In dieser Methode wird der Spieler aufgefordert, über die Konsole Items auszuwählen, mit denen das Rezept durchgeführt werden kann. Ungültige Eingaben mussten abgefangen werden. 

# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->
Crafting: Einige Fehler hätten vermieden werden können, wenn der neue Code öfter getestet worden wäre. Ein Problem trat beispielsweise auf, weil einer Variable mehrmals 
der falsche Typ zugewiesen wurde, was zu einem Absturz des Programms führte. 
Zaubersprüche können durch das Crafting nicht erzeugt werden, weil es noch keine Items von diesem Typ im Spiel gibt. Dies hätte durch eine andere Einteilung der Arbeit 
verhindert werden können.