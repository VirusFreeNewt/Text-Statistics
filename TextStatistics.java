//package textstatistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 *
 * @author VirusFreeNewt
 */
//TODO: implement the TextStatisticsInterface
public class TextStatistics implements TextStatisticsInterface
{

    //Declare additional variables here
    private File textFile;
    private Scanner fileScan;
    //Be mindful of these when counting the words and their lengths
    //They should not be included as words or counted in the length of the word
    private final String DELIMITERS = "\\W+";
    private int lineCount, wordCount, charCount, letterCount[] = new int[26], wordLengthCount[] = new int[24];
    private double averageWordLength;
    private String results = "";

    public TextStatistics(File file)
    {

        textFile = file;

        try
        {
            fileScan = new Scanner(textFile);

            while(fileScan.hasNextLine())
            {
                String line = fileScan.nextLine();

                setLineCount();
                if(line.length() > 0) {
                    setWordCount(line);
                    setCharCount(line);
                    setLetterCount(line);
                    setWordLengthCount(line);
                    setAverageWordLength(getWordLengthCount());
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
        lineCount++;
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
            wordCount++;
            System.out.println(word);
        }
    }

    @Override
    public int getCharCount()
    {
        return charCount;
    }

    private void setCharCount(String line)
    {
        for(String character : line.split(""))
        {
            charCount++;
        }
    }

    @Override
    public int[] getLetterCount()
    {
        return letterCount;
    }

    public String getStringLetterCount()
    {
        String letterCount = "";
        for(int i = 0; i < this.letterCount.length; ++i)
        {
            char letter = (char)(i + 65);
            letterCount += "%n" + letter + " Count: " + this.letterCount[i];
        }
        return letterCount;
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

    public String getStringWordLengthCount()
    {
        String wordLengthCount = "";
        for(int i = 0; i < this.wordLengthCount.length; ++i)
        {
            if(i >= 23)
            {
                wordLengthCount += "%nWords of length " + i + " or greater count: " + this.wordLengthCount[i];
                continue;
            }
            wordLengthCount += "%nWords of length " + i + " count: " + this.wordLengthCount[i];
        }
        return wordLengthCount;
    }

    private void setWordLengthCount(String line)
    {
        for(String word : line.split(DELIMITERS))
        {
            if(word.length() >= 23)
            {
                ++wordLengthCount[23];
                continue;
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
        averageWordLength = total/getWordCount();
    }
    //TODO: Complete the toString method which prints out the results
    @Override
    public String toString()
    {
        results += "Line Count: " + getLineCount();
        results += "%nWord Count: " + getWordCount();
        results += "%nCharacter Count: " + getCharCount();
        results += getStringLetterCount();
        results += getStringWordLengthCount();
        results += "%nAverage Word Length: " + getAverageWordLength();
        results += "%n";
        return results;
    }

}
