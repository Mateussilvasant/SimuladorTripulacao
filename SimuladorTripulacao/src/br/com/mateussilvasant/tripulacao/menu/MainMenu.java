package br.com.mateussilvasant.tripulacao.menu;

import br.com.mateussilvasant.tripulacao.Simulador;
import br.com.mateussilvasant.tripulacao.controller.FlightController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class MainMenu extends FlightPane
{

    private StackPane topBar;
    public Button buttonNewFlight;
    private Button buttonManagerAircraft;
    public static Font applicationFont;

    public MainMenu()
    {
	super(Simulador.METRICS.getWidth(), Simulador.METRICS.getHeight());
	initContent();
    }

    @Override
    public void settings()
    {
	applicationFont = new Font("sans-serif", 100);
	background.setFill(Color.rgb(45, 137, 239));
    }

    public void initContent()
    {
	initBar();
    }

    private void initBar()
    {

	Rectangle backgroundBar = new Rectangle(Simulador.METRICS.getPX(0.10), Simulador.METRICS.getHeight());
	backgroundBar.setFill(Color.rgb(29, 29, 29));

	VBox buttons = new VBox();
	buttons.setSpacing(Simulador.METRICS.getPX(0.0030));

	topBar = new StackPane();
	topBar.getChildren().add(backgroundBar);
	topBar.setTranslateX(Simulador.METRICS.getX(-0.286));

	buttonNewFlight = new Button("Novo Vôo");
	buttonNewFlight.setFont(Font.font(Simulador.METRICS.getPX(0.008)));
	buttonNewFlight.setPrefWidth(Simulador.METRICS.getPX(0.09));

	buttonManagerAircraft = new Button("Gerenciar Aeronaves");
	buttonManagerAircraft.setFont(Font.font(Simulador.METRICS.getPX(0.008)));
	buttonManagerAircraft.setPrefWidth(Simulador.METRICS.getPX(0.09));

	buttons.getChildren().add(buttonNewFlight);
	buttons.getChildren().add(buttonManagerAircraft);

	topBar.getChildren().add(new Group(buttons));

	getChildren().add(topBar);
    }

}
