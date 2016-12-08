import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Rectangle{
	int x1,y1,x2,y2;
	public Rectangle(int x1,int y1,int x2,int y2){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}
}
public class Problem3108 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Queue<Rectangle>outerQ=new LinkedList<Rectangle>();
		Queue<Rectangle>innerQ=new LinkedList<Rectangle>();
		int N=in.nextInt();
		int result=0;
		boolean decided=false;
		Rectangle startPoint=null;
		Rectangle[]rt=new Rectangle[N];
		for(int i=0;i<N;i++){
			rt[i]=new Rectangle(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
			if(!decided&&rt[i].x1==0&&rt[i].y1==0||rt[i].x2==0&&rt[i].y2==0){
				startPoint=new Rectangle(rt[i].x1,rt[i].y1,rt[i].x2,rt[i].y2);
				decided=true;
			}
			else{
				outerQ.offer(rt[i]);
			}
		}
		
		while(!outerQ.isEmpty()){
			if(startPoint==null){
				Rectangle first=outerQ.poll();
				startPoint=new Rectangle(first.x1,first.y1,first.x2,first.y2);
				result++;//�ѹ� �̵� �ʿ���
			}
			//���⼭ startPoint�� ������(queue���� firstPoint�� ��������)
			innerQ.offer(startPoint);
			extract(outerQ,innerQ);
			//�̰� �������� ����� �Ŵ� �� ã�Ҵ� !
			startPoint=null;
			
			
		}
	}
	static void extract(Queue<Rectangle> outerQ,Queue<Rectangle> innerQ){
		//innerQ���� start�� �����ϴ� ��� ����� �簢�� outerQ���� �������Ѵ�.
		while(!innerQ.isEmpty()){
			Rectangle start=innerQ.poll();
			for(int i=0;i<outerQ.size();i++){
				
			}
		}
	}
	static boolean check(Rectangle a,Rectangle b){
		
	}
}
