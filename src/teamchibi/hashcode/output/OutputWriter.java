package teamchibi.hashcode.output;

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

        //TODO: write here your output format using OutputCase attributes

        bufferedWriter.close();
    }
}
