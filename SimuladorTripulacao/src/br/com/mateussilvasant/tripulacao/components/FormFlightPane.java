package br.com.mateussilvasant.tripulacao.components;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class FormFlightPane extends GridPane
{
    private int col;
    private int line;

    public FormFlightPane(int col, int line)
    {
	this.col = col;
	this.line = line;
    }

    public void setMarginAll(double p1, double p2, double p3, double p4)
    {
	Insets margin = new Insets(p1, p2, p3, p4);

	for (Node node : getChildren())
	{
	    setMargin(node, margin);
	}

    }

    public void addAll(Node... nodes)
    {
	int qtdNodes = nodes.length;
	int pointer = 0;

	for (int i = 0; i < line; i++)
	{
	    for (int d = 0; d < col; d++)
	    {
		if (pointer < qtdNodes)
		{
		    add(nodes[pointer], d, i);
		    pointer++;
		}

	    }
	}

    }
}
