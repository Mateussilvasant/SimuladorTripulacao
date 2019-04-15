package br.com.mateussilvasant.tripulacao;

public class Test extends FSUIPConnect
{

    private Loop loop;
    private TripulationManager tripulationManager;

    public Test()
    {
	super();

	if (FSUIPConnect.CONNECTED)
	{
	  // initComponents();
	    
	    while(true) {
		OffsetResponse response = FSUIPController.requestSimulatorData(Offsets.wind);

		System.out.println("PushBack State: " + response.getDouble());
	    }
	    
	    
	}

    }

    private void initComponents()
    {
	tripulationManager = new TripulationManager();
	loop = new Loop(tripulationManager);
    }

    public static void main(String[] args)
    {

	Test teste = new Test();

    }
}
