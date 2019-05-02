package br.com.mateussilvasant.tripulacao;

import com.flightsim.fsuipc.fsuipc_wrapper;

public class FSUIPController
{

    public static OffsetResponse requestData(int[] offset)
    {
	if (offset != null)
	{

	    byte[] array = null;

	    if (offset[1] == 1)
	    {
		array = new byte[4];
		fsuipc_wrapper.ReadData(offset[0], 4, array);
	    }
	    if (offset[1] == 2)
	    {
		array = new byte[8];
		fsuipc_wrapper.ReadData(offset[0], 8, array);
	    }

	    if (array != null)
	    {
		return new OffsetResponse(array);
	    }

	}
	return null;

    }

}
