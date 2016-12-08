import java.util.Arrays;
import java.util.Scanner;

public class Problem11399 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int sum=0;
		int result=0;
		int[]arr=new int[N];
		for(int i=0;i<N;i++){
			arr[i]=in.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++){
			sum+=arr[i];
			arr[i]=sum;
			result+=arr[i];
		}
		System.out.println(result);
	}
}
