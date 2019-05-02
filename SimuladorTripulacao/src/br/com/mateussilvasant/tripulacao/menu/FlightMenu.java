package br.com.mateussilvasant.tripulacao.menu;

import br.com.mateussilvasant.tripulacao.Simulador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FlightMenu extends FlightPane
{
    private GridPane infoFlightPane;
    private VBox verticalMenuFlight;
    private TextField departureField;
    private TextField arrivalField;
    private TextField timeFlightField;
    private TextField numberFlightField;
    private ComboBox<String> passengerGateTimeField;
    private TextField gateField;

    public FlightMenu()
    {
	super(0.34, 0.23);
    }

    @Override
    public void settings()
    {
	background.setFill(Color.rgb(255, 255, 255));
	setPickOnBounds(false);
	setTranslateX(Simulador.METRICS.getX((0.077)));
    }

    @Override
    public void initContent()
    {
	initFlightMenu();
    }

    public void initFlightMenu()
    {
	Group group = new Group();

	verticalMenuFlight = new VBox();

	infoFlightPane = new GridPane();
	infoFlightPane.setHgap(Simulador.METRICS.getPX(0.001));
	infoFlightPane.setVgap(Simulador.METRICS.getPX(0.005));

	infoFlightPane.setEffect(new InnerShadow(Simulador.METRICS.getPX(0.030), Color.rgb(12, 84, 166)));
	infoFlightPane.getStyleClass().add("infoFlightPaneStyle");

	double p = Simulador.METRICS.getPX(0.008);
	infoFlightPane.setPadding(new Insets(p, p, p, p));

	Label titleMenu = new Label("Iniciar um Vôo");
	titleMenu.setTranslateY(Simulador.METRICS.getY(-0.300));
	titleMenu.setFont(Font.font(Simulador.METRICS.getPX(0.010)));

	Label titleInfoFlight = new Label("Informações Vôo:");
	titleInfoFlight.setFont(Font.font(Simulador.METRICS.getPX(0.007)));

	Label departureLabel = new Label("Origem: ");
	departureLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label numberFlightLabel = new Label("Número Vôo: ");
	numberFlightLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label arrivalLabel = new Label("Destino: ");
	arrivalLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label timeFlightLabel = new Label("Tempo de Vôo: ");
	timeFlightLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label passengerGateTimeLabel = new Label("Tempo/Embarque: ");
	passengerGateTimeLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label gateLabel = new Label("Portão Gate: ");
	gateLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	numberFlightField = new TextField();
	numberFlightField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	departureField = new TextField();
	departureField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	arrivalField = new TextField();
	arrivalField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	timeFlightField = new TextField();
	timeFlightField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	ObservableList<String> times = FXCollections.observableArrayList("01:00", "05:00", "10:00", "30:00");
	passengerGateTimeField = new ComboBox<String>(times);
	passengerGateTimeField.setPrefWidth(Simulador.METRICS.getPX(0.03));
	passengerGateTimeField.setTooltip(new Tooltip("00 min : sec 00"));

	gateField = new TextField();
	gateField.setPrefWidth(Simulador.METRICS.getPX(0.01));

	double paddingField = Simulador.METRICS.getPX(0.004);

	GridPane.setMargin(numberFlightField, new Insets(0, paddingField, 0, paddingField));
	GridPane.setMargin(departureField, new Insets(0, paddingField, 0, paddingField));
	GridPane.setMargin(arrivalField, new Insets(0, paddingField, 0, paddingField));
	GridPane.setMargin(timeFlightField, new Insets(0, paddingField, 0, paddingField));
	GridPane.setMargin(gateField, new Insets(0, paddingField, 0, paddingField));
	GridPane.setMargin(passengerGateTimeField, new Insets(0, paddingField, 0, paddingField - 20));

	infoFlightPane.add(numberFlightLabel, 0, 0);
	infoFlightPane.add(numberFlightField, 1, 0);
	infoFlightPane.add(departureLabel, 2, 0);
	infoFlightPane.add(departureField, 3, 0);
	infoFlightPane.add(arrivalLabel, 4, 0);
	infoFlightPane.add(arrivalField, 5, 0);
	infoFlightPane.add(timeFlightLabel, 6, 0);
	infoFlightPane.add(timeFlightField, 7, 0);
	infoFlightPane.add(gateLabel, 0, 1);
	infoFlightPane.add(gateField, 1, 1);
	infoFlightPane.add(passengerGateTimeLabel, 2, 1);
	infoFlightPane.add(passengerGateTimeField, 3, 1);

	verticalMenuFlight.getChildren().add(titleInfoFlight);
	verticalMenuFlight.getChildren().add(infoFlightPane);

	getChildren().add(titleMenu);
	group.getChildren().add(verticalMenuFlight);
	getChildren().add(group);
    }

}
