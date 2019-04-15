package br.com.mateussilvasant.tripulacao;

public class Airport
{

    String icao;
    String icaoName;
    String country;
    String city;

    public Airport(String icao, String icaoName, String country, String city, String longitude, String latitude,
	    String altitude, String magvar)
    {
	this.icao = icao;
	this.icaoName = icaoName;
	this.country = country;
	this.city = city;
    }

    public Airport()
    {
    }

    public boolean checkAirport()
    {
	if (icao != null && icaoName != null && country != null && city != null)
	{
	    return true;
	}
	return false;
    }

    public String getIcao()
    {
	return icao;
    }

    public void setIcao(String icao)
    {
	this.icao = icao;
    }

    public String getIcaoName()
    {
	return icaoName;
    }

    public void setIcaoName(String icaoName)
    {
	this.icaoName = icaoName;
    }

    public String getCountry()
    {
	return country;
    }

    public void setCountry(String country)
    {
	this.country = country;
    }

    public String getCity()
    {
	return city;
    }

    public void setCity(String city)
    {
	this.city = city;
    }

}
