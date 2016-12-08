import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Block{
	int x;
	int y;
	int value;
	int originValue;
	int length;
	boolean visited;
	public Block(int x,int y,int originValue){
		this.x=x;
		this.y=y;
		this.originValue=originValue;
		length=0;
		value=0;
		visited=false;
	}
}

public class Problem2146 {
	
	static int[]offsetX={0,-1,0,1};
	static int[]offsetY={-1,0,1,0};
	static int N;
	static int count=0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		N=in.nextInt();
		int[][]grid=new int[N][N];
		Block[][]blocks=new Block[N][N];
		Block startBlock=null;
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				grid[i][j]=in.nextInt();
				blocks[i][j]=new Block(i,j,grid[i][j]);
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(blocks[i][j].originValue==1){
					visit(blocks[i][j],blocks);
				}
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(blocks[i][j].value!=0){
					System.out.println(calculateDist(blocks[i][j],blocks));
				}
			}
		}
		
		
	}
	static void visit(Block startBlock,Block[][]blocks){
		Queue<Block>queue=new LinkedList<Block>();
		count+=1;
		blocks[startBlock.x][startBlock.y].value=count;
		queue.offer(startBlock);
		while(!queue.isEmpty()){
			Block curBlock=queue.poll();
			for(int i=0;i<4;i++){
				if(curBlock.x+offsetX[i]>=0&&curBlock.x+offsetX[i]<N&&curBlock.y+offsetY[i]>=0&&curBlock.y+offsetY[i]<N
						&&blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].originValue==1){
					blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].value=count;
					blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].originValue=0;
					queue.offer(blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]);
				}
			}
		}
	}
	static int calculateDist(Block startBlock,Block[][]blocks){
		//startBlock에서 시작해서 다른 value를 가지는 곳 까지의 거리 반환
		int curValue=startBlock.value;
		int shortest=-1;
		Queue<Block>queue=new LinkedList<Block>();
		queue.offer(startBlock);
		while(!queue.isEmpty()){
			Block curBlock=queue.poll();
			blocks[curBlock.x][curBlock.y].visited=true;
			for(int i=0;i<4;i++){
				if(curBlock.x+offsetX[i]>=0&&curBlock.x+offsetX[i]<N&&curBlock.y+offsetY[i]>=0&&curBlock.y+offsetY[i]<N&&!blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].visited){
					if(blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].value!=0&&blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].value!=curValue){
						if(shortest==-1){
							shortest=blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].length;
							System.out.println("here !!!"+blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].length);
						}
						else if(shortest>blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].length){
							shortest=blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].length;
						}
						
					}
					else{
						blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].length=blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]].length+1;
						queue.offer(blocks[curBlock.x+offsetX[i]][curBlock.y+offsetY[i]]);
					}
				}
			}
		}
		return shortest;
	}
}
