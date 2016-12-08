import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Grid{
	int x;
	int y;
	int length;
	char value;
	boolean visited;

	public Grid(int x,int y,char value){
		this.x=x;
		this.y=y;
		this.value=value;
		length=0;
		visited=false;
	}
}

public class Problem2178 {

	static int[]offsetX={0,-1,0,1};
	static int[]offsetY={-1,0,1,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();
		Grid grid[][]=new Grid[N][M];
		for(int i=0;i<N;i++){
			String str=in.next();
			for(int j=0;j<M;j++){
				grid[i][j]=new Grid(i,j,str.charAt(j));
			}
		}
		//print(N,M,grid);
		solve(N,M,grid);
	}
	static void solve(int N,int M,Grid[][]grid){
		Queue<Grid>queue=new LinkedList<Grid>();
		queue.offer(grid[0][0]);

		while(!queue.isEmpty()){
			Grid curGrid=queue.poll();
			System.out.println("length : "+curGrid.length);
			if(curGrid.x==N-1&&curGrid.y==M-1){
				System.out.println(curGrid.length);
				break;
			}
			else{
				for(int i=0;i<4;i++){

					if(curGrid.x+offsetX[i]>=0&&curGrid.x+offsetX[i]<N&&curGrid.y+offsetY[i]>=0&&curGrid.y+offsetY[i]<M){
						if(!grid[curGrid.x+offsetX[i]][curGrid.y+offsetY[i]].visited&&grid[curGrid.x+offsetX[i]][curGrid.y+offsetY[i]].value=='1'){
							grid[curGrid.x+offsetX[i]][curGrid.y+offsetY[i]].length=curGrid.length+1;
							grid[curGrid.x+offsetX[i]][curGrid.y+offsetY[i]].visited=true;
							queue.offer(grid[curGrid.x+offsetX[i]][curGrid.y+offsetY[i]]);
							System.out.println("curGrid "+curGrid.x+" , "+curGrid.y);
							
						}
					}
				}
			}
		}
	}
	static void print(int N,int M,Grid[][]grid){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(grid[i][j].value+" ");
			}
			System.out.println();
		}
	}
}
