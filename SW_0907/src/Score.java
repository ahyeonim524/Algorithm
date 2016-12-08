import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			int[]arr=new int[3];
			for(int j=0;j<3;j++){
				arr[j]=in.nextInt();
			}
			int N=in.nextInt();
			int score=0;
			int maxIdx;
			for(int j=0;j<N;j++){
				if(arr[0]>arr[1]){
					maxIdx=0;
				}
				else{
					maxIdx=1;
				}
				if(arr[maxIdx]<arr[2]){
					maxIdx=2;
				}
				score+=arr[maxIdx];
				if(arr[maxIdx]>=1){
					arr[maxIdx]-=1;
				}
			}
			System.out.println("#testcase"+(i+1));
			System.out.println(score);
			
		}
	}
}
