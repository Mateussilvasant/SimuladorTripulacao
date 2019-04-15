package br.com.mateussilvasant.tripulacao.menu;

import java.util.ArrayList;
import java.util.Iterator;

import br.com.mateussilvasant.tripulacao.DatabaseTripulation;
import br.com.mateussilvasant.tripulacao.Simulador;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class FlightMenu extends StackPane
{

    private HBox infoFlightPane;
    private ComboBox<String> departureField;
    private Label departureLabel;
    private Label arrivalLabel;
    private ComboBox<String> arrivalField;

    public FlightMenu()
    {
	ArrayList<String> icaos = DatabaseTripulation.getListAirportNames();

	Group group = new Group();

	infoFlightPane = new HBox(2);
	departureLabel = new Label("Origem: ");

	departureField = new ComboBox<String>();

	departureField.getItems().addAll(icaos);
	departureField.setOnKeyPressed(new DepartureEventSearch(icaos));
	departureField.requestFocus();
	departureField.setEditable(true);
	departureField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	arrivalLabel = new Label("Destino: ");

	arrivalField = new ComboBox<String>();
	arrivalField.getItems().addAll(DatabaseTripulation.getListAirportNames());
	arrivalField.valueProperty().addListener(new ArrivalEventSearch());
	arrivalField.setEditable(true);
	arrivalField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	infoFlightPane.getChildren().add(departureLabel);
	infoFlightPane.getChildren().add(departureField);
	infoFlightPane.getChildren().add(arrivalLabel);
	infoFlightPane.getChildren().add(arrivalField);

	infoFlightPane.setSpacing(Simulador.METRICS.getPX(0.005));

	double pd = Simulador.METRICS.getPX(0.40);

	infoFlightPane.setPadding(new Insets(pd, pd, pd, pd));

	infoFlightPane.setStyle("-fx-border-color: black");

	group.getChildren().add(infoFlightPane);
	getChildren().add(group);
    }

    public void show(StackPane paneRoot)
    {
	if (!paneRoot.getChildren().contains(this))
	{
	    paneRoot.getChildren().add(this);
	}
    }

    private class DepartureEventSearch implements EventHandler<KeyEvent>
    {

	private ArrayList<String> list;
	private ArrayList<String> filteredList;

	public DepartureEventSearch(ArrayList<String> observableList)
	{
	    list = observableList;
	    filteredList = new ArrayList<String>();
	}

	public void handle(KeyEvent event)
	{

	    String text = event.getCode().toString();

	    Iterator<String> iterator = list.iterator();

	    while (iterator.hasNext())
	    {
		String key = iterator.next();

		if (key.contains(text))
		{
		    filteredList.add(key);
		}

	    }

	    System.out.println("qTD: " + filteredList.size());

	    departureField.getItems().addAll(filteredList);

	}

    }

    private class ArrivalEventSearch implements ChangeListener<Object>
    {

	public void changed(ObservableValue<?> observable, Object oldValue, Object newValue)
	{

	}

    }

}
