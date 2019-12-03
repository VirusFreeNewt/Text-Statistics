import java.io.File;

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
            System.out.printf(textStatistics.toString());
        }
        else
        {

            System.out.println("The file(s): " + Arrays.toString(args) + " are do not exist");
            System.exit(-1);
        }
    }
}
