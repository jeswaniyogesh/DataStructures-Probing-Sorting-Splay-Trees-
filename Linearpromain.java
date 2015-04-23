package project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import project4.Linearprobing.Hashentry;






public class Linearpromain {
	
	
	private static  boolean oneCharOff( String word1, String word2 )       //Will give us the characters having a difference of one character
	{
		
	        if( word1.length( ) != word2.length( ) )
	            return false;

	        int diffs = 0;

	        for( int i = 0; i < word1.length( ); i++ )
	            if( word1.charAt( i ) != word2.charAt( i ) )
	                if( ++diffs > 1 )
	                    return false;

	        return diffs == 1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Linearprobing l=new Linearprobing();

		FileReader fin = new FileReader( "C:/Users/jeswaniyogesh/Desktop/dict.txt" );    //Load a dictionary into Hash table
        BufferedReader bin = new BufferedReader( fin );
        
        String oneline;
		
        while( ( oneline = bin.readLine( ) ) != null ){
          	
          	l.insert(oneline);
        
        }
        
        
        Scanner fin1=new Scanner(new File("C:/Users/jeswaniyogesh/Desktop/nosilverbulletDoc.txt"));  //scan a document
        
        List<String> Docwords= new ArrayList<>();
        
        while(fin1.hasNextLine()){
        	String line=fin1.nextLine();
        	String lines=line.replaceAll("[-]"," ");
        	
        	Scanner sc=new Scanner(lines);
        	sc.useDelimiter(" ");
        	
        	while(sc.hasNext()){
        		
        		String s=sc.next();
        		
	        	if(s.contains(",")|| s.contains(".")|| s.contains(";")){
	        		
	        		Docwords.add(s.substring(0, s.length()-1).toLowerCase());
	        		
	        	}else
        		Docwords.add(s.toLowerCase());
        		
        	}
        	
        	sc.close();
        }
        
        fin1.close();
        
       
          List<String> missing=new ArrayList();
          
          List<String> nospace=new ArrayList<String>();
          
          for(String p:Docwords){
	        	if (p.isEmpty()){
	        		;
	        	}else
	        		nospace.add(p);
	        }
        
        Hashentry<String> array[]=l.val();
        
        for(String s: nospace){
        	if(!l.contains(s)){
        		missing.add(s);
        	}
        }
        
        
        
        List<String> alternates=new ArrayList<String>();
        
       
           for(String miss: missing){
        	System.out.println(miss+"    "+  "is mis-spelled");
        	
        	    for(int i=0;i<array.length;i++){
        		    if(array[i]!=null){
        		        if(oneCharOff(miss,array[i].element)){
        			            alternates.add(array[i].element);
        		}
        		}
        	}
        	
        	System.out.println("Alternative words are");
        	System.out.println();
        	
        	for(String word: alternates){
        		System.out.println(word+" ");
        	}
        	System.out.println("\n");
        	alternates.clear();
        }
        }
        
	}
        
    
        
	
	


        
        
        
	
	




