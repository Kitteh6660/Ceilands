package com.kittehmod.ceilands.util;

import net.minecraft.core.BlockPos;

public class MathHelper
{
	public static boolean isPlotInCircle(int pointA, int pointB, int radius) {
		return (Math.abs(Math.pow(pointA, 2)) + Math.abs(Math.pow(pointB, 2))) - Math.pow(Math.ceil(radius), 2) < 0;
	}
	
	public static boolean isPlotInSphere(int pointA, int pointB, int pointC, int radius) {
		return isPlotInCircle(pointA, pointB, radius) && isPlotInCircle(pointA, pointC, radius) && isPlotInCircle(pointB, pointC, radius);
	}
	
	public static BlockPos getInterpolatedBlockPos(BlockPos pointA, BlockPos pointB, float progress) {
		int diffX = pointA.getX() - pointB.getX();
		int diffY = pointA.getY() - pointB.getY();
		int diffZ = pointA.getZ() - pointB.getZ();
		return pointA.above((int)Math.round(diffY * progress)).east((int)Math.round(diffX * progress)).south((int)Math.round(diffZ * progress));
	}
}
