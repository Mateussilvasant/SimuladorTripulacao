package br.com.mateussilvasant.tripulacao.components;

import javafx.scene.Group;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

public class SpinnerTimeAdapter extends Group
{

    public HBox background;
    private Spinner<Integer> hourField;
    private Spinner<Integer> minutesField;

    public SpinnerTimeAdapter()
    {
	background = new HBox();
	hourField = new Spinner<>();
	minutesField = new Spinner<>();
	hourField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0));
	minutesField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
	background.getChildren().addAll(hourField, minutesField);
	getChildren().add(background);
    }
    

}
