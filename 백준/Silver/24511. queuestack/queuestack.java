import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;

		int N = Integer.parseInt(input.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int i = 0;

		String a = input.readLine();
		token = new StringTokenizer(a);

		while (token.hasMoreTokens() || i < N) {
			A[i] = Integer.parseInt(token.nextToken());
			i++;
		}
		i = 0;

		String b = input.readLine();
		token = new StringTokenizer(b);
		while (token.hasMoreTokens() || i < N) {
			B[i] = Integer.parseInt(token.nextToken());
			i++;
		}
		i = 0;

		int m = Integer.parseInt(input.readLine());
		int[] M = new int[m];

		String c = input.readLine();
		token = new StringTokenizer(c);

		while (token.hasMoreTokens() || i < m) {
			M[i] = Integer.parseInt(token.nextToken());
			i++;
		}
		i = 0;

		int count = 0;
		int[] queue = new int[N];

		for (int l = 0; l < N; l++) {
			if (A[l] == 0) {
				count++;// 0 개수
				queue[l] = B[l];
			} else {
				queue[l] = 0;
			}

		}

		int rest = M.length - count;
		int lengthTemp = M.length;
		int zeroCount = count;

		if ((rest) < 0) {
			for (int k = N - 1; k >= 0; k--) {

				if (lengthTemp == 0) {
					break;
				}

				if (queue[k] != 0) {
					if (zeroCount == 0) {
						output.write(queue[k] + "");
					} else {
						output.write(queue[k] + " ");

					}
					zeroCount--;
					lengthTemp--;
				}

			}

		} else {

			for (int k = N - 1; k >= 0; k--) {

				if (queue[k] != 0) {
					if (zeroCount == 0) {
						output.write(queue[k] + "");
					} else {
						output.write(queue[k] + " ");

					}
					zeroCount--;
				}

			}

			for (int k = 0; k < rest; k++) {
				if (k == rest - 1) {
					output.write(M[k] + "");
				} else {
					output.write(M[k] + " ");
				}

			}

		}

		output.flush();

	 }

   }