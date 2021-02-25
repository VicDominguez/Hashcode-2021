package teamchibi.hashcode.input;

import teamchibi.hashcode.objects.Intersection;
import teamchibi.hashcode.objects.Street;
import teamchibi.hashcode.objects.Car;

import java.util.HashMap;

public class InputCase
{
    private String path;

    private int durationOfSimulation;
    private int numberOfIntersections;
    private int numberOfStreets;
    private int numberOfCars;
    private int carDefaultScore;

    private HashMap<String,Street> streets;
    private Car[] cars;
    private Intersection[] intersections;

    public Intersection[] getIntersections()
    {
        return intersections;
    }

    public void setIntersections(Intersection[] intersections)
    {
        this.intersections = intersections;
    }

    public int getDurationOfSimulation()
    {
        return durationOfSimulation;
    }

    public void setDurationOfSimulation(int durationOfSimulation)
    {
        this.durationOfSimulation = durationOfSimulation;
    }

    public int getNumberOfIntersections()
    {
        return numberOfIntersections;
    }

    public void setNumberOfIntersections(int numberOfIntersections)
    {
        this.numberOfIntersections = numberOfIntersections;
    }

    public int getNumberOfStreets()
    {
        return numberOfStreets;
    }

    public void setNumberOfStreets(int numberOfStreets)
    {
        this.numberOfStreets = numberOfStreets;
    }

    public int getNumberOfCars()
    {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars)
    {
        this.numberOfCars = numberOfCars;
    }

    public int getCarDefaultScore()
    {
        return carDefaultScore;
    }

    public void setCarDefaultScore(int carDefaultScore)
    {
        this.carDefaultScore = carDefaultScore;
    }

    public HashMap<String,Street> getStreets()
    {
        return streets;
    }

    public void setStreets(HashMap<String,Street> streets)
    {
        this.streets = streets;
    }

    public Car[] getCars()
    {
        return cars;
    }

    public void setCars(Car[] cars)
    {
        this.cars = cars;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
