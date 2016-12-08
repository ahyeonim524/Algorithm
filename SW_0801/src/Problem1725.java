import java.util.Scanner;

public class Problem1725 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int minHeight;
		int maxSquare=1;
		int[]histogram=new int[N];
		for(int i=0;i<N;i++){
			histogram[i]=in.nextInt();
		}
		for(int left=0;left<N;left++){
			minHeight=histogram[left];
			for(int right=left;right<N;right++){
				minHeight=Math.min(minHeight,histogram[right]);
				int width=right-left+1;
				maxSquare=Math.max(maxSquare,minHeight*width);
			}
		}
		System.out.println(maxSquare);
	}
}
