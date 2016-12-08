/*

JAVA에서 사용

-import 사용
-package 금지

*/

import java.util.Scanner;

public class MakeBin{

	static int n;
	static int k;
	public static void main(String[] args) {

		int nCount;		/* 문제의 테스트 케이스 */

		Scanner scan = new Scanner(System.in);

		nCount = scan.nextInt();		/* 테스트 케이스 입력 */

		for(int itr = 0 ; itr<nCount ;itr++) { 

 			System.out.println("#testcase" + (itr+1));

 			//k개의 1을 가진 n자리 바이너리
 			n = scan.nextInt();
 			k = scan.nextInt();
 			
 			int bin[] = new int[n];

 			makeBin(0, 1, bin, 1);
 			makeBin(0, 0, bin, 0);
		}
	}
	public static boolean makeBin(int index, int num, int bin[], int b){
		bin[index] = b;
		
		if(k == num){
			for(int i=0; i<n; i++)
				System.out.print(bin[i]);
			System.out.println();
			return true;
		}		
		if(index == n-1)
			return false;
		
		boolean result = false;
		result = makeBin(index+1, num+1, bin, 1);
		result = makeBin(index+1, num, bin, 0);	
		
		return result;
	}
}