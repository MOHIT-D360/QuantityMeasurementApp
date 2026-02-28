package com;

public interface IMeasurable {
	public double getConversionFactor();
	public double convertToBaseUnit(double value);
	public double convertFromBaseUnit(double value);
}