public class Word
{
    //You can use these static fields to help you with some of the methods below.
    private static final String VOWELS = "AEIOUaeiou"; 
    private static final String PUNC = ";':?,.!-_\"";

    private String theWord;

    //Write the constructor - it should take a parameter String,
    //word, and create a no punctuation lowercase version that it stores in theWord
    //Use the String toLowerCase() method and the stripPunctuation(String) method below.
    public Word(String word)
    {
       theWord = word;
    }

    //Returns theWord.
    public String getWord() {
        return theWord;
        
    }
    
    //Write the stripPunctuation method. It returns a String that is the same as the given String, w, but with
    //all punctuation stripped off the front and back. For example,
    //    stripPunctuation("hi!") returns "hi"
    //    stripPunctuation("'tis") returns "tis"
    private String stripPunctuation(String w)
    {
        String fin = w;
        for (int i = 0; i < PUNC.length(); i ++)
        {
            String curr = PUNC.substring(i, i +1);
            if (w.contains(curr))
                fin = fin.substring(0, i) + fin.substring(i+1);
        }
        return fin;
    }

    //Override the equals method - You know what to do.
    @Override
    public boolean equals(Object other)
    {
        if (other == null || !getClass().equals(other.getClass())) 
            return false;
        Word temp = (Word) other;
        if (temp.getWord().equals(theWord))
            return true;
        return false;
    }

    //Computes and returns the number of vowels in theWord.
    private int vowelCount()
    {
        int count = 0;
        for (int i = 0; i < theWord.length(); i++)
        {
            String curr = theWord.substring(i, i+1);
            if (VOWELS.contains(curr))
            {
                count ++;
            }
        }
        return count;
    }
    //Override the hashCode method (read the lab).
    @Override
    public int hashCode()
    {
        return vowelCount() * stripPunctuation(theWord).length();
    }

    //Override the toString method - it should just return theWord.
    @Override
    public String toString()
    {
        return theWord;
    }
}