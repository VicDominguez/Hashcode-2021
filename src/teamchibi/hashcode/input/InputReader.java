package teamchibi.hashcode.input;

import teamchibi.hashcode.objects.Car;
import teamchibi.hashcode.objects.Intersection;
import teamchibi.hashcode.objects.Street;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class InputReader
{
    private final Scanner sc;

    public InputReader(String file) throws FileNotFoundException
    {
        sc = new Scanner(new File(file));
    }

    public InputCase readFile(String path) throws IOException
    {
        InputCase ic = new InputCase();
        ic.setPath(path);

        int duration,numberOfIntersections, numberOfStreets, numberOfCars;

        duration = sc.nextInt();
        ic.setDurationOfSimulation(duration);
        numberOfIntersections = sc.nextInt();
        ic.setNumberOfIntersections(numberOfIntersections);
        numberOfStreets = sc.nextInt();
        ic.setNumberOfStreets(numberOfStreets);
        numberOfCars = sc.nextInt();
        ic.setNumberOfCars(numberOfCars);
        ic.setCarDefaultScore(sc.nextInt());

        HashMap<String, Street> streets = new HashMap<>();
        Car[] cars = new Car[numberOfCars];

        Intersection[] intersections = new Intersection[numberOfIntersections];
        for (int index = 0; index < numberOfIntersections; index++)
        {
            intersections[index] = new Intersection(index);
        }

        for (int index = 0; index < numberOfStreets; index++)
        {
            int origin = sc.nextInt();
            int destination = sc.nextInt();
            String name = sc.next();
            int time = sc.nextInt();
            Street actualStreet = new Street(origin,destination,name,time);
            streets.put(name, actualStreet);
            intersections[destination].addInputStreet(actualStreet);
        }

        for (int index = 0; index < numberOfCars; index++)
        {
            int carNumberOfStreets = sc.nextInt();
            Street[] bufferOfStreets = new Street[carNumberOfStreets];

            cars[index] = new Car(carNumberOfStreets);

            for (int internalIndex = 0; internalIndex < carNumberOfStreets; internalIndex++)
            {
                bufferOfStreets[internalIndex] = streets.get(sc.next());
                bufferOfStreets[internalIndex].addCar();
            }

            cars[index].setStreets(bufferOfStreets);

            for (int internalIndex = 0; internalIndex < carNumberOfStreets; internalIndex++)
            {
                if (planificableCar(duration,cars[index]))
                    bufferOfStreets[internalIndex].addValidCar();
            }

        }


        ic.setStreets(streets);
        ic.setIntersections(intersections);
        ic.setCars(cars);

        sc.close();
        return ic;
    }

    private boolean planificableCar(int duration, Car c)
    {
        return duration >= c.getMinimunTime();
    }

}
