import java.util.Scanner;

class Node{
	char value;
	Node next;
	public Node(char v){
		value=v;
		next=null;
	}
}
public class Problem9935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String str=in.next();
		String target=in.next();
		int N=str.length();
		Node[]nodes=new Node[str.length()];
		for(int i=0;i<N;i++){
			nodes[i]=new Node(str.charAt(i));
			if(i!=0){
				nodes[i-1].next=nodes[i];
			}
		}
		
		int pointer=0;
		while(pointer<=N-target.length()){
			if(nodes[pointer].value==target.charAt(0)){
				if(check(nodes,target,pointer)){
					nodes[pointer-1].next=nodes[pointer+target.length()];
					pointer-=4;
				}
			}
			else{
				pointer++;
			}
		}
		print(nodes);
	}
	static boolean check(Node[]nodes,String target,int index){
		for(int i=index;i<index+target.length();i++){
			if(nodes[i].value!=target.charAt(i)){
				return false;
			}
		}
		return true;
	}
	static void print(Node[]nodes){
		int i=0;
		while(nodes[i].next!=null){
			System.out.print(nodes[i].value+" ");
		}
	}
}
