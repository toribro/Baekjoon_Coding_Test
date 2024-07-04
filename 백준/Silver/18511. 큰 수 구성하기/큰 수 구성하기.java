import java.io.StreamTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException {
		StreamTokenizer st =new StreamTokenizer(System.in);
		BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));

		st.nextToken();
		int N=(int)st.nval;
		st.nextToken();
		int k=(int)st.nval;
		
		
	    int[] arrs= new int[k];
	    for(int i=0; i<k; i++) {
	    	st.nextToken();
	    	arrs[i]=(int)st.nval;
	    }

        int result = findMaxNumber(N, arrs, 0);
        System.out.println(result);
	    
	 }
	private static int findMaxNumber(int N,int[]k,int currentNumber) {
		
		if(currentNumber>N) {
			return -1;
		}
		int maxNumber = currentNumber;
        for (int num : k) {
            int nextNumber = findMaxNumber(N, k, currentNumber * 10 + num);
            if (nextNumber <= N && nextNumber > maxNumber) {
                maxNumber = nextNumber;
            }
        }
        return maxNumber;
	}
	

}
