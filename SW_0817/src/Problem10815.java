import java.util.HashSet;
import java.util.Scanner;

public class Problem10815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		HashSet<Integer>hs=new HashSet<Integer>();
		for(int i=0;i<N;i++){
			hs.add(in.nextInt());
		}
		int M=in.nextInt();
		for(int i=0;i<M;i++){
			int cur=in.nextInt();
			if(hs.contains(cur)){
				hs.remove(cur);
				System.out.print(1+" ");
			}
			else{
				System.out.print(0+" ");
			}
		}
	}
}
