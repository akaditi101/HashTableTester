public class WordTester
{
    public static void main(String[] args)
    {
        Word one = new Word("45alligator");
        System.out.println(one + " the hash code is " + one.hashCode());        //should out 44
        
        Word two = new Word("cat");
        System.out.println(two + " the hash code is " + two.hashCode());        //should out 3
        
        Word three = new Word("whootit");
        System.out.println(three + " the hash code is " + three.hashCode());    //should out 21        
      
        //make duplicate words - test to see if they are equal and have the same hashCode
        Word four = new Word("45alligator");
        System.out.println(four + " the hash code is " + four.hashCode());        //should out 44
        
        System.out.println(one.equals(four));
    }
}