package br.com.mateussilvasant.tripulacao;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DatabaseTripulation
{

    private final static String DATABASE_AIRPORT = "/airports.json";
    private final static String URL_DATABASE_SETTINGS = "/settings.json";
    private final static String AIRPLANES = "/airplanes.json";

    public static ArrayList<String> getListAirportNames()
    {

	ArrayList<String> icaos = new ArrayList<String>();
	JSONArray array = DatabaseManager.getInstance().getJSONArray(DATABASE_AIRPORT);

	Iterator<?> iterator = array.iterator();

	while (iterator.hasNext())
	{
	    JSONObject object = (JSONObject) iterator.next();
	    icaos.add((String) object.get("icao"));
	}

	return icaos;
    }

    public static ArrayList<String> getAirplaneNames()
    {

	ArrayList<String> names = new ArrayList<>();
	JSONArray array = DatabaseManager.getInstance().getJSONArray(AIRPLANES);

	Iterator<?> iterator = array.iterator();

	while (iterator.hasNext())
	{
	    JSONObject object = (JSONObject) iterator.next();
	    names.add(object.get("Name").toString());
	}

	return names;

    }

}
