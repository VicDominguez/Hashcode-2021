package teamchibi.hashcode.objects;

public class Car
{
    private int numberStreets;
    private int minimunTime;
    private Street[] streets;

    public Car(int numberStreets)
    {
        this.numberStreets = numberStreets;
    }

    public Car(int numberStreets, Street[] streets)
    {
        this.numberStreets = numberStreets;
        this.streets = streets;
        computeTime();
    }

    public int getNumberStreets()
    {
        return numberStreets;
    }

    public void setNumberStreets(int numberStreets)
    {
        this.numberStreets = numberStreets;
    }

    public Street[] getStreets()
    {
        return streets;
    }

    public void setStreets(Street[] streets)
    {
        this.streets = streets;
        computeTime();
    }

    private void computeTime()
    {
        this.minimunTime = 0;
        for (int index = 1; index < streets.length; index++)
            minimunTime += streets[index].getTime();
    }

    public int getMinimunTime()
    {
        return minimunTime;
    }
}
