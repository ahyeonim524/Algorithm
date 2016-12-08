import java.util.Scanner;

public class TRIANGLEPATH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			
			int N=in.nextInt();//정삼각형 한 변의 길이
			int[][]grid=new int[N][N];
			for(int a=0;a<N;a++){
				for(int b=0;b<=a;b++){
					grid[a][b]=in.nextInt();
				}
			}
			for(int a=1;a<N;a++){
				for(int b=0;b<=a;b++){
					if(a==1){
						grid[a][b]=grid[0][0]+grid[a][b];
					}
					else{
						if(b==0){
							grid[a][b]=grid[a-1][b]+grid[a][b];
						}
						else if(b==a){
							grid[a][b]=grid[a-1][b-1]+grid[a][b];
						}else{
							grid[a][b]=Math.max(grid[a-1][b-1], grid[a-1][b])+grid[a][b];
						}
					}
				}
			}
			int max=grid[N-1][0];
			for(int j=0;j<N;j++){
				if(max<grid[N-1][j]){
					max=grid[N-1][j];
				}
			}
			System.out.println(max);
		}
	}
}
