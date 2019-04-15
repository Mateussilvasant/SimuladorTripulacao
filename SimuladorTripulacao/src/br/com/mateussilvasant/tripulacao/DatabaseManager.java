package br.com.mateussilvasant.tripulacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DatabaseManager
{

    private static DatabaseManager database;

    public static DatabaseManager getInstance()
    {

	if (database == null)
	{
	    database = new DatabaseManager();
	}
	return database;

    }

    public BufferedWriter getWriterFile(File file)
    {
	try
	{
	    return new BufferedWriter(new FileWriter(file));
	} catch (IOException e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    public BufferedReader getReaderFile(File file)
    {

	try
	{
	    return new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	}

	return null;

    }

    public JSONArray getJSONArray(String path)
    {
	try
	{
	    return (JSONArray) new JSONParser().parse(getReaderFile(getFileDatabase(path)));
	} catch (IOException e)
	{
	    e.printStackTrace();
	} catch (ParseException e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    public Object getValueJSON(String key, String path)
    {

	try
	{
	    JSONObject object = (JSONObject) new JSONParser().parse(getReaderFile(getFileDatabase(path)));
	    return object.get(key);

	} catch (IOException e)
	{
	    e.printStackTrace();
	} catch (ParseException e)
	{
	    e.printStackTrace();
	}
	return null;

    }

    public File getFileDatabase(String path)
    {
	return new File(getClass().getResource(path).getPath());
    }

}
