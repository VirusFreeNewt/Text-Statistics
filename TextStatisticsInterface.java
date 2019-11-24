/**
 * Interface to get statistics from a text file. Used in the testing program.
 *
 * @author CS121 Instructors
 */
public interface TextStatisticsInterface
{

    /**
     * @return the number of characters in the text file
     */
    int getCharCount();

    /**
     * @return the number of words in the text file
     */
    int getWordCount();

    /**
     * @return the number of lines in the text file
     */
    int getLineCount();

    /**
     * @return the letterCount array with locations [0]..[25] for 'a' through
     * 'z'
     */
    int[] getLetterCount();

    /**
     * @return the wordLengthCount array with locations [0]..[23] with location
     * [i] storing the number of words of length i in the text file. Location
     * [0] is not used. Location [23] holds the count of words of length 23 and
     * higher.
     */
    int[] getWordLengthCount();

    /**
     * @return the average word length in the text file
     */
    double getAverageWordLength();
}
