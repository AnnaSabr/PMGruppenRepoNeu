
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
Implementierung von mindestens zwei Monsterarten, deren individuelle Anzahl anhand
des aktuellen Levels variert und Klassenweise Faehigkeiten besitzen, die ebenso an das Level angepasst werden.

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
Orientieren konnte man sich an der MyHero Klasse, da es sich dort auch um eine Animierte Figur handelt.
Um sich doppelte Arbeiten zu ersparen sollte eine Factory-Method Pattern angewandt werde. So muss lediglich einmal eine Klasse implementiert werden,
die saemtliche Funktionen steuert, die jedes Monster unabhängig seiner Art gebraucht. Darunter fällt zum Beispiel die IDLEAnimation.
Die unterschiedlichen Texturen dafür werden dann in der entsprechenden Artenklassen geladen und einer Liste hinzugefügt.


# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->
Die Eigentlichen Monsterarten wie z.B. Skelet oder Necromancer erhalten jeweils eine eigen Klasse die von Monster extended
und so selbst nur individuelle Werte, wie zum Beispiel die unterschiedlichen Texturen ändern müssen. Des weiteren gibt es eine MonsterCreator Klasse in der eine statische Methode enthalten ist, die +in MyGame aufgerufen wird. sie dient als Schnittstelle zwischen MyGame und den ganzen Monsterklassen.
Zur Fehlervermeidung kann außerdem ein Enum hinzugezogen werden. Darin Dokumentiert man die vorhandenen Monsterarten und kann so sicherstellen, das beim jeweiligen Monster Objekt-Erstellen keine
nicht existenten Individuen erstellt werden sollen.



# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->
Wie bei der letzten Ausarbeitung auch schon, wäre zur allgemein 
besseren ausarbeitung ein geregeltes Zeitmanagement von vorteil. 
Kleine Fehler kosten so verhältnismäßig viel Zeit. Bis auf die 
Richtungsorientierte Animation Wechsel funktioniert, aber trotzdem 
alles aus der Aufgabe und konnte erfolgreich quasi nach vorher überlegter 
Strategy angewandt werden.
