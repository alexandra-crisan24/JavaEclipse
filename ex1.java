import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ex1 {
//Sort a given array list
	public static void main(String[] args) {
	LinkedList <String> str = new LinkedList<>(); 
	str.add("Red"); 
	str.add("Green"); 
	str.add("Orange"); 
	str.add("White"); 
	str.add("Black"); 
	Iterator <String> it = str.iterator();
 Collections.shuffle(str);
 System.out.println(str);
 String x = str.peekFirst(); 
 System.out.println(" the last el is : "+x); 
 System.out.println("Original linked list" +str);
	}
	
}
