import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    
    	public static void main(String[]args)throws IOException,NumberFormatException {
		Stack<Integer> stack=new Stack<Integer>();
		
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(input.readLine());
		
		for(int i=0; i<N; i++) {
			
		
			String n=input.readLine();
			StringTokenizer st=new StringTokenizer(n);
			int length=st.countTokens();
			int []arr=new int[length];
			
			if(length>=2) {
				
				int k=0;
				while(st.hasMoreTokens()) {
					arr[k]=Integer.parseInt(st.nextToken());
					k++;
				}
				stack.add(arr[1]);
				
			}else {
				
				int s=Integer.parseInt(n);
				
				switch(s) {
				
				case 2:
					if(!stack.isEmpty()) {
						int a=stack.pop();
						output.write(a+"\n");
					}
					else {
						output.write(-1+"\n");
					}
					break;
				case 3:
					output.write(stack.size()+"\n");
					break;
				case 4:
					if(stack.isEmpty()) {
						output.write(1+"\n");
					}
					else {
						output.write(0+"\n");
					}
					break;
				case 5:
					if(stack.isEmpty()) {
						output.write(-1+"\n");
					}
					else {
						output.write(stack.lastElement()+"\n");
					}
					break;
					
				}
				
			}
			
	    }
		
		output.flush();
		
		output.close();
		input.close();
	}
    
    
}