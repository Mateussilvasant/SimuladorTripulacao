package br.com.mateussilvasant.tripulacao;

import com.flightsim.fsuipc.fsuipc_wrapper;

public class FSUIPConnect
{

    public static boolean CONNECTED = false;

    public FSUIPConnect()
    {
	setConnectionStatus(fsuipc_wrapper.Open(fsuipc_wrapper.SIM_ANY));
    }

    private void setConnectionStatus(int connectionStatus)
    {
	
	if(connectionStatus != 0) {
	    CONNECTED = true;
	} else {
	    CONNECTED = false;
	}
	
    }
}
