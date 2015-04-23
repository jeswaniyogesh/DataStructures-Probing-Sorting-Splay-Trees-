package project3;

public class splaymain {

	public static void main(String[] args) {
		
		//******  Inserted random 10 elements in the splay tree ******//
		
		splay1 s= new splay1();
		
	
		s.add(10);
		s.add(14);
		s.add(18);
		s.add(15);
		System.out.println(s.add(12));  
		System.out.println(s.add(20));
		System.out.println(s.add(31));
		System.out.println(s.add(2));
		System.out.println(s.add(16)) ; 
		System.out.println(s.add(50));        //**** New root is 50***//
		
		System.out.println(s.find(31));      // ****return true if found and new root will be 31
		
		s.printlevels();                     //***** This will Print the Tree*****//
		
		System.out.println();
		System.out.println("The Leaf count of Splay Tree is "+" "+s.leafCount());                     //**** This will give us the Leaf Count //
		
		System.out.println(s.toString());     //**** This will print the splay tree in order//
		
		System.out.println("The Tree Sum of Splay Tree is"+" "+ s.treeSum());                     //***** This will give us the Tree Sum****//
		
		}

}
