//Shezaad Jiffry 0300129568 A1
import java.util.Iterator;
public class ITIStringBuffer {
    private SinglyLinkedList<char[]> string;//linked list containing all the character arrays
    private Boolean changed;//make sure we dont keep making a new string in tostring if ther is no need
    private String fin;//final string
    private char[] character;//character array
    private int size;//size of the individual strings all in one

    public ITIStringBuffer() {
        string = new SinglyLinkedList<char[]>();
        changed = false;
        fin = "";
        size = 0;
    }

    public ITIStringBuffer(String  firstString){
        string = new SinglyLinkedList<char[]>();
        string.addFirst(firstString.toCharArray());
        changed = true;//if this method is called then the string is changed
        size += firstString.length();//add length to the size to get the final size of all strings
    }

    public void append(String nextString){
        string.add(nextString.toCharArray());
        changed = true;
        size += nextString.length();
    }

    public String toString(){
        if(changed){//pre condition so we dont keep remaking the strings
            int z = 0;
            character = new char[size];
            for(char[] x : string){//better for loop that allows us to access the character arrays
                for(int i = 0; i < x.length; i++){//for loop that accesses the contents within the indivdual character arrays
                    character[z] = x[i];//add single characters into the final character array
                    z++;
                }
            }
            changed = false;//reset
            fin = new String(character);//convert into string before returning
        }
        
        return fin;
    }


}
