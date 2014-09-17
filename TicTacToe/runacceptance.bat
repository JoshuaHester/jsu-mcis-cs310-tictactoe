cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywordsGUI.java
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.8.5.jar org.robotframework.RobotFramework TicTacToeTestsGUI.txt
cd ..