package br.com.mateussilvasant.tripulacao;

import br.com.mateussilvasant.tripulacao.menu.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Simulador extends Application
{

    private Scene scene;
    private StackPane root;
    public static Metrics METRICS;

    public void start(Stage stage) throws Exception
    {

	METRICS = new Metrics(Screen.getPrimary().getVisualBounds().getWidth(),
		Screen.getPrimary().getVisualBounds().getHeight());

	root = new StackPane();
	root.getChildren().add(new MainMenu());

	scene = new Scene(root, METRICS.getPX(0.40), METRICS.getPX(0.20));

	// stage.setAlwaysOnTop(true);
	// stage.initStyle(StageStyle.UTILITY);
	stage.setScene(scene);
	stage.setTitle("Simulador Tripulação");
	stage.show();
    }

    public static void main(String[] args)
    {
	launch(args);
    }

}
