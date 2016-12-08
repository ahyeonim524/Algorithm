
public class Test {

	public static void main(String[] args) {
		int count;
		for(int i=1;i<=100;i++){
			count=0;
			int j;
			for(j=2;j<=i/2;j++){
				if(i%j==0){
					break;
				}
			}
			if(j==i/2+1){
				System.out.println(i);
			}
		}
	}
}
