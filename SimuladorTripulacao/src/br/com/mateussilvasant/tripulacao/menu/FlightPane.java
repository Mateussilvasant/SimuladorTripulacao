package br.com.mateussilvasant.tripulacao.menu;

import br.com.mateussilvasant.tripulacao.Simulador;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public abstract class FlightPane extends StackPane
{

    protected Rectangle background;

    public FlightPane(double width, double height)
    {
	initBackground(width, height);
	settings();
	initContent();
    }

    public abstract void settings();

    public abstract void initContent();

    public void initBackground(double width, double height)
    {
	background = new Rectangle(Simulador.METRICS.getPX(width), Simulador.METRICS.getPX(height));
	setWidth(background.getWidth());
	setHeight(background.getHeight());
	addNode(background);
    }

    public void addNode(Node... node)
    {
	getChildren().addAll(node);
    }

    public void removeNode(Node node)
    {
	getChildren().remove(node);
    }

    public void show(StackPane paneRoot)
    {
	if (!paneRoot.getChildren().contains(this))
	{
	    paneRoot.getChildren().add(this);
	}
    }

}
