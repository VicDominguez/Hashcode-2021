package teamchibi.hashcode;

import teamchibi.hashcode.input.InputCase;
import teamchibi.hashcode.objects.Intersection;
import teamchibi.hashcode.objects.Scheduler;
import teamchibi.hashcode.objects.SchedulerPair;
import teamchibi.hashcode.objects.Street;
import teamchibi.hashcode.objects.Car;
import teamchibi.hashcode.output.OutputCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solver
{
    public static OutputCase doSolution(InputCase inputData)
    {
        long start, finish;
        start = System.currentTimeMillis();
        OutputCase solution = new OutputCase();

        ArrayList<Scheduler> schedulers = new ArrayList<>();

        for (int index = 0; index < inputData.getNumberOfIntersections(); index++)
        {
            Intersection actualIntersection = inputData.getIntersections()[index];

            Scheduler s = new Scheduler(actualIntersection.getId());
            int inputStreetsSize = actualIntersection.getInputStreets().size();

            ArrayList<SchedulerPair> buffer = new ArrayList<>();

            for (int streetIndex = 0; streetIndex < inputStreetsSize; streetIndex++)
            {
                Street actualStreet = actualIntersection.getInputStreets().get(streetIndex);
                if (actualStreet.getRightPassingCars() > 0)
                    buffer.add(new SchedulerPair(actualStreet.getName(),actualStreet.getOpenTime()));
            }
            Collections.sort(buffer);

            if (buffer.size() > 1)
            {
                int minimun = buffer.get(buffer.size() -1).getTimeOn();

                for (int divideIndex = 0; divideIndex < buffer.size();divideIndex++)
                {
                    int temp = buffer.get(divideIndex).getTimeOn() / minimun;
                    if (buffer.get(divideIndex).getTimeOn() % minimun != 0)
                        temp++;
                    buffer.get(divideIndex).setTimeOn(temp);
                }
            }

            SchedulerPair[] bufferArray = buffer.toArray(new SchedulerPair[buffer.size()]);
            s.setRoute(bufferArray);
            s.setNumberOfGreenLights(bufferArray.length);
            if(bufferArray.length > 0)
                schedulers.add(s);
        }


        Collections.sort(schedulers);
        Scheduler[] schedulersArray = schedulers.toArray(new Scheduler[schedulers.size()]);

        solution.setSchedulers(schedulersArray);
        solution.setNumberOfSchedulers(schedulersArray.length);

        finish = System.currentTimeMillis();
        System.out.println("Elapsed time:  " + (finish - start) + " ms");
        return solution;
    }


}
