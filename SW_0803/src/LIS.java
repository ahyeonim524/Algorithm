import java.util.Scanner;
import java.util.Vector;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			int N=in.nextInt();
			Vector<Integer> A=new Vector<Integer>();
			for(int j=0;j<N;j++){
				A.add(in.nextInt());
			}
			System.out.println(solve(A));
		}
	}
	static int solve(Vector A){
		if(A.isEmpty()){
			return 0;
		}
		int ret=0;
		for(int i=0;i<A.size();i++){
			Vector<Integer> B=new Vector<Integer>();
			for(int j=i+1;j<A.size();j++){
				if((int)A.get(i)<(int)A.get(j)){
					B.add(j,(int)A.get(j));
				}
			}
			ret=Math.max(ret,1+solve(B));
		}
		return ret;
	}
}
