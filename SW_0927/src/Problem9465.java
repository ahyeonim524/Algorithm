import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node{
	int location;
	int num;
	int sum;
	int idx;
	public Node(int loc,int num,int idx){
		location=loc;
		this.num=num;
		this.idx=idx;
		sum=0;
	}
}

public class Problem9465 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			int N=in.nextInt();
			int result=0;
			int[][]arr=new int[2][N];

			for(int a=0;a<=1;a++){
				for(int b=0;b<N;b++){
					arr[a][b]=in.nextInt();
				}
			}

			Node first=new Node(0,0,0);//�ƹ��͵� ���� ����
			Node second=new Node(1,arr[0][0],0);//�� �͸� ����
			second.sum=second.num;
			Node third=new Node(2,arr[1][0],0);//�Ʒ� �͸� ����
			third.sum=third.num;

			Queue<Node>queue=new LinkedList<Node>();
			queue.offer(first);
			queue.offer(second);
			queue.offer(third);

			while(!queue.isEmpty()){
				Node curPeek=queue.peek();
				if(curPeek.idx==N-1){
					break;
				}
				else{
					Node curNode=queue.poll();
					if(curNode.location==0){//���� ���� '�ƹ��͵� ���� ����'
						//��
						Node newNode=new Node(1,arr[0][curNode.idx+1],curNode.idx+1);
						newNode.sum=curNode.sum+newNode.num;
						queue.offer(newNode);
						//�Ʒ�
						newNode=new Node(2,arr[1][curNode.idx+1],curNode.idx+1);
						newNode.sum=curNode.sum+newNode.num;
						queue.offer(newNode);
					}
					else if(curNode.location==1){//���� ���� '��'
						//�Ʒ�
						Node newNode=new Node(2,arr[1][curNode.idx+1],curNode.idx+1);
						newNode.sum=curNode.sum+newNode.num;
						queue.offer(newNode);
						//���� ����
						newNode=new Node(0,0,curNode.idx+1);
						newNode.sum=curNode.sum+newNode.num;
						queue.offer(newNode);
					}
					else{//���� ���� '�Ʒ�'
						//��
						Node newNode=new Node(1,arr[0][curNode.idx+1],curNode.idx+1);
						newNode.sum=curNode.sum+newNode.num;
						queue.offer(newNode);
						//���� ����
						newNode=new Node(0,0,curNode.idx+1);
						newNode.sum=curNode.sum+newNode.num;
						queue.offer(newNode);
					}
				}
			}
			while(!queue.isEmpty()){
				result=Math.max(result,queue.poll().sum);
			}
			System.out.println(result);
		}
	}
}
