package teamchibi.hashcode.objects;

public class Scheduler implements Comparable<Scheduler>
{
    private int intersectionID;
    private int numberOfGreenLights;
    private SchedulerPair[] route;

    public Scheduler(int intersectionID)
    {
        this.intersectionID = intersectionID;
    }

    public Scheduler(int intersectionID, int numberOfGreenLights, SchedulerPair[] route)
    {
        this.intersectionID = intersectionID;
        this.numberOfGreenLights = numberOfGreenLights;
        this.route = route;
    }

    public int getIntersectionID()
    {
        return intersectionID;
    }

    public void setIntersectionID(int intersectionID)
    {
        this.intersectionID = intersectionID;
    }

    public int getNumberOfGreenLights()
    {
        return numberOfGreenLights;
    }

    public void setNumberOfGreenLights(int numberOfGreenLights)
    {
        this.numberOfGreenLights = numberOfGreenLights;
    }

    public SchedulerPair[] getRoute()
    {
        return route;
    }

    public void setRoute(SchedulerPair[] route)
    {
        this.route = route;
    }

    public int getTotalTime()
    {
        int temp=0;
        for (int index = 0; index < route.length; index++)
            temp += route[index].getTimeOn();
        return temp;
    }

    @Override
    public int compareTo(Scheduler s)
    {
        int result = 0;
        if (this.getTotalTime() < s.getTotalTime())
            result = 1;
        else if (this.getTotalTime() > s.getTotalTime())
            result = -1;

        return result;
    }
}
