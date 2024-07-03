import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args)throws IOException {
		StreamTokenizer st =new StreamTokenizer(System.in);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum,max=0;
		
		st.nextToken();
		int N=(int)st.nval;
		st.nextToken();
		int M=(int)st.nval;
		
		int [] arr =new int[N];
		for(int i=0; i<N; i++) {
			st.nextToken();
			arr[i]=(int)st.nval;
		}
		
		
		for(int i=0; i<N; i++) {
			for(int k=i+1; k<N; k++) {
				for(int o=k+1; o<N; o++) {
					sum=arr[i]+arr[k]+arr[o];
					if(sum>max&&sum<=M) {
						max=sum;
					}
				}
			}
		}
		output.write(String.valueOf(max));
		output.flush();
		output.close();
	}

}
