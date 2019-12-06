import java.io.File;
import java.util.Arrays;

/**
 *
 *
 *
 *
 * @author VirusFreeNewt
 */
public class ProcessStatistics
{
    public static void main(String[] args)
    {
        File file = null;
        for(int i = 0; i < args.length; ++i)
        {
            try
            {
                file = new File(args[i]);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Please pass in a text file when compiling");
                System.exit(1);
            }

            if (file.exists())
            {
                TextStatistics textStatistics = new TextStatistics(file);
                System.out.printf(textStatistics.toString());
            }
            else
            {
                System.out.println("The file: " + file + " does not exist");
            }
        }
    }
}
