import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	Node leftSon;
	Node rightSon;
	int length;
	int value;
	public Node(int length,int value){
		leftSon=null;
		rightSon=null;
		this.length=length;
		this.value=value;
	}
}
public class Problem1967 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		Node[]tree=new Node[N+1];
		for(int i=1;i<=N;i++){
			tree[i]=new Node(0,i);
		}
		for(int i=0;i<N-1;i++){
			int fir=in.nextInt();
			int sec=in.nextInt();
			int trd=in.nextInt();

			if(tree[fir].leftSon==null){
				tree[fir].leftSon=tree[sec];
				tree[sec].length=trd;
			}
			else{
				tree[fir].rightSon=tree[sec];
				tree[sec].length=trd;
			}
		}
		int first=0;
		int second=-1;
		Queue<Node>queue=new LinkedList<Node>();
		queue.offer(tree[1]);
		while(!queue.isEmpty()){
			Node curNode=queue.poll();
			if(curNode.leftSon!=null){
				tree[curNode.leftSon.value].length+=curNode.length;
				queue.offer(tree[curNode.leftSon.value]);
			}
			if(curNode.rightSon!=null){
				tree[curNode.rightSon.value].length+=curNode.length;
				queue.offer(tree[curNode.rightSon.value]);
			}
			if(curNode.leftSon==null&&curNode.rightSon==null){
				if(curNode.length>first){
					second=first;
					first=curNode.length;
				}
				else if(curNode.length>second){
					second=curNode.length;
				}
			}
		}
		System.out.println(first);
		System.out.println(second);
	}
}
