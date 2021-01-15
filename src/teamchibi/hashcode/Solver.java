package teamchibi.hashcode;

import teamchibi.hashcode.input.InputCase;
import teamchibi.hashcode.output.OutputCase;

public class Solver
{
    public static OutputCase doSolution(InputCase inputData)
    {
        long start, finish;
        start = System.currentTimeMillis();
        OutputCase solution = new OutputCase();
        //TODO: your solution here

        finish = System.currentTimeMillis();
        System.out.println("Elapsed time:  " + (finish - start) + " ms");
        return solution;
    }
}
