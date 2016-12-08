import java.util.Scanner;

public class FreeLancer {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		int N;
		int[][]arr;
		int[]dp;
		for(int i=0;i<T;i++){
			N=in.nextInt();
			arr=new int[2][N];
			dp=new int[N];
			for(int a=0;a<2;a++){
				for(int b=0;b<N;b++){
					arr[a][b]=in.nextInt();
				}
			}
			dp[0]=Math.max(arr[0][0], arr[1][0]);
			dp[1]=Math.max(dp[0]+arr[0][1], arr[1][1]);
			
			for(int j=2;j<N;j++){
				dp[j]=Math.max(dp[j-1]+arr[0][j], dp[j-2]+arr[1][j]);
			}
			System.out.println("Case #"+(i+1));
			System.out.println(dp[N-1]);
		}
	}
}
