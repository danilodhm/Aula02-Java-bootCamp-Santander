package services;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class NavegadorInternet extends Application {
    
    private static TabPane tabPane;
    private static volatile boolean started = false;

    @Override
    public void start(Stage primaryStage) {
        tabPane = new TabPane();
        addNewTab(Telefone.getGetVideoUrl());

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Navegador de Internet");
        primaryStage.setMaximized(true);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
        primaryStage.toFront();
        primaryStage.requestFocus();
        primaryStage.setAlwaysOnTop(false);
    }

    public static void addNewTab(String url) {
        if (tabPane == null) {
            Application.launch(NavegadorInternet.class);
            return;
        }
        Platform.runLater(() -> {
            WebView webView = new WebView();
            webView.getEngine().load(url);
            Tab tab = new Tab("Aba " + (tabPane.getTabs().size() + 1), webView);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab); 
        });
    }

    public static void atualizarAbaSelecionada(String url) {

        if(url == null || url.isEmpty()) {
            if (tabPane == null) return;
            Platform.runLater(() -> {
                Tab aba = tabPane.getSelectionModel().getSelectedItem();
                if (aba != null && aba.getContent() instanceof WebView webView) {
                    webView.getEngine().reload();
                }
            });
            return;
        }
        
        if (tabPane == null) return;
        Platform.runLater(() -> {
            Tab aba = tabPane.getSelectionModel().getSelectedItem();
            if (aba != null && aba.getContent() instanceof WebView webView) {
                webView.getEngine().load(url);
            }
        });
    }

    public static boolean isStarted() {
        return started;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
