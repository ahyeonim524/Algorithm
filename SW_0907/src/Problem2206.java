import java.util.Arrays;
import java.util.Scanner;

class Map{
	char[][]grid;
	public Map(){
		grid=null;
	}
}

public class Problem2206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();
		int idx=0;
		char[][]standardGrid=new char[N][M];
		char[][]temp=new char[N][M];
		Map[]maps=new Map[N*M];
		for(int i=0;i<N;i++){
			String str=in.next();
			for(int j=0;j<M;j++){
				standardGrid[i][j]=str.charAt(j);
			}
		}
		
		for(int a=0;a<N;a++){
			for(int b=0;b<M;b++){
				temp[a][b]=standardGrid[a][b];
			}
		}
		
		maps[idx]=new Map();
		maps[idx].grid=temp;
		idx+=1;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(standardGrid[i][j]=='1'){
					
					for(int a=0;a<N;a++){
						for(int b=0;b<M;b++){
							temp[a][b]=standardGrid[a][b];
						}
					}
					
					
					maps[idx]=new Map();
					maps[idx].grid=temp;
					maps[idx].grid[i][j]='0';
				
					idx+=1;
				}
			}
		}
		
		for(int i=0;i<idx;i++){
			for(int a=0;a<N;a++){
				for(int b=0;b<M;b++){
					System.out.print(maps[i].grid[a][b]+" ");
				}
				System.out.println();
			}
			System.out.println("-----------------------");
		}
		
	}
}
