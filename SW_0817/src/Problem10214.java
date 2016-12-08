import java.util.Scanner;

public class Problem10214 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		int[]Y=new int[9];
		int[]K=new int[9];
		for(int i=0;i<T;i++){
			for(int j=0;j<9;j++){
				if(j!=0){
					Y[j]=Y[j-1]+in.nextInt();
					K[j]=K[j-1]+in.nextInt();
				}
				else{
					Y[j]=in.nextInt();
					K[j]=in.nextInt();
				}
			}
			if(Y[8]>K[8]){
				System.out.println("Yonsei");
			}
			else if(Y[8]<K[8]){
				System.out.println("Korea");
			}
			else{
				System.out.println("Draw");
			}
		}
	}
}
