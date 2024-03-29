import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class CustomStack{
	private int index;
	public CustomStack() {
		this.index=-1;
	
	}
	
	public  void add() {
	     this.index++;
	  
	    
	}
	public void delete() {
		this.index--;
	}
	
	public boolean isEmpty() {
		
		return this.index==-1;
		
	}
}

public class Main{
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
		CustomStack stack=null;
		
		int N=Integer.parseInt(input.readLine());
		
		for (int i =0; i<N; i++) {
			String word=input.readLine();
			stack=new CustomStack();
			for(int k=0; k<word.length(); k++) {
				
				if(word.charAt(k)=='(') {
					stack.add();
				}
				
				if(word.charAt(k)==')') {
					if(!stack.isEmpty()) {
					   stack.delete();
					}
					else {
						stack.add();
						break;
					}
				}
				
			}
			
			if(stack.isEmpty()) {
				output.write("YES"+"\n");
			}else {
				output.write("NO"+"\n");
			}
			
			stack=null;
			
		}
		output.flush();
		
	}
	
}