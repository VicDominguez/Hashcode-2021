package teamchibi.hashcode.objects;

public class Street
{
    private int origin;
    private int destination;
    private String name;
    private int time;

    private int passingCars;
    private int rightPassingCars;

    public Street(int origin, int destination, String name, int time)
    {
        this.origin = origin;
        this.destination = destination;
        this.name = name;
        this.time = time;
        this.passingCars = 0;
    }

    public int getOrigin()
    {
        return origin;
    }

    public void setOrigin(int origin)
    {
        this.origin = origin;
    }

    public int getDestination()
    {
        return destination;
    }

    public void setDestination(int destination)
    {
        this.destination = destination;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public void addCar()
    {
        this.passingCars++;
    }

    public void addValidCar()
    {
        this.rightPassingCars++;
    }

    public int getRightPassingCars()
    {
        return rightPassingCars;
    }

    public int getPassingCars()
    {
        return this.passingCars;
    }

    public int getOpenTime()
    {
        return rightPassingCars;
    }
}
