It is very important to separate dbunit's test code from arquillian' test code !!!

- if you put a test class "ConstructingLeaguesViaRealEntityManager" under the same package then you will see that Arquillian will try to invoke this test as well

- this causes problems like "ClassNotFoundException" (regarding for example FootballBase) because we have not defined this class as ".addPackage(FootballBase.class.getPackage())" dependency.
We have not done it this way because we do not want to run dbunit tests while running Arquillian test.

This is why I decided to put the code into separate packages. Now it works :) 