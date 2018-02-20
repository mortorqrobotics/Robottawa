package org.usfirst.frc.team1515.robot.util.coordsystem;
public class PlaneUtil {
	private static Point currentLoc;
	private static int currentRotate = 0; // in degrees
	
    public static double getDistance(Point a) {
        return Math.sqrt(Math.pow(currentLoc.getY() - a.getY(), 2) + Math.pow(currentLoc.getX() - a.getX(), 2));
    }

    public static double getAngle(Point a) {
        double base = a.getX() - currentLoc.getX();
        double height = a.getY() - currentLoc.getY();

        if (base == 0)
            return 0;
        if (height == 0)
            return (base > 0) ? 90 : -90;

        double temp =  Math.toDegrees(Math.atan2(height, base));
        double output = (base < 0) ? temp - 180 : temp;
        return output;
    }
    
    public static void setCurrentLoc(Point p) {
    	currentLoc = p;
    }
    
    public static void changeRotate(int degrees) {
    	currentRotate = getLeastAngle(currentRotate + degrees);
    }
    
    public static int getCurrentRotate() {
    	return currentRotate;
    }
    
    public static Point getCurrentLocation() {
    	return currentLoc;
    }
    
    public static int getLeastAngle(int angle) {
    	return angle;
    }
}
