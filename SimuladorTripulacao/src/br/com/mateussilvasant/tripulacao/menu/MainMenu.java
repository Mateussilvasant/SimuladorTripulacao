package br.com.mateussilvasant.tripulacao.menu;

import br.com.mateussilvasant.tripulacao.Simulador;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainMenu extends StackPane
{

    private StackPane topBar;
    private Button buttonNewFlight;
    private FlightMenu flightMenu;

    public MainMenu()
    {
	initBar();
    }

    private void initBar()
    {

	Rectangle rectangle = new Rectangle(Simulador.METRICS.getPX(Simulador.METRICS.getWidth()),
		Simulador.METRICS.getPX(0.02));
	rectangle.setFill(Color.BLACK);

	topBar = new StackPane();
	topBar.getChildren().add(rectangle);
	topBar.setTranslateY(Simulador.METRICS.getX(-0.14));

	buttonNewFlight = new Button("Novo Vôo");
	buttonNewFlight.setOnMouseClicked(new FlightMenuAction());

	topBar.getChildren().add(buttonNewFlight);

	super.getChildren().add(topBar);
    }

    public class FlightMenuAction implements EventHandler
    {

	public void handle(Event arg0)
	{
	    if (flightMenu == null)
	    {
		flightMenu = new FlightMenu();
	    }

	    flightMenu.show(MainMenu.this);
	}

    }

}
