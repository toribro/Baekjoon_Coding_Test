import java.io.StreamTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st =new StreamTokenizer(System.in);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int x=0,y=0;
		int[] arrs = new int[6];
		for(int i=0; i<6; i++) {
			st.nextToken();
		    arrs[i]=(int)st.nval;
		}
		x=(arrs[5]*arrs[1]-arrs[2]*arrs[4])/(arrs[3]*arrs[1]-arrs[0]*arrs[4]);
		y=(arrs[2]*arrs[3]-arrs[0]*arrs[5])/(arrs[3]*arrs[1]-arrs[0]*arrs[4]);
		
		output.write(String.valueOf(x));
		output.write(" ");
		output.write(String.valueOf(y));
		output.flush();
		output.close();

	}

}
