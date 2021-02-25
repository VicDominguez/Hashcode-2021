package teamchibi.hashcode.output;

import teamchibi.hashcode.objects.Scheduler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter
{
    private final BufferedWriter bufferedWriter;

    public OutputWriter(String file) throws IOException
    {
        bufferedWriter = new BufferedWriter(new FileWriter(file));
    }

    public void writeFile(OutputCase oc) throws IOException
    {
        bufferedWriter.write(String.valueOf(oc.getNumberOfSchedulers()));
        bufferedWriter.newLine();

        for (int index = 0; index < oc.getSchedulers().length; index++)
        {
            Scheduler s = oc.getSchedulers()[index];
            bufferedWriter.write(String.valueOf(s.getIntersectionID()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(s.getNumberOfGreenLights()));
            bufferedWriter.newLine();

            for(int internalIndex = 0; internalIndex < s.getNumberOfGreenLights(); internalIndex++)
            {
                if(internalIndex > 0)
                    bufferedWriter.newLine();
                bufferedWriter.write(s.getRoute()[internalIndex].toString());
            }
            if(index + 1 < oc.getSchedulers().length)
                bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
