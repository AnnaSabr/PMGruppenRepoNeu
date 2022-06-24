
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
Tasche: In Taschen sollen weitere Gegenstände eines bestimmten Typs aufbewahrt werden können.

Schatzkiste: Schatzkisten werden zufällig im Dungeon verteilt. Die darin befindlichen Items kann der Spieler sammeln, nachdem er die Kiste geöffnet hat.
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
Tasche: Taschen sollen nur Gegenstände eines Typs(z.B. Waffe) aufnehmen. Die Taschen erhalten eine Liste mit einem generischen Typ, damit verschiedene Taschen
verschiedene Arten von Items aufnehmen können. Die Taschen selbst müssen die Klasse Items erweitern, damit sie in das Inventar aufgenommen werden können. 
Das textbasierte Inventar muss bearbeitet werden, damit auch auf Inhalte der Taschen zugegriffen werden kann.

Schatzkiste: Schatzkisten brauchen eine Inventar-Variable, um Items in der Schatzkiste zu speichern. Die Kiste soll nur geöffnet werden können, wenn der Spieler einen 
Schlüssel ausgerüstet hat. Die Textur sollte nach dem Öffnen der Kiste geändert werden, um einen Unterschied zwischen geöffneten und geschlossenen Kisten zu 
verdeutlichen.


# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->
Taschen: Die Klasse nutzt eine ArrayList des generischen Typs der Klasse. In dieser ArrayList werden die gesammelten Items gespeichert. Durch eine Methode in der
Inventar-Klasse werden neue Items zuerst in den Taschen gespeichert. Erst wenn diese voll sind, werden die Items wieder im Inventar gespeichert.

Schatzkiste: Schatzkisten haben eine Instanzvariable vom Typ Inventar, um zwei bis drei zufällig gewählte Items in der Kiste zu speichern. Die Kisten können nur
geöffnet werden, wenn der Spieler vorher einen Schlüssel eingesammelt hat. Nachdem die Kiste geöffnet wurde, kann der Spieler die Items einsammeln. Des Weiteren haben
die Kisten eine Boolean-Variable, in der gespeichert wird, ob sie geöffnet sind. Sobald die öffnen-Methode der Kiste aufgerufen wurde, wird die Darstellung der Kiste 
geändert.

# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->
Taschen: Der Lösungsansatz war richtig, während der Programmierung gab es jedoch kleinere Probleme mit den generischen Typen. Es wäre zielführender gewesen die 
Inhalte der Generics vorher zu wiederholen.

Schatzkiste: Zuerst sollten neue Items über den Konstruktor in der Kiste gespeichert werden. Dabei traten Probleme mit dem Inventar auf, welches nach der Änderung zu 
Beginn der Spiels nicht mehr leer war. Das Problem konnte gelöst werden, indem die Items erst später in der Kiste gespeichert wurden. Insgesamt gab es nur wenig
Schwierigkeiten und die Vorgehensweise war angemessen.