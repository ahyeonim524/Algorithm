import java.util.Scanner;

public class Problem9465Revised {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			int N=in.nextInt();
			int[][]arr=new int[2][N];
			
			// 읽으면서 처리할 수 없음 !!
			for(int a=0;a<=1;a++){
				for(int b=0;b<N;b++){
					if(b==0){
					arr[a][b]=in.nextInt();
					}
				}
			}
			// 초기 값 채워넣기
			arr[0][1]+=arr[1][0];
			arr[1][1]+=arr[0][0];
			
			System.out.println(arr[0][1]);
			System.out.println(arr[1][1]);
			System.out.println("------");
			
			for(int j=2;j<N;j++){
				int temp=Math.max(arr[1][j-1]+arr[0][j],arr[1][j-2]+arr[0][j]);
				arr[0][j]=Math.max(temp,arr[0][j-1]);
				System.out.println(temp);
				
				temp=Math.max(arr[0][j-1]+arr[1][j],arr[0][j-2]+arr[1][j]);
				arr[1][j]=Math.max(temp, arr[1][j-1]);
				System.out.println(temp);
			}
			System.out.println(Math.max(arr[0][N-1], arr[1][N-1]));
		}
	}
}
