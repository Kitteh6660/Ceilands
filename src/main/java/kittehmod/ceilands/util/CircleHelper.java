package kittehmod.ceilands.util;

public class CircleHelper
{
	public static boolean isPlotInCircle(int pointA, int pointB, int radius) {
		return (Math.abs(Math.pow(pointA, 2)) + Math.abs(Math.pow(pointB, 2))) - Math.pow(Math.ceil(radius), 2) < 0;
	}
	
	public static boolean isPlotInSphere(int pointA, int pointB, int pointC, int radius) {
		return isPlotInCircle(pointA, pointB, radius) && isPlotInCircle(pointA, pointC, radius) && isPlotInCircle(pointB, pointC, radius);
	}
}
