import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer>place=new Stack<Integer>();
		Stack<Integer>goal=new Stack<Integer>();
		
		
		int N=Integer.parseInt(input.readLine());
		int order=1;
		String orders=input.readLine();
	    StringTokenizer token=new StringTokenizer(orders);
			
	    int i=0;
	    while(token.hasMoreTokens()||i<N) {
	    	
	    	int a=Integer.parseInt(token.nextToken());
	    	place.add(a);
	    	
	    	while(!place.empty()) {
	    		if(place.lastElement()==order) {
	    			
		    		int b=place.pop();
		    		goal.add(b);
		    		order++;
	    		 }
	    		else {
	    			break;
	    		}
	    	 }
	        i++;	
	    } 	
	    
	    if(place.isEmpty()) {
	    	 output.write("Nice");
	    }
	    else {
	    	output.write("Sad");
	    }
	    output.flush();
	    
		
	}

}
    
    
    
