package project5;

import java.util.ArrayList;
import java.util.Random;

public class Sort {

	
	
public static void Rsort(Integer[] a,int max){                          //Radix Sort Implementation
		
		ArrayList<Integer> [] p=new ArrayList[10];
		
		for(int i=0;i<10;i++){
			
			p[i]=new ArrayList();
		}
		
		int x=1;
		
		while(max>0){
		
		for(int i=0;i<a.length;i++){
			
			p[(a[i]/x)%10].add(a[i]);
			
		}
		int c=0;
		for(ArrayList<Integer> s:p){
			
			
			for(Integer q:s){
				
				a[c++]=q;
			}
			
			s.clear();
			
		}
		
		x=x*10;
		
		max=max-1;
		}
		
	}
	
	
public static void Bsort(Integer[] a, int length){                      //BucketSort Implementation
	
    int arr[]=new int[length];
		
		for(int i=0;i<length;i++){
			
			arr[i]=0;
		}
		
		
		for(int j=0;j<length;j++){
			
			arr[a[j]]++;
			
		}
		
		int c=0;
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i];j++){
			
			
				a[c++]=i;
				
			}
		}
			
		
	}
	
	
	
public static void main(String[] args) {
	// TODO Auto-generated method stub

	
    Random rand = new Random();
	
	Integer [] a= new Integer[100000];
	
	for(int i=0;i<a.length;i++){
		
		a[i]=rand.nextInt(1001);
		
	}
	long start = System.currentTimeMillis( );
	System.out.println(start);
	Rsort(a,4);
	long end = System.currentTimeMillis( );
	System.out.println(end);
	System.out.println( "Radix Sort took "   + 
            ( end - start ) + " "+"ms."+" "+"for Input of 100000" );
	
	
	Integer [] b=new Integer[200000];
	
	
for(int i=0;i<b.length;i++){
		
		b[i]=rand.nextInt(1001);
		
	}
	 start = System.currentTimeMillis( );
	System.out.println(start);
	Rsort(b,4);
	 end = System.currentTimeMillis( );
	System.out.println(end);
	System.out.println( "Radix Sort took "   + 
            ( end - start ) + " "+"ms."+" "+"for Input of 200000" );
	
	
	
	Integer [] c=new Integer[1000000];
	
for(int i=0;i<c.length;i++){
		
		c[i]=rand.nextInt(1001);
		
	}
	 start = System.currentTimeMillis( );
	System.out.println(start);
	Rsort(c,4);
	 end = System.currentTimeMillis( );
	System.out.println(end);
	System.out.println( "Radix Sort took "   + 
            ( end - start ) + " "+"ms."+" "+"for Input of 1000000" );
	
		
	
  Integer [] d= new Integer[100000];
	
	for(int i=0;i<d.length;i++){
		
		d[i]=rand.nextInt(1001);
		
	}
	 start = System.currentTimeMillis( );
	System.out.println(start);
	Bsort(a,1001);
       end = System.currentTimeMillis( );
	System.out.println(end);
	System.out.println( "Bucket Sort took "   + 
            ( end - start ) + " "+"ms."+" "+"for Input of 100000" );
	
	
	Integer [] e=new Integer[200000];
	
	
for(int i=0;i<e.length;i++){
		
		e[i]=rand.nextInt(1001);
		
	}
	 start = System.currentTimeMillis( );
	System.out.println(start);
	Bsort(e,1001);
	 end = System.currentTimeMillis( );
	System.out.println(end);
	System.out.println( "Bucket Sort took "   + 
            ( end - start ) + " "+"ms."+" "+"for Input of 200000" );
	
	
	
	Integer [] f=new Integer[1000000];
	
for(int i=0;i<f.length;i++){
		
		f[i]=rand.nextInt(1001);
		
	}
	 start = System.currentTimeMillis( );
	System.out.println(start);
	Bsort(f,1001);
	 end = System.currentTimeMillis( );
	System.out.println(end);
	System.out.println( "Bucket Sort took "   + 
            ( end - start ) + " "+"ms."+" "+"for Input of 1000000" );
	
	
}
}