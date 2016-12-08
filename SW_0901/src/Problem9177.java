import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Set{
	String str1;
	String str2;
	public Set(String str1,String str2){
		this.str1=str1;
		this.str2=str2;
	}
}
public class Problem9177 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			String str1=in.next();
			String str2=in.next();
			String str3=in.next();
			System.out.println(solve(str1,str2,str3));
		}
	}
	public static boolean solve(String str1,String str2,String str3){
		Set firstSet=new Set(str1,str2);
		Queue<Set>queue=new LinkedList<Set>();
		queue.offer(firstSet);
		boolean result=false;
		while(!queue.isEmpty()){
			for(int i=0;i<str3.length();i++){
				Set curSet=queue.peek();
				System.out.println(curSet.str1+" , "+curSet.str2);
				if(curSet.str1.equals("")&&curSet.str2.equals("")){
					return true;
				}
				else if(curSet.str1.equals("")){
					System.out.println(i+" here1");
					if(str3.charAt(i)==curSet.str2.charAt(0)){
						queue.poll();
						String newStr2=curSet.str2.substring(1);
						Set newSet2=new Set(curSet.str1,newStr2);
						queue.offer(newSet2);
					}
				}
				else if(curSet.str2.equals("")){
					System.out.println(i+" here2");
					if(str3.charAt(i)==curSet.str1.charAt(0)){
						queue.poll();
						//str1을 존중
						String newStr1=curSet.str1.substring(1);
						Set newSet1=new Set(newStr1,curSet.str2);
						queue.offer(newSet1);
					}
				}
				else{
					if(str3.charAt(i)==curSet.str1.charAt(0)&&str3.charAt(i)==curSet.str2.charAt(0)){
						System.out.println(i+" here3");
						queue.poll();
						//str1을 존중
						String newStr1=curSet.str1.substring(1);
						Set newSet1=new Set(newStr1,curSet.str2);
						queue.offer(newSet1);
						//str2를 존중
						String newStr2=curSet.str2.substring(1);
						Set newSet2=new Set(curSet.str1,newStr2);
						queue.offer(newSet2);
					}
					else if(str3.charAt(i)==curSet.str1.charAt(0)){
						System.out.println(i+" here4");
						queue.poll();
						//str1을 존중
						String newStr1=curSet.str1.substring(1);
						Set newSet1=new Set(newStr1,curSet.str2);
						queue.offer(newSet1);
					}
					else if(str3.charAt(i)==curSet.str2.charAt(0)){
						System.out.println(i+" here5");
						queue.poll();
						String newStr2=curSet.str2.substring(1);
						Set newSet2=new Set(curSet.str1,newStr2);
						queue.offer(newSet2);
					}
					else{
						break;
					}
				}
			}
		}
		return result;
	}
}
