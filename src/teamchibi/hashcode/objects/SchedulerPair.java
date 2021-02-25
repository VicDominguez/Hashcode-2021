package teamchibi.hashcode.objects;

public class SchedulerPair implements Comparable<SchedulerPair>
{
    private String street;
    private int timeOn;

    public SchedulerPair(String street, int timeOn)
    {
        this.street = street;
        this.timeOn = timeOn;
    }

    @Override
    public String toString()
    {
        return street + " " + String.valueOf(timeOn);
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getTimeOn()
    {
        return timeOn;
    }

    public void setTimeOn(int timeOn)
    {
        this.timeOn = timeOn;
    }

    @Override
    public int compareTo(SchedulerPair o)
    {
        int result = 0;
        if (this.getTimeOn() < o.getTimeOn())
            result = -1;
        else if (this.getTimeOn() > o.getTimeOn())
            result = 1;

        return result;
    }
}
