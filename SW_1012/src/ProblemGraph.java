import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int dist;
	int column;
	public Node(int dist,int column){
		this.dist=dist;
		this.column=column;
	}
}
public class ProblemGraph {
	static int distSum;
	static int safeSum;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			distSum=0;
			safeSum=0;
			int N=in.nextInt();//정점의 수
			int M=in.nextInt();//간선의 개수
			int K=in.nextInt();//대피소의 개수
			int[][]graph=new int[N+1][N+1];
			boolean[]safeLocation=new boolean[M+1];
			for(int j=0;j<M;j++){
				int first=in.nextInt();
				int second=in.nextInt();
				int weight=in.nextInt();

				graph[first][second]=weight;
				graph[second][first]=weight;
			}
			for(int j=0;j<K;j++){
				safeLocation[in.nextInt()]=true;
			}
			
			for(int j=1;j<=N;j++){
				if(!safeLocation[j]){
					distSum+=calcDist(j,N,graph,safeLocation);
				}
				else{
					safeSum+=j;
				}
			}
			System.out.println("Case #"+(i+1));
			System.out.println(distSum);
			System.out.println(safeSum);
			
			/*
			for(int j=1;j<=N;j++){
				for(int k=1;k<=N;k++){
					System.out.print(graph[j][k]+" ");
				}
				System.out.println();
			}
			*/
		}
	}
	public static int calcDist(int start,int N,int[][]graph,boolean[]safeLocation){
		//start부터 시작해서 대피소를 만날 때 까지 dist 최소값
		int result=-1;
		int safeIdx=-1;
		Queue<Node>queue=new LinkedList<Node>();
		for(int i=1;i<=N;i++){
			if(graph[start][i]!=0){
				Node newNode=new Node(graph[start][i],i);
				queue.offer(newNode);
			}
		}
		while(!queue.isEmpty()){
			Node cur=queue.poll();
			if(safeLocation[cur.column]){
				if(result==-1){
					result=cur.dist;
					safeIdx=cur.column;
				}
				else if(result>cur.dist){
					result=cur.dist;
					safeIdx=cur.column;
				}
			}
			else{
				for(int i=1;i<=N;i++){
					if(graph[cur.column][i]!=0&&i!=start){
						Node newNode=new Node(cur.dist+graph[cur.column][i],i);
						queue.offer(newNode);
					}
				}
			}
		}
		safeSum+=safeIdx;
		return result;
	}
}
