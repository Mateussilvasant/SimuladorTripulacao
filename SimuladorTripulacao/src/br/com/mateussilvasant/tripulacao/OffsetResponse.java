package br.com.mateussilvasant.tripulacao;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class OffsetResponse
{
    public byte[] arrayResponse;
    private ByteBuffer buffer;

    public OffsetResponse(byte[] arrayResponse)
    {
	this.arrayResponse = arrayResponse;
    }

    public int getInt()
    {
	buffer = ByteBuffer.allocate(4);
	buffer.order(ByteOrder.LITTLE_ENDIAN);
	buffer.put(arrayResponse, 0, 4);
	return buffer.getInt(0);
    }

    public double getDouble()
    {
	buffer = ByteBuffer.allocate(8);
	buffer.order(ByteOrder.LITTLE_ENDIAN);
	buffer.put(arrayResponse, 0, 8);
	return buffer.getDouble(0);
    }

    public long getLong()
    {

	buffer = ByteBuffer.allocate(8);
	buffer.order(ByteOrder.LITTLE_ENDIAN);
	ByteBuffer.allocate(8);
	buffer.put(arrayResponse, 0, 8);
	return buffer.getLong(0);
    }

}
