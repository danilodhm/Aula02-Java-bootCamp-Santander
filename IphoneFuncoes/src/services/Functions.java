package services;

public class Functions {

    public static void ExeCmd(){
        try {
            String javac = "javac --module-path ./lib/javafx-sdk-21.0.7/lib --add-modules javafx.controls,javafx.web -d out ./src/interfaces/*.java ./src/services/*.java ./src/services/NavegadorInternet.java";
            String java = "java --module-path ./lib/javafx-sdk-21.0.7/lib --add-modules javafx.controls,javafx.web -cp out services.NavegadorInternet";

            
            ProcessBuilder pbCompile = new ProcessBuilder("cmd", "/c", javac);
            pbCompile.inheritIO();
            Process p1 = pbCompile.start();
            p1.waitFor();

            ProcessBuilder pbRun = new ProcessBuilder("cmd", "/c", java);
            pbRun.inheritIO();
            Process p2 = pbRun.start();
            p2.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
