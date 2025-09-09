@echo off
javac --module-path ../lib/javafx-sdk-21.0.7/lib --add-modules javafx.controls,javafx.web -d out YoutubeApp.java
java --module-path ../lib/javafx-sdk-21.0.7/lib --add-modules javafx.controls,javafx.web -cp out YoutubeApp
