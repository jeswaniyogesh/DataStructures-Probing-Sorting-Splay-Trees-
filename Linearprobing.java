package project4;

public class Linearprobing<AnyType> {

	public Linearprobing(){
		this(Default_size);
	}
	
	public Linearprobing(long size){
		
		allocatearray(size);
		doclear();
	}
	
	
	public Hashentry<String>[] val(){
		return array;
	}
	
	public boolean insert(String k){
		
		long currentpos=findpos(k);
		
		if(isActive(currentpos)){
			return false;
		}
		
		array[(int) currentpos]=new Hashentry<String>(k,true);
		
		if(++occupied>array.length/2){
			rehash();
		}
		
		return true;
	}
	
	
	
	private void rehash(){
		
		Hashentry<String> [] oldarray= array;
		
		allocatearray(2*oldarray.length);
		occupied=0;
		thesize=0;
		
		for(Hashentry<String> entry: oldarray)
			if(entry!=null && entry.isActive)
				insert(entry.element);
	}
	
	
	private long findpos(String x){
		
		
		long offset=1;
		
		long currentpos=myhash(x);
		
		try{
		
		while(array[(int) currentpos]!=null && !array[(int) currentpos].element.equals(x)){
			
			currentpos+=offset;
			if(currentpos>=array.length){
				currentpos-=array.length;
			}
		}
		
		}catch(Exception e){
			
		}
		return currentpos;
		
		
	}
	
	public boolean contains(String x){
		
		long currentpos= findpos(x);
		return isActive(currentpos);
	}
	
	
	private boolean isActive(long currentpos){
		
	
		if ((array[(int) currentpos]!=null) && (array[(int) currentpos].isActive)){

		return true;
		
		}else
			return false;
		
	
	}
	
		private void doclear(){
		occupied=0;
		for(int i=0;i<array.length;i++)
			array[i]=null;
	}
	
	
	private long myhash( String x )
    {
        long hashVal = x.hashCode( );

        hashVal %= array.length;
        if( hashVal < 0 )
            hashVal += array.length;

        return hashVal;
    }
	
	
	@SuppressWarnings("hiding")
	public static class Hashentry<String>{
		
		public String element;
		public boolean isActive;
		
		
		public Hashentry(String e){
			this(e,true);
		}
		
		public Hashentry(String e, boolean i){
			
			element=e;
			isActive=i;
		}
	}
	
	private static final long Default_size=101;
	
	private  Hashentry<String> [] array;
	private long occupied;
	private long thesize;
	
	
	
	private void allocatearray(long arraysize){
		
		array=new Hashentry[(int) nextPrime(arraysize)];
	}
	
	
	 private static long nextPrime( long n )
	    {
	        if( n % 2 == 0 )
	            n++;

	        for( ; !isPrime( n ); n += 2 )
	            ;

	        return n;
	    }
	 
	 
	 
	 private static boolean isPrime( long n )
	    {
	        if( n == 2 || n == 3 )
	            return true;

	        if( n == 1 || n % 2 == 0 )
	            return false;

	        for( int i = 3; i * i <= n; i += 2 )
	            if( n % i == 0 )
	                return false;

	        return true;
	    }
	 
	 public void display(){
		 System.out.println(array.length);
	 }
	
}



