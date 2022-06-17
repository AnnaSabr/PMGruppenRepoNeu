
---
title: "Lerntagebuch zur Bearbeitung der Dungeon-Aufgaben "Schatzkisten" und "Taschen"
author:
-   "Anna Heim (anna_sabrina.heim@fh-bielefeld.de)"
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
BossMonster: Ein Bossmonster erstellen, welches eigene Texturen, Animationen, Angriffsmuster, Bewegungsmuster und Angriffe in Abhaengigkeit von seinem Leben hat.

Inventar UI: Eine grafische Darstellung des Inventars, die der Spieler mit der Maus bedienen kann.
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
BossMonster: Da es auch nur eine Art Monster ist, kann man das individuelle BossMonster von der Monster Klasse extenden und dann die besonderen Funktionen ueberschreiben.

Inventar UI: Das Inventar soll als HUD Element dargestellt werden. Es soll eingeblendet und entfernt werden können, deswegen muss über eine boolean Variable festgelegt werden, ob das Inventar angezeigt wird oder nicht.

# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->
BossMonster: Hat genauso geklappt wie vorher vermutet. 

Inventar UI: Das Inventar ist ein HUD Element. Es wird an einer festen Position angezeigt. Um ein Item auszurüsten, muss es mit der Maus ausgewählt werden. Das ausgewählte Item wird in einer Variable in Inventar gespeichert. Das Item wird dann ausgerüstet, wenn der Slot für die Hand ausgewählt wird. Wenn der ausgewählte Slot erneut ausgewählt wird und sich darin ein Trank befindet, wird dieser verwendet.
# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->
BossMonster: War umsetzbar.

Inventar UI: Die Items konnten nicht über das Inventar dargestellt werden, weil der HUD Controller die Items vom Typ Entity nicht verwalten kann. Für das Inventar mussten neue grafische Darstellungen erstellt werden. Diese neuen Bilder waren wegen eines Problems mit dem Bildbearbeitungsprogramm zuerst zu groß für das Inventar.