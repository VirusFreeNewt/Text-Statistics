//package textstatistics;

import java.io.File;

/**
 *
 *
 *
 *
 * @author Pluska
 */
public class ProcessStatistics
{

    public static void main(String[] args)
    {
        File file = null;
        try
        {
            file = new File(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Please pass in a text file when compiling");
            System.exit(1);
        }

        if (file.exists())
        {

            TextStatistics textStatistics = new TextStatistics(file);

        }
        else
        {
            System.out.println("Please pass in a text file when compiling");
        }



    }

}
