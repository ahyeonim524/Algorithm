import java.util.Scanner;

public class ProblemStoneBridge {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			boolean[]bombs;
			int[][]stones;
			int[]index;
			int N=in.nextInt();
			int K=in.nextInt();
			int L=in.nextInt();
			bombs=new boolean[N+1];
			stones=new int[N+1][K*N];
			index=new int[N+1];
			if(L!=0){
				for(int k=0;k<L;k++){
					bombs[in.nextInt()]=true;
				}
			}

			for(int j=1;j<=K;j++){
				if(!bombs[j]){
					stones[j][index[j]]=j;
					index[j]+=1;
				}
			}
			
			
			for(int j=1;j<N;j++){//j행에 있는 index[j]개의 숫자들에 대해 현재 이동한 수 제외하고 이동
				System.out.println(j+"행의");
				if(!bombs[j]){
					for(int k=0;k<index[j];k++){
						for(int l=1;l<=K;l++){
							if(l!=stones[j][k]&&j+l<=N){
								System.out.println(stones[j][k]+"에 대해서");
								stones[j+l][index[j+l]]=l;
								System.out.println(stones[j+l][index[j+l]]);
								index[j+1]+=1;
								
							}
						}
					}
				}
			}
			
			/*
			for(int j=0;j<=N;j++){
				System.out.print(bombs[j]+" ");
			}
			System.out.println("");
			for(int j=N;j>=1;j--){
				System.out.println(j+" 행");
				for(int k=0;k<index[j];k++){
					System.out.print(stones[j][k]+" ");
				}
				System.out.println("");
			}

*/
		}
	}
}
