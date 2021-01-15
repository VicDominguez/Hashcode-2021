package teamchibi.hashcode;

import teamchibi.hashcode.input.*;
import teamchibi.hashcode.output.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main
{
    private static final String INPUT_PATH = "input\\";
    private static final String OUTPUT_PATH = "output\\";

    private static ArrayList<InputCase> inputScenarios;

    private static String removeExtension(String path)
    {
        if (path.contains("."))
            return path.substring(0, path.lastIndexOf('.'));
        else
            return path;
    }

    public static void main(String[] args)
    {
        inputScenarios = new ArrayList<>();
        try
        {
            Files.walk(Paths.get(INPUT_PATH)).forEach(ruta->
            {
                if (Files.isRegularFile(ruta))
                {
                    InputReader ir;
                    String scenarioName;
                    try
                    {
                        ir = new InputReader(ruta.toString());
                        scenarioName = removeExtension(ruta.toFile().getName());
                        System.out.println("Scenario: " + scenarioName);
                        inputScenarios.add(ir.readFile(scenarioName));
                    } catch (IOException e)
                    {
                        System.err.println("Failure reading files");
                        e.printStackTrace(System.err);
                    }
                }
            });
        } catch (IOException e)
        {
            System.err.println("Error at input files path");
            e.printStackTrace(System.err);
        }

        for(InputCase actualScenario : inputScenarios) //resolve each scenario
        {
            OutputCase solution = null;
            System.out.println("Resolving scenario " + actualScenario.getPath());
            try
            {
                solution = Solver.doSolution(actualScenario);
                solution.setPath(actualScenario.getPath());
            } catch (Exception e)
            {
                System.err.println("Resolution error of scenario" + actualScenario.getPath());
                e.printStackTrace(System.err);
            }
            assert solution != null;

            String path = solution.getPath();
            System.out.println("Writing solution of scenario: " + path);
            OutputWriter ow = null;
            try
            {
                ow = new OutputWriter(OUTPUT_PATH + path + ".out");
                ow.writeFile(solution);
            } catch (IOException e)
            {
                System.err.println("Output writing error of scenario " + path);
                e.printStackTrace(System.err);
            }
        }
    }
}
