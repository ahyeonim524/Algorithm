import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int num;
	int count;
	public Node(int num){
		this.num=num;
		count=0;
	}
}

public class Problem1463 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Queue<Node>queue=new LinkedList<Node>();
		int X=in.nextInt();
		int result=-1;
		Node first=new Node(X);
		queue.offer(first);
		while(!queue.isEmpty()){
			Node cur=queue.poll();
			if(cur.num==1){
				if(result==-1){
					result=cur.count;
				}
				else if(result>cur.count){
					result=cur.count;
				}
			}

			if(cur.num%2==0){
				Node newNode=new Node(cur.num/2);
				newNode.count=cur.count+1;
				queue.offer(newNode);
			}
			if(cur.num%3==0){
				Node newNode=new Node(cur.num/3);
				newNode.count=cur.count+1;
				queue.offer(newNode);
			}
			if(cur.num>=2){
				Node newNode=new Node(cur.num-1);
				newNode.count=cur.count+1;
				queue.offer(newNode);
			}
		}
		System.out.println(result);
	}
}
