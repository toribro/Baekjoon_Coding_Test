import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	private static char [][]binaryTree;
	private static BufferedReader input;
	private static BufferedWriter output;
	private static StringTokenizer st=null;

	public static void main(String[] args)throws IOException {
		input =new BufferedReader(new InputStreamReader(System.in));
	    output=new BufferedWriter(new OutputStreamWriter(System.out));
		
		st=new StringTokenizer(input.readLine());
		int N=Integer.parseInt(st.nextToken());
		
		binaryTree=new char[N][3];
		int length=binaryTree.length;
		
		for(int i=0; i<length; i++) {
			st=new StringTokenizer(input.readLine());
			char parent=st.nextToken().charAt(0);
			char leftChild=st.nextToken().charAt(0);
			char rightChild=st.nextToken().charAt(0);
			
			binaryTree[i][0]=parent;
			binaryTree[i][1]=leftChild;
			binaryTree[i][2]=rightChild;
		}
		
		
		preOrder('A');
		output.newLine();
		inOrder('A');
		output.newLine();
		postOrder('A');
		
		output.flush();
		output.close();
	}
	
	private static void preOrder(char node) throws IOException {
		if(node=='.')return;
		output.write(node+"");
		int index=findIndex(node);
		preOrder(binaryTree[index][1]);
		preOrder(binaryTree[index][2]);
		
	}
	private static void inOrder(char node)throws IOException {
		if(node=='.')return;
		int index=findIndex(node);
		inOrder(binaryTree[index][1]);
		output.write(node+"");
		inOrder(binaryTree[index][2]);
	}
	private static void postOrder(char node)throws IOException {
		if(node=='.')return;
		int index=findIndex(node);
		postOrder(binaryTree[index][1]);
		postOrder(binaryTree[index][2]);
		output.write(node+"");
	}
	private static int findIndex(char node) {
		
		for(int i=0; i<binaryTree.length; i++) {
			if(binaryTree[i][0]==node) {
				return i;
			}
		}
		return -1;
	}

}
