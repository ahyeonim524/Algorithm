import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x;
	int y;
	int value;
	public Point(int x,int y,int v){
		this.x=x;
		this.y=y;
		value=v;
	}
}
public class JUMPGAME {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			int N=in.nextInt();
			Point[][]grid=new Point[N][N];
			for(int a=0;a<N;a++){
				for(int b=0;b<N;b++){
					grid[a][b]=new Point(a,b,in.nextInt());
				}
			}
			System.out.println(solve(grid,N));
		}
	}
	static String solve(Point grid[][],int N){
		String result="NO";
		Queue<Point>queue=new LinkedList<Point>();
		queue.offer(grid[0][0]);//제일 처음에 왼쪽 위칸 큐에 넣는다.
		while(!queue.isEmpty()){
			Point current=queue.poll();
			if((current.x==N-1&&current.y==N-1)){
				result="YES";
				break;
			}
			else{//queue에 넣을려고 하는 칸이 grid를 벗어나지 않아야 한다.
				if(isInGrid(current.x+current.value,current.y,N)){
					queue.offer(grid[current.x+current.value][current.y]);
				}
				if(isInGrid(current.x,current.y+current.value,N)){
					queue.offer(grid[current.x][current.y+current.value]);
				}
			}
		}
		return result;
	}
	static boolean isInGrid(int x,int y,int N){
		if(x<N&&x>=0&&y<N&&y>=0){
			return true;
		}
		else{
			return false;
		}
	}
}
