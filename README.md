FootballSimulator:
========================

This is a project which is some kind of a 'training ground' for technologies.

Local address
------------------------
http://localhost:8080/FootballSimulator

Database console and db address
------------------------
- http://localhost:8080/h2console
- jdbc:h2:mem:FootballSimulator
 
Important info
------------------------

- Under "WEB-INF" folder it is a file named "jboss-deployment-structure.xml"
Without this file you will see only INFO levels (log4j) on the console.
JBoss 7.1.1 requires this file with excluded log4j and slf4j (if used) for log4j/slf4j to work properly

- f:ajax render=":teamsSelectionForm:display"
	- 'render' works properly if not used in composite components. Does not work however if used inside a component, use render="display" instead.
