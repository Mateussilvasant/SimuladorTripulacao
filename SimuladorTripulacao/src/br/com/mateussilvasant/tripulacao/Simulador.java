package br.com.mateussilvasant.tripulacao;

import br.com.mateussilvasant.tripulacao.components.Metrics;
import br.com.mateussilvasant.tripulacao.controller.FlightController;
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

	FlightController controller = new FlightController();
	root.getChildren().add(controller.mainMenu);

	scene = new Scene(root, METRICS.getPX(0.47), METRICS.getPX(0.25));
	scene.getStylesheets()
		.add(getClass().getResource("/br/com/mateussilvasant/tripulacao/style/styleApp.css").toExternalForm());

	stage.setAlwaysOnTop(true);
	stage.setScene(scene);
	stage.initStyle(StageStyle.UTILITY);
	stage.setResizable(false);
	stage.setTitle("Simulador Tripulação");
	stage.show();
    }

    public static void main(String[] args)
    {
	launch(args);
    }

}
