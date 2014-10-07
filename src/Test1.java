import java.util.LinkedList;
import java.util.TreeSet;

//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Collection;
//
//
//public class Test1 {
//
//	interface Perishable{
//		
//	}
//	
//	class InventoryItem{
//		
//	}
//	
//	abstract class Produce extends InventoryItem implements Perishable{
//		
//	}
//	
//	static<T> void someMethod(Collection<T> c){
//		
//	}
//	class fruit extends Produce{
//		
//	}
//	
//	public Test1(){
//		try{
//			
//		}catch(IOException e){
//			
//		}
//		catch(FileNotFoundException o){
//			
//		}
//	}
//}

public class Test1 {
	public Test1() {
		TreeSet a = new TreeSet();
		a.add(1);
		a.add(2);
		LinkedList b = new LinkedList();
		b.add(a);
		System.out.print(b);
	}

	public static void main(String[] args) {
		new Test1();
	}
}
