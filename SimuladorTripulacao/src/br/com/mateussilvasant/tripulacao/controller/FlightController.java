package br.com.mateussilvasant.tripulacao.controller;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.mateussilvasant.tripulacao.DatabaseTripulation;
import br.com.mateussilvasant.tripulacao.menu.FlightMenu;
import br.com.mateussilvasant.tripulacao.menu.MainMenu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class FlightController
{
    private FlightMenu flightMenu;
    public MainMenu mainMenu;

    public FlightController()
    {
	mainMenu = new MainMenu();
	mainMenu.buttonNewFlight.setOnMouseClicked(flightMenuAction());
	flightMenu = new FlightMenu(this);
    }

    public EventHandler<Event> flightMenuAction()
    {
	return new EventHandler<Event>()
	{

	    @Override
	    public void handle(Event event)
	    {
		flightMenu.show(mainMenu);
	    }

	};
    }

    public EventHandler<Event> startFlightAction()
    {
	return new EventHandler<Event>()
	{

	    @Override
	    public void handle(Event event)
	    {

	    }

	};
    }

    public HashMap<String, Integer> getTimesGate()
    {
	HashMap<String, Integer> mapTimesGate = new HashMap<>();
	mapTimesGate.put("01:00", 1);
	mapTimesGate.put("05:00", 5);
	mapTimesGate.put("10:00", 10);
	mapTimesGate.put("30:00", 30);
	return mapTimesGate;
    }

    public ArrayList<String> getAirplanes()
    {
	return DatabaseTripulation.getAirplaneNames();
    }

}
