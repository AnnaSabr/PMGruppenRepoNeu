
---
title: "Lerntagebuch zur Bearbeitung der Dungeon-Aufgaben "Dialogsystem" und "Shop"
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
Dialogsystem: Es sollte ein Dialogsystem entworfen werden, welches mit Regulaeren Ausdruecken arbeitet.  
Der Spieler soll in der Lage sein Texte einzugeben. Diese sollen auf Regeulaere Ausdruecke geprueft werden und dann je nach Art, auf sie reagiert werden.
Zusaetzlich sollte ein Raetsel im Spiel implementiert werden.

Shop: Items sollen gekauft und verkauft werden können. Das Verhandeln wird über RegEx gelöst. Items gibt es nur begrenzt. Die Preise für das Kaufen sind größer als die 
Preise für das Verkaufen. Der Shop muss graphisch dargestellt werden.
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
DA bereits NPCs im Spiel vorhanden sind, koennten man sie um eine Dialog Funktion erweitern. 
Damit das nicht mit den bisherigen Funktionen der NPCs kollidiert wird dies nur mit einm bestimmten Tastenaufruf ausgefuehrt.
Da die individuellen NPCs von NPC erben, kann ein Grossteil in der Oberklasse implementiert werden und nur 
die individuellen Antworten in den einzelnen NPCS.

Shop: Die Interaktion mit dem Shop soll über das Dialogsystem erfolgen. Für die Darstellung können die Texturen der Slots aus dem InventarUI verwendet werden. Die Items im Shop werden über HUDElemente dargestellt.
# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->
Dialogsystem: Die Umsetzung gestaltete sich im Bezug auf die Logik relativ einfach. Wie immer waren die Regulaeren Ausdruecke
und ihre Feinheiten, dass einzige was zickig war und etwas rumprobieren erforderte.

Shop: Der Shop wird dargestellt, wenn der Spieler ihn ausgewählt hat. Die Texturen werden aus der Klasse Slots übernommen. Der Shop kann höchstens 9 Items anbieten. Das
Dialogsystem ist in der Klasse NPCs implementiert. Die Klasse Shop konnte nicht von NPCs erben, weil sie bereits von Entity bzw. HUDElement erbt. Die Klasse musste einige modifizierte Methoden aus de NPC Klasse übernehmen, weil das Dialogsystem nicht immer der Funktionsweise des Shops kompatibel ist.
# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->
Dialogsystem: Auch wenn die Aufgabe 5 Punkte gibt, war sie relativ einfach und in verhaeltnissmaessig geringer Zeit zu loesen. 

Shop: Die Visualisierung des Shops und das Geld konnten ohne Probleme implementiert werden. Die Anwendung des Dialogsystems auf den Shop ist nur begrenzt möglich, weil über den Shop verhandelt werden soll, was im Dialog mit den NPCs nicht notwendig ist. Diese Probleme hätten durch eine andere Arbeitsteilung, bei der eine Person für den Shop und das Dialogsystem verantwortlich ist, oder die Implementierung mehrerer Dialogsysteme vermieden werden können.
Ein Problem, das nicht gelöst werden konnte, tritt auf, wenn mit dem Shop interagiert werden soll. Der Shop wird dann nicht mehr visualisiert.