import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int x;
	int y;
	int length;
	boolean breaked;

	public Node(int x,int y){
		this.x=x;
		this.y=y;
		length=1;
		breaked=false;
	}
}
public class Problem2206 {

	static int[]offsetX={0,-1,0,1};
	static int[]offsetY={-1,0,1,0};
	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();
		int result=-1;
		char[][]grid=new char[N][M];
		boolean[][][]visited=new boolean[N][M][2];
		for(int i=0;i<N;i++){
			String str=in.next();
			for(int j=0;j<M;j++){
				grid[i][j]=str.charAt(j);
			}
		}

		Queue<Node>queue=new LinkedList<Node>();
		Node first=new Node(0,0);
		queue.offer(first);
		visited[0][0][0]=true;
		visited[0][0][1]=true;
		while(!queue.isEmpty()){
			
			Node cur=queue.poll();

			if(cur.x==N-1&&cur.y==M-1){
				if(result==-1){
					result=cur.length;
				}
				else{
					result=Math.min(result, cur.length);
				}
			}

			//寒 何荐绰芭..............代代代代代
			else{
				for(int i=0;i<4;i++){
					
					if(cur.x+offsetX[i]>=0&&cur.x+offsetX[i]<N&&cur.y+offsetY[i]>=0&&cur.y+offsetY[i]<M){
						if(grid[cur.x+offsetX[i]][cur.y+offsetY[i]]=='0'){//0牢 版快
							visited[cur.x][cur.y][0]=true;
							Node newNode=new Node(cur.x+offsetX[i],cur.y+offsetY[i]);
							newNode.length=cur.length+1;
							newNode.breaked=cur.breaked;
							queue.offer(newNode);
						}
						else if(!cur.breaked){//1牢版快 , 寒 何贱 荐 乐绰 版快
							visited[cur.x][cur.y][1]=true;
							cur.breaked=true;
							Node newNode=new Node(cur.x+offsetX[i],cur.y+offsetY[i]);
							newNode.length=cur.length+1;
							newNode.breaked=cur.breaked;
							queue.offer(newNode);
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
