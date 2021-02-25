package teamchibi.hashcode.output;

import teamchibi.hashcode.objects.Scheduler;

public class OutputCase
{
    private String path;

    private int numberOfSchedulers;

    private Scheduler[] schedulers;

    public OutputCase()
    {
    }

    public OutputCase(int numberOfSchedulers, Scheduler[] schedulers)
    {
        this.numberOfSchedulers = numberOfSchedulers;
        this.schedulers = schedulers;
    }


    public int getNumberOfSchedulers()
    {
        return numberOfSchedulers;
    }

    public void setNumberOfSchedulers(int numberOfSchedulers)
    {
        this.numberOfSchedulers = numberOfSchedulers;
    }

    public Scheduler[] getSchedulers()
    {
        return schedulers;
    }

    public void setSchedulers(Scheduler[] schedulers)
    {
        this.schedulers = schedulers;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
