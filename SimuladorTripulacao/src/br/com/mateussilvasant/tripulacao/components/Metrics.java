package br.com.mateussilvasant.tripulacao.components;

public class Metrics
{

    private double originalWidth;
    private double originalHeight;

    public Metrics(double originalWidth, double originalHeight)
    {
	this.setOriginalHeight(originalHeight);
	this.setOriginalWidth(originalWidth);
    }

    public double getPX(double size)
    {
	return (getHeight() + getWidth()) * size;
    }

    public double getX(double position)
    {
	return getWidth() * position;
    }

    public double getY(double position)
    {
	return getHeight() * position;
    }

    public double getWidth()
    {
	return originalWidth;
    }

    private void setOriginalWidth(double originalWidth)
    {
	this.originalWidth = originalWidth;
    }

    public double getHeight()
    {
	return originalHeight;
    }

    private void setOriginalHeight(double originalHeight)
    {
	this.originalHeight = originalHeight;
    }
}
