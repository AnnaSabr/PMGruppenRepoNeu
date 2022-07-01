
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
Shop: Items sollen gekauft und verkauft werden können. Das Verhandeln erfolgt über RegEx. Items gibt es nur begrenzt. Die Preise für das Kaufen sind größer als die 
Preise für das Verkaufen. Der Shop muss graphisch dargestellt werden.

Game over: Beim Spielertot sollte Game Over ausgegeben werden und die Möglichkeit bestehen ueber eine Taste das Spiel neu zu starten.
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
Shop: Die Interaktion mit dem Shop soll über das Dialogsystem erfolgen. Für die Darstellung können die Texturen der Slots aus dem InventarUI verwendet werden. Die Items im Shop werden über HUDElemente dargestellt. In der Konsole kann der Spieler Eingaben machen. Das Dialogsystem muss erweitert werden, damit auch gehandelt werden kann. Wenn über Regex ein Preis verhandelt wurde, muss geprüft werden, ob die Transaktion möglich ist, d.h. ob der Held genug Geld und Platz im Inventar hat.
GAme Over: Da der Grossteil der benoetigten Funktionen, wie zb die removable schon fuer den Hero vorhanden war
kann man darauf aufbauen.

# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->
Shop: Der Shop wird dargestellt, wenn der Spieler ihn ausgewählt hat. Die Texturen werden aus der Klasse Slots übernommen. Der Shop kann höchstens 9 Items anbieten. Das
Dialogsystem ist in der Klasse NPCs implementiert. Die Klasse Shop konnte nicht von NPCs erben, weil sie bereits von Entity bzw. HUDElement erbt. Die Klasse musste einige modifizierte Methoden aus de NPC Klasse übernehmen, weil das Dialogsystem nicht immer der Funktionsweise des Shops kompatibel ist. Für den Shop mussten weitere Methoden zum Verhandeln implementiert werden.
Game Over: Es gab am Anfang ein kleines Problem mit dem Neustarten, da immer noch alte Werte, wie das vorhandene Geld uebernommen wurden.
# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->
GAme Over: Die kleinen Probleme vom Anfang ließen sich schnell beheben und insgesamt war die Aufgabe relativ einfach.
Shop: Das Dialogsystem der NPCs konnte ohne Probleme auf den Shop angewendet werden. Die Funktionen konnten gut angepasst werden um das Handeln zu ermöglichen. Ein Problem trat auf, wenn der Spieler ein Item verkauft, weil das Item aus dem Inventar entfernt werden musste. Dieses Problem konnte über die Methoden des Inventars gelöst werden. Das Vorgehen war insgesamt erfolgreich und die Fehler konnten schnell behoben werden.