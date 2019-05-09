package br.com.mateussilvasant.tripulacao;

import org.apache.commons.math.stat.descriptive.moment.Variance;

public class Test extends FSUIPConnect
{

    public double[] windX = new double[100];
    public double[] windY = new double[100];
    public double[] windZ = new double[100];

    private int point = 0;
    private Variance variance = new Variance();

    public Test()
    {
	super();

	if (FSUIPConnect.CONNECTED)
	{
	    // initComponents();

	    while (true)
	    {
		checkWind(FSUIPController.requestData(Offsets.wind_x), FSUIPController.requestData(Offsets.wind_y),
			FSUIPController.requestData(Offsets.wind_z));
	    }

	}

    }

    public void checkWind(OffsetResponse xData, OffsetResponse yData, OffsetResponse zData)
    {

	if (containsTurbulence((int) xData.getDouble(), (int) yData.getDouble(), (int) zData.getDouble()))
	{
	    System.out.println("Em turbulência");
	}

    }

    private boolean containsTurbulence(int x, int y, int z)
    {

	double[] deviations = new double[3];

	deviations[0] = x;
	deviations[1] = y;
	deviations[2] = z;

	double deviationWind = Math.sqrt(variance.evaluate(deviations));

	System.out.println("Desvio Total: " + deviationWind);

	if (deviationWind > 1.0 && deviationWind < 100.0)
	{
	    return true;
	}

	return false;
    }

    public static void main(String[] args)
    {

	Test teste = new Test();

    }
}
