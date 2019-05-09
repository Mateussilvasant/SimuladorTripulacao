package br.com.mateussilvasant.tripulacao.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

public class ComboBoxAdapter<T> extends ComboBox<String>
{
    private HashMap<String, T> items;

    public ComboBoxAdapter(HashMap<String, T> items)
    {
	this.items = items;
	setItems();
    }

    public ComboBoxAdapter(ArrayList<String> items)
    {
	super(FXCollections.observableArrayList(items));
    }

    public void setItems()
    {
	for (Entry<String, T> key : items.entrySet())
	{
	    getItems().add(key.getKey());
	}
    }
}
