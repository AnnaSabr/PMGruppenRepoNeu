---
title: "Lerntagebuch zur Bearbeitung der Dungeon-Aufgaben "Basics: Fächigkeiten"
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
Um das Spiel spannender gestalten zu können soll ein System einwickelt werden, mit dem verschiedenen Objekte miteinander interagieren können. Ein Held soll zum Beispiel verschiedene Fähigkeiten besitzen können mit denen er die Monster bekämpfen kann. 

# Ansatz und Modellierung

<!--
Bitte hier den Lösungsansatz kurz beschreiben:
-   Wie sollte die Aufgabe gelöst werden?
-   Welche Techniken wollten Sie einsetzen?
-   Wie sah Ihre Modellierung aus (UML-Diagramm)?
-   Worauf müssen Sie konkret achten?
-->
Um komplexe Vererbungsstrukturen zu vermeiden soll das Strategy-Pattern benutzt werden. Dabei wird das Verhalten einer Fähigkeit in eine passende Klasse ausgelagert. Jede Fähigkeiten Klasse implementiert die Schnittstelle ISkill und besitzt somit die Methoden display, unlock, use und update. Objekte, welche Fähigkeiten benutzen sollen, müssen die Schnittstelle ISkillUser implementieren und verfügen so über die Methoden equipSkill und useSkill.
Jede Fähigkeit soll eine gewisse zeit benötigen, biss sie wieder benutzt werden kann. Die CoolDown Zeit ist für alle Fähigkeiten des selben Typs gleich.
Fähigkeiten, welche Ressourcen benötigen, müssen diese im Kontruktor übergeben bekommen. Bei jedem Gebrauch werden dann die Ressourcen aufgebraucht. Für die DrinkSkill Klasse sollen dafür Flaschen Objekte im Spiel implementiert werden, welche dann vom Helden aufgebraucht werden sollen. Die Flaschen Objekten müssten das ISkillResource Interface implementieren und würde über die Methode getResource verfügen.


# Umsetzung

<!--
Bitte hier die Umsetzung der Lösung kurz beschreiben:
-   Was haben Sie gemacht,
-   an welchem Datum haben sie es gemacht,
-   wie lange hat es gedauert,
-   was war das Ergebnis?
-->
 Da die Implementierung der Fähigkeiten noch vor allen anderen Objekten erfolgte, konnte das Zusammenwirken der Komponenten noch nicht getestet werden. Es ist auch nicht ausgeschlossen, dass sich einige Methoden im weiteren Verlauf  noch ändern werden.

# Postmortem

<!--
Bitte blicken Sie auf die Aufgabe, Ihren Lösungsansatz und die Umsetzung
kritisch zurück:
-   Was hat funktioniert, was nicht? Würden Sie noch einmal so vorgehen?
-   Welche Probleme sind bei der Umsetzung Ihres Lösungsansatzes aufgetreten?
-   Wie haben Sie die Probleme letztlich gelöst?
-->
