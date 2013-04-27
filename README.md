FootballSimulator:
========================

This is a project which is some kind of a 'training ground' for technologies.

1. http://localhost:8080/FootballSimulator

2. http://localhost:8080/h2console
 - jdbc:h2:mem:FootballSimulator

 3. Under "WEB-INF" folder it is a file named "jboss-deployment-structure.xml"
  - without this file you will see only INFO levels (log4j) on the console.
  JBoss 7.1.1 requires this file with excluded log4j and slf4j (if used) for log4j/slf4j to work properly