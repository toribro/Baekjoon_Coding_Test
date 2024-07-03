import java.io.StreamTokenizer;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st =new StreamTokenizer(System.in);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int hour=0,min=0,second=0,count=0;
		String hourCheck=null,minCheck=null,secondCheck=null;
		
		st.nextToken();
		int N=(int)st.nval;
		st.nextToken();
		int k=(int)st.nval;
		int length=((N+1)*60*60);
			
		
	    for(int i=0; i<length; i++) {
	    	second=i%60;
	    	if((i!=0)&&(i%60)==0) {
	    		second=0;
	    		min++;
	    		
	    		if(min%60==0) {
	    			min=min-60;
	    			hour++;
	    		}
	    		
	    	}
	    	
	    	minCheck=String.valueOf(min);
	    	hourCheck=String.valueOf(hour);
	    	secondCheck=String.valueOf(second);
	    	
	    	secondCheck=(secondCheck.length()==1)?"0"+secondCheck:secondCheck;
	    	minCheck=(minCheck.length()==1)?"0"+minCheck:minCheck;
	    	hourCheck=(hourCheck.length()==1)?"0"+hourCheck:hourCheck;
	 
	    	if(secondCheck.contains(String.valueOf(k))
	    	   ||minCheck.contains(String.valueOf(k))
	    	   ||hourCheck.contains(String.valueOf(k))		
	    	 ){
	    		count++;
	    	}
	    }
	   output.write(String.valueOf(count));
	   output.flush();
	   output.close();
		
		
		
	}

}
