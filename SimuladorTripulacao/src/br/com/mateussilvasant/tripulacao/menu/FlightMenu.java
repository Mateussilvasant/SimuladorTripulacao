package br.com.mateussilvasant.tripulacao.menu;

import br.com.mateussilvasant.tripulacao.Simulador;
import br.com.mateussilvasant.tripulacao.components.ComboBoxAdapter;
import br.com.mateussilvasant.tripulacao.components.FormFlightPane;
import br.com.mateussilvasant.tripulacao.components.SpinnerTimeAdapter;
import br.com.mateussilvasant.tripulacao.controller.FlightController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FlightMenu extends FlightPane
{
    private FormFlightPane infoFlightPane;
    private VBox verticalMenuFlight;
    private TextField departureField;
    private TextField arrivalField;
    private SpinnerTimeAdapter timeFlightField;
    private TextField numberFlightField;
    private ComboBox<String> passengerGateTimeField;
    private SpinnerTimeAdapter departureTimeField;
    private FormFlightPane infoFlightInstruments;
    private TextField fieldFlightLevel;
    private ComboBoxAdapter<String> fieldAirplane;
    private Button buttonStartFlight;
    private TextField fieldQtdPassengers;

    public FlightMenu(FlightController controller)
    {
	super(0.36, 0.23);
	initContent(controller);
    }

    @Override
    public void settings()
    {
	background.getStyleClass().add("paneInfoFlight");
	setPickOnBounds(false);
	setTranslateX(Simulador.METRICS.getX((0.077)));
    }

    public void initContent(FlightController controller)
    {
	initFlightMenu(controller);
	initFlightInformation(controller);
	initFlightInstruments(controller);
    }

    private void initFlightInstruments(FlightController controller)
    {
	Label titleInfoFlightInstruments = new Label("Informações Técnicas");
	titleInfoFlightInstruments.setFont(Font.font(Simulador.METRICS.getPX(0.005)));
	titleInfoFlightInstruments.getStyleClass().add("labelInfoFlight");

	Label labelFlightLevel = new Label("Altitude Cruzeiro: ");
	labelFlightLevel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	fieldFlightLevel = new TextField();
	fieldFlightLevel.setPrefWidth(Simulador.METRICS.getPX(0.03));

	Label labelAirplane = new Label("Aeronave: ");
	labelAirplane.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	fieldAirplane = new ComboBoxAdapter<String>(controller.getAirplanes());
	fieldAirplane.setPrefWidth(Simulador.METRICS.getPX(0.05));

	Label labelQTDpassengers = new Label("Total de Passageiros: ");
	labelQTDpassengers.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	fieldQtdPassengers = new TextField();
	fieldQtdPassengers.setPrefWidth(Simulador.METRICS.getPX(0.02));

	infoFlightInstruments.addAll(labelFlightLevel, fieldFlightLevel, labelAirplane, fieldAirplane,
		labelQTDpassengers, fieldQtdPassengers);

	double padding = Simulador.METRICS.getPX(0.0015);
	infoFlightInstruments.setMarginAll(0, padding, 0, padding);

	VBox vboxFlightInstruments = new VBox();

	vboxFlightInstruments.getChildren().addAll(titleInfoFlightInstruments, infoFlightInstruments);

	verticalMenuFlight.getChildren().add(vboxFlightInstruments);

    }

    public void initFlightInformation(FlightController controller)
    {

	Label titleInfoFlight = new Label("Informação do Vôo");
	titleInfoFlight.setFont(Font.font(Simulador.METRICS.getPX(0.005)));
	titleInfoFlight.getStyleClass().add("labelInfoFlight");

	Label departureLabel = new Label("ICAO Departure: ");
	departureLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label numberFlightLabel = new Label("Nº do Vôo: ");
	numberFlightLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label arrivalLabel = new Label("ICAO Arrival: ");
	arrivalLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label timeFlightLabel = new Label("Tempo de Vôo: ");
	timeFlightLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label passengerGateTimeLabel = new Label("Tempo Embarque: ");
	passengerGateTimeLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	Label departureTimeLabel = new Label("Hora de Partida: ");
	departureTimeLabel.setFont(Font.font(Simulador.METRICS.getPX(0.006)));

	numberFlightField = new TextField();
	numberFlightField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	departureField = new TextField();
	departureField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	arrivalField = new TextField();
	arrivalField.setPrefWidth(Simulador.METRICS.getPX(0.03));

	timeFlightField = new SpinnerTimeAdapter();
	timeFlightField.background.setPrefWidth(Simulador.METRICS.getPX(0.05));

	departureTimeField = new SpinnerTimeAdapter();
	departureTimeField.background.setPrefWidth(Simulador.METRICS.getPX(0.05));

	passengerGateTimeField = new ComboBoxAdapter<Integer>(controller.getTimesGate());
	passengerGateTimeField.setPrefWidth(Simulador.METRICS.getPX(0.035));
	passengerGateTimeField.setTooltip(new Tooltip("00 min : sec 00"));

	infoFlightPane.addAll(numberFlightLabel, numberFlightField, departureLabel, departureField, arrivalLabel,
		arrivalField, timeFlightLabel, timeFlightField, departureTimeLabel, departureTimeField,
		passengerGateTimeLabel, passengerGateTimeField);

	double padding = Simulador.METRICS.getPX(0.0015);
	infoFlightPane.setMarginAll(0, padding, 0, padding);

	VBox vboxFlightInformation = new VBox();
	vboxFlightInformation.getChildren().addAll(titleInfoFlight, infoFlightPane);

	verticalMenuFlight.getChildren().add(vboxFlightInformation);
    }

    public void initFlightMenu(FlightController controller)
    {
	Group group = new Group();
	verticalMenuFlight = new VBox();
	verticalMenuFlight.setSpacing(Simulador.METRICS.getPX(0.008));

	Label titleMenu = new Label("Iniciar um Vôo");
	titleMenu.setTranslateY(Simulador.METRICS.getY(-0.300));
	titleMenu.setFont(Font.font(Simulador.METRICS.getPX(0.010)));

	double p = Simulador.METRICS.getPX(0.008);

	infoFlightPane = new FormFlightPane(6, 2);
	infoFlightPane.setHgap(Simulador.METRICS.getPX(0.001));
	infoFlightPane.setVgap(Simulador.METRICS.getPX(0.005));
	infoFlightPane.getStyleClass().add("infoFlightPaneStyle");
	infoFlightPane.setPadding(new Insets(p, p, p, p));

	infoFlightInstruments = new FormFlightPane(8, 2);
	infoFlightInstruments.setHgap(Simulador.METRICS.getPX(0.001));
	infoFlightInstruments.setVgap(Simulador.METRICS.getPX(0.005));
	infoFlightInstruments.getStyleClass().add("infoFlightPaneStyle");
	infoFlightInstruments.setPadding(new Insets(p, p, p, p));

	buttonStartFlight = new Button("Iniciar Vôo");
	buttonStartFlight.setTranslateY(Simulador.METRICS.getY(0.20));
	buttonStartFlight.setFont(Font.font(Simulador.METRICS.getPX(0.008)));
	buttonStartFlight.setPrefWidth(Simulador.METRICS.getPX(0.09));
	buttonStartFlight.setOnMouseClicked(controller.startFlightAction());

	getChildren().add(titleMenu);
	group.getChildren().addAll(verticalMenuFlight);
	getChildren().add(buttonStartFlight);
	getChildren().add(group);
    }

}
