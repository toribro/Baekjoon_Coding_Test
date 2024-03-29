import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException,NumberFormatException {
		
	    Queue<Integer> queue=new LinkedList<Integer>();
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(input.readLine());
	
	
		for(int k=0; k<N; k++) {
			String s=input.readLine();
			StringTokenizer token=new StringTokenizer(s);
			int lenght=token.countTokens();
			
			if(lenght>=2) {
				
				String[] temp=new String[lenght];
				
				int i=0;
			    while(token.hasMoreTokens()) {
					
				    temp[i]=token.nextToken();
				    i++;
				}
			 
				int element=Integer.parseInt(temp[lenght-1]);
				queue.offer(element);
		
				
			}
			else {
				
				if(s.equals("pop")) {
					
					
					if(queue.isEmpty()) {
						 output.write(-1+"\n");
					}else {
						 output.write(queue.remove()+"\n");
						
					}
					
				
				}else if(s.equals("size")) {
					 output.write(queue.size()+"\n");
						
					
				}else if(s.equals("empty")) {
					if(queue.isEmpty()) {
						 output.write(1+"\n");
					}
					else {
						output.write(0+"\n");
					}
					
				}else if(s.equals("front")) {
					
					if(queue.isEmpty()) {
						 output.write(-1+"\n");
					}
					else {
						output.write(queue.peek()+"\n");
					}
				
					
				}else if(s.equals("back")) {
                   if(queue.isEmpty()) {
						 output.write(-1+"\n");
					}else {
						 LinkedList<Integer> lastelement=((LinkedList<Integer>) queue);
						 output.write(lastelement.getLast()+"\n");
					}
					
				}
				
			}
		
				
		}
		
		
		output.flush();
	
	}
    
    
    
    
}