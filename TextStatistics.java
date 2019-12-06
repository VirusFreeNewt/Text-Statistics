import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 *
 *
 * @author VirusFreeNewt
 */
public class TextStatistics implements TextStatisticsInterface
{
    private final String DELIMITERS = "\\W+";
    private int lineCount, wordCount, charCount, charCountSpaces;
    private int[] letterCount = new int[26], wordLengthCount = new int[24];
    private double averageWordLength;
    private String results = "";

    TextStatistics(File file)
    {
        File textFile;
        Scanner fileScan;
        textFile = file;

        try
        {
            fileScan = new Scanner(textFile);

            while(fileScan.hasNextLine())
            {
                String line = fileScan.nextLine();

                setLineCount();
                setCharCount(line);
                setCharCountSpaces(line);
                if(line.length() > 0) {
                    setWordCount(line);
                    setLetterCount(line);
                    setWordLengthCount(line);
                    setAverageWordLength(getWordLengthCount());
                }
                else
                {
                    setCharCountSpaces(line); //catches empty lines
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File cannot be located.");
        }

    }

    @Override
    public int getLineCount()
    {
        return lineCount;
    }

    private void setLineCount()
    {
        ++lineCount;
    }

    @Override
    public int getWordCount()
    {
        return wordCount;
    }

    private void setWordCount(String line)
    {
        for(String word : line.trim().split(DELIMITERS))
        {
            if(word.matches("\\w+"))
            {
                ++wordCount;
            }
        }
    }

    @Override
    public int getCharCount()
    {
        return charCount;
    }

    private void setCharCount(String line)
    {
        charCount += line.replaceAll(" ", "").length();
    }

    public int getCharCountSpaces()
    {
        return charCountSpaces;
    }

    private void setCharCountSpaces(String line)
    {
        charCountSpaces += line.length() + 1;
    }

    @Override
    public int[] getLetterCount()
    {
        return letterCount;
    }

    private String getStringLetterCount()
    {
        StringBuilder letterCount = new StringBuilder();
        for(int i = 0; i < this.letterCount.length; ++i)
        {
            char letter = (char)(i + 65);
            letterCount.append("%n").append(letter).append(" Count: ").append(this.letterCount[i]);
        }
        return letterCount.toString();
    }

    private void setLetterCount(String line)
    {
        for(char character : line.toCharArray())
        {
            if(character >= 65 && character <= 90)
            {
                ++letterCount[character - 65];
            }
            else if(character >= 97 && character <= 122)
            {
                ++letterCount[character - 97];
            }
        }
    }

    @Override
    public int[] getWordLengthCount()
    {
        return wordLengthCount;
    }

    private String getStringWordLengthCount()
    {
        StringBuilder wordLengthCount = new StringBuilder();
        for(int i = 0; i < this.wordLengthCount.length; ++i)
        {
            if(i >= 23)
            {
                wordLengthCount.append("%nWords of length ").append(i).append(" or greater count: ").append(this.wordLengthCount[i]);
                continue;
            }
            wordLengthCount.append("%nWords of length ").append(i).append(" count: ").append(this.wordLengthCount[i]);
        }
        return wordLengthCount.toString();
    }

    private void setWordLengthCount(String line)
    {
        for(String word : line.split(DELIMITERS))
        {
            if(word.length() >= 23)
            {
                ++wordLengthCount[23];
            }
            else if(word.length() > 0)
            {
                ++wordLengthCount[word.length()];
            }
        }
    }

    @Override
    public double getAverageWordLength()
    {
        return averageWordLength;
    }

    private void setAverageWordLength(int[] wordLength)
    {
        int total = 0;
        for(int i = 1; i < wordLength.length; ++i)
        {
            total += wordLength[i] * i;
        }
        averageWordLength = total/(double)getWordCount();
    }

    @Override
    public String toString()
    {
        results += "Line Count: " + getLineCount();
        results += "%nWord Count: " + getWordCount();
        results += "%nCharacter Count : " + getCharCountSpaces();
        results += "%nCharacter Count (No Whitespace): " + getCharCount();
        results += getStringLetterCount();
        results += getStringWordLengthCount();
        results += "%nAverage Word Length: " + getAverageWordLength();
        results += "%n";
        return results;
    }
}
