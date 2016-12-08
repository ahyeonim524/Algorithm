import java.util.Scanner;

public class Problem10817 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int first;
		int second;
		int third;
		int A=in.nextInt();
		int B=in.nextInt();
		int C=in.nextInt();
		
		if(A>B){
			if(A>C){
				first=A;
				if(B>C){
					second=B;
					third=C;
				}
				else{
					second=C;
					third=B;
				}
			}
			else{
				first=C;
				second=A;
				third=B;
			}
		}
		else{
			if(B>C){
				first=B;
				if(A>C){
					second=A;
					third=C;
				}
				else{
					second=C;
					third=A;
				}
			}
			else{
				first=C;
				second=B;
				third=A;
			}
		}
		System.out.println(second);
	}
}
