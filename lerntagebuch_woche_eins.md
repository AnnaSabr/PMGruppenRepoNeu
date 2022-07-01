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
Sechs verschiedene Items, die der Held einsammeln und verwenden kann, sollen erzeugt und in der Dungeon verteilt werden.
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

Den Items soll eine zufällige Koordinate zugewiesen werden, damit sie an einem zufälligen Ort erstellt werden. Wenn sich der Held auf der gleichen Koordinate befindet, wie das Item, soll das 
Item eingesammelt werden. Das Item wird dann nicht mehr grafisch dargestellt. Der Held kann die Items abhängig von ihrem Nutzen verwenden. Die Items sollen in drei Arten 
unterteilt werden. Das heißt, dass eine Oberklasse Items durch 3 Klassen (z.B. Tränke, Rüstungen und Waffen) erweitert wird. Diese Klassen werden durch die konkreten Items erweitert.


# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->

Eine neue Klasse für das neue Item wurde angelegt. In dieser wurden Position und Textur des Items festgelegt. Die Position des Items kann noch nicht
zufällig gewählt werden. Wenn der Held und das Item sich auf einer ähnlichen Koordinate befinden, wird das Item mit "removable" entfernt. Das Item wird dargestellt, kann aber noch nicht benutzt werden.

# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->

Während der Implementierung traten viele Fehler auf, die die Arbeit verzögerten. In Zukunft sollte mehr Zeit für die Programmierung eingeplant werden. Wegen Zeitmangel
konnte die Aufgabe nicht fertiggestellt werden.