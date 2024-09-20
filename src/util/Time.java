package util;

public class Time {
    public static double timeStarted = System.nanoTime();

    public static double getTimeStarted(){
        return (System.nanoTime() - timeStarted) * 1E-9;
    }
}
