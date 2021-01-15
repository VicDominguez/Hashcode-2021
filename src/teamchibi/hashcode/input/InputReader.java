package teamchibi.hashcode.input;

import java.io.*;
import java.util.Scanner;

public class InputReader
{
    private final Scanner sc;

    public InputReader(String file) throws FileNotFoundException
    {
        sc = new Scanner(new File(file));
    }

    public InputCase readFile(String path) throws IOException
    {
        InputCase ic = new InputCase();
        ic.setPath(path);

        //TODO: set here input case attributes


        sc.close();
        return ic;
    }

}
