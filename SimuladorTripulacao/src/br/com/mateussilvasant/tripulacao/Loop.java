package br.com.mateussilvasant.tripulacao;

import javafx.animation.AnimationTimer;

public class Loop extends AnimationTimer
{
    public TripulationManager manager;

    public Loop(TripulationManager tripulationManager)
    {
	manager = tripulationManager;
    }

    public void play()
    {
	start();
    }

    public void handle(long now)
    {
	manager.update();
    }

}