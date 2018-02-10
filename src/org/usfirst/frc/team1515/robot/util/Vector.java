package org.usfirst.frc.team1515.robot.util;

import java.lang.Math;

public class Vector {
    protected double x, y, angle, magnitude;

    public Vector(double fromX, double fromY, double x, double y){
        this.x = x - fromX;
        this.y = y - fromY;
        this.angle = 360.0;
        this.magnitude=-1;
    }
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
        this.angle = 360.0;
        this.magnitude=-1;
    }

    public static double angleBetween(Vector a, Vector b) {
        return Vector.normalizeAngle(Math.toDegrees(Math.acos(a.dot(b)/(a.magnitude() * b.magnitude()))));
    }
    public double angleBetween(Vector b) {
        return Vector.angleBetween(this, b);
    }

    public static double dot(Vector a, Vector b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }
    public double dot(Vector b) {
        return Vector.dot(this, b);
    }

    public double magnitude() {
    	if(this.magnitude==-1)
    		this.magnitude = Math.sqrt(this.x * this.x + this.y * this.y);
    	return this.magnitude;
    }

    public static Vector multiply(Vector v, double m) {
        return new Vector(v.getX() * m, v.getY() * m);
    }
    public static Vector multiply(Vector v, float m) {
        return Vector.multiply(v, (double)m);
    }
    public static Vector multiply(Vector v, int m) {
        return Vector.multiply(v, (double)m);
    }
    public Vector multiply(double m) {
        return new Vector(this.x * m, this.y * m);
    }
    public Vector multiply(float m) {
        return this.multiply((double)m);
    }
    public Vector multiply(int m) {
        return this.multiply((double)m);
    }
    
    public static Vector add(Vector a, Vector b) {
        return new Vector(a.getX() + b.getX(), a.getY() + b.getY());
    }
    public Vector add(Vector b) {
        return new Vector(this.x + b.getX(), this.y + b.getY());
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    public double angle() {
        if(angle != 360.0) return angle;
        if(y == 0) angle = (x < 0) ? 180.0 : 0.0;
        if(x == 0) angle = 90.0 + (y < 0 ? 180.0 : 0.0);
        else angle = Math.toDegrees(Math.asin(y / magnitude()));
        if(x < 0) angle = (y < 0 ? -1.0 : 1.0) * angle + 180.0;
        else if(y < 0) angle = -1.0 * angle + 180;
        angle = Vector.normalizeAngle(angle);
        return angle;
    }
    
    public static double realAngleBetween(Vector from, Vector to) {
    	return Vector.normalizeAngle(to.angle()-from.angle());
    }
    public double realAngleBetween(Vector to) {
    	return Vector.realAngleBetween(this, to);
    }
    public static double realAngleBetween(double angle, Vector to) {
    	return Vector.normalizeAngle(to.angle()-angle);
    }
    public double realAngleBetween(double angle) {
    	return Vector.realAngleBetween(angle, this);
    }
    
    protected static double normalizeAngle(double angle) {
    	if(angle<=180&&angle>-180) {
    		return angle;
    	} else if(angle>180) {
    		return Vector.normalizeAngle(angle - 360);
    	}
    	return Vector.normalizeAngle(angle+360);
    }
}
