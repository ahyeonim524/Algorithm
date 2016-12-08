import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Block{
	int x;
	int y;
	boolean cracked;
	boolean visited;
	int count;
	public Block(int x,int y,int count){
		this.x=x;
		this.y=y;
		cracked=false;
		visited=false;
		this.count=count;
	}
}
public class Problem2206 {
	static int[]offsetX={0,-1,0,1};
	static int[]offsetY={-1,0,1,0};
	static boolean[][]visited;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();
		char[][]grid=new char[N][M];
		visited=new boolean[N][M];
		for(int i=0;i<N;i++){
			String str=in.next();
			for(int j=0;j<M;j++){
				grid[i][j]=str.charAt(j);
			}
		}
		System.out.println(solve(grid,N,M));
		
	}
	static int solve(char[][]grid,int N,int M){
		int min=-1;
		Queue<Block>queue=new LinkedList<Block>();
		Block first=new Block(0,0,1);
		queue.offer(first);
		visited[0][0]=true;
		while(!queue.isEmpty()){
			Block curBlock=queue.poll();
			if(curBlock.x==N-1&&curBlock.y==M-1){
				if(min==-1){
					min=curBlock.count;
				}
				else{
					min=Math.min(min,curBlock.count);
				}
			}

			else if(curBlock.cracked){//이제 벽 뚫으면 안됨
				for(int i=0;i<4;i++){
					if(curBlock.x+offsetX[i]>=0&&curBlock.x+offsetX[i]<N&&curBlock.y+offsetY[i]>=0&&curBlock.y+offsetY[i]<M&&
							!visited[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]&&grid[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]=='0'){//사방의 블럭 중 0을 만났을 때만
						Block newBlock=new Block(curBlock.x+offsetX[i],curBlock.y+offsetY[i],curBlock.count+1);
						newBlock.cracked=true;
						queue.offer(newBlock);
						visited[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]=true;
					}
				}
			}
			else{//아직 블럭 뚫어도 됨
				for(int i=0;i<4;i++){
					if(curBlock.x+offsetX[i]>=0&&curBlock.x+offsetX[i]<N&&curBlock.y+offsetY[i]>=0&&curBlock.y+offsetY[i]<M&&
							!visited[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]&&grid[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]=='0'){
						Block newBlock=new Block(curBlock.x+offsetX[i],curBlock.y+offsetY[i],curBlock.count+1);
						queue.offer(newBlock);
						visited[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]=true;
					}
					else{
						if(curBlock.x+offsetX[i]>=0&&curBlock.x+offsetX[i]<N&&curBlock.y+offsetY[i]>=0&&curBlock.y+offsetY[i]<M&&!visited[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]){
							Block newBlock=new Block(curBlock.x+offsetX[i],curBlock.y+offsetY[i],curBlock.count+1);
							newBlock.cracked=true;
							queue.offer(newBlock);
							visited[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]=true;
						}
					}
				}
			}
		}
		return min;
	}
}
