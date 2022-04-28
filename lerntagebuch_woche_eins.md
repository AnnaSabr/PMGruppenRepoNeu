---
title: "Lerntagebuch zur Bearbeitung der Dungeon-Aufgaben "Dungeon", "Texturen" und Animationen"
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
Dungeon: Der Dungeon sollte lauffahig gemacht werden un der erste Held implementiert werden.
Texturen: Es sollten weitere Texturen in dem entsprechenden Ordner hinzugefuegt werden, fuer Items, Helden und Monster.
Animationen: Die Animation des Helden sollte je nach Laufrichtung individuell angepasst werden.
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

Dungeon: In der Theorie nur Repo clonen und in IDE oeffnen. Anschließend mit Gradle ausfuehren.
Texturen: Beliebige Texturen aus dem Internet klauen und in den richtigen Ordner packen.
Animationen: Die idleAnimation anpassen, je nach Laufrichtung ueber die permanent laufende update Funktion.


# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->

Dungeon: es gab zum Teil Probleme mit dem Import in die jeweilige IDE. 
Probleme durch falsche Javaversionen bei Gradle oder bei der IDE mussten behoben werden.
Texturen: Bilder wurden gedownloaded, mussten allerdings je nach vorgesehener Animation noch manuell gespiegelt werden.
Animation: Da sie update Funktion 30 mal die Sekunde ausgefuert wird, war es zu Beginn ein Problem,
dass die aktuell geforderte Animation nicht bei jedem neuen Aufruf von vorne beginnt.
So war sie naemlich nicht sichtbar. ein Problem was noch nicht behoben werden konnte ist,
dass die Animation bei Stillstand nicht zurueck in die IdleAnimation geschaltet wird. 

# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->

Insgesamt lief es relativ erfolgreich, die kleinen aufgetretenen Probleme konnten mit Hilfe schnell beseitigt werden.
Der Fehler, dass die Idle Animation noch nicht wieder abgespielt wird, wurde primaer aufgrund mangelnder Zeit nicht mehr behoben. In dem Fall wäre 
ein besseres Zeitmanagement und Absprachen von Vorteil.