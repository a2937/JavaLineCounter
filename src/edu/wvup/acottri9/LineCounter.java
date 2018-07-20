package edu.wvup.acottri9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The type Line counter.
 */
public class LineCounter
{

    /**
     * Count int.
     *
     * @param sourceFile the source file
     * @return the int
     */
    public static int Count(String sourceFile)
    {
        int lineCount = 0;
        File file = new File(sourceFile);
        StringBuilder completeString = new StringBuilder();
        Scanner newScanner;
        try
        {
            newScanner = new Scanner(file);
            while ( newScanner.hasNextLine( ) )
            {
                completeString.append(newScanner.nextLine()).append("\n");
            }
            newScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println(sourceFile + " not found");
        }

        String[] lines = completeString.toString().split("\n");


        for(String line : lines)
        {
            if (!line.trim().startsWith("//") && !line.trim().startsWith("/*") && !line.trim().startsWith("*/") && !line.trim().startsWith("*") && !line.isEmpty())
            {
                lineCount++;
            }
        }

        return lineCount;

    }
}
