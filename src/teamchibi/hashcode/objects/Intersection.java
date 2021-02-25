package teamchibi.hashcode.objects;

import java.util.ArrayList;

public class Intersection implements Comparable<Intersection>
{
    private int id;
    private int validCars;
    private ArrayList<Street> inputStreets;

    public Intersection(int id)
    {
        this.id = id;
        this.inputStreets = new ArrayList<>();
    }

    public Intersection(ArrayList<Street> inputStreets)
    {
        this.inputStreets = inputStreets;
        this.computeValidCars();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public ArrayList<Street> getInputStreets()
    {
        return inputStreets;
    }

    public void setInputStreets(ArrayList<Street> inputStreets)
    {
        this.inputStreets = inputStreets;
        this.computeValidCars();
    }

    public void addInputStreet(Street s)
    {
        this.inputStreets.add(s);
    }

    public void computeValidCars()
    {
        validCars = 0;
        for (Street s: inputStreets)
            validCars += s.getRightPassingCars();
    }

    @Override
    public int compareTo(Intersection i)
    {
        int result = 0;
        if (this.validCars < i.validCars)
            result = -1;
        else if (this.validCars > i.validCars)
            result = 1;

        return result;
    }
}
