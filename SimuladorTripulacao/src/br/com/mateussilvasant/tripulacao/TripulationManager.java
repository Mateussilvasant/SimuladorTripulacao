package br.com.mateussilvasant.tripulacao;

public class TripulationManager
{

    public TripulationManager()
    {
    }

    public void update()
    {
	OffsetResponse response = FSUIPController.requestData(Offsets.altitude);

	System.out.println("PushBack State: " + response.getInt());
    }
    // Pegar holding (response.getDouble() * 57.2958) + 22)

}
