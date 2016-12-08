import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell{
	boolean visited;
	char value;
	public Cell(){
		visited=false;
		this.value='.';
	}
}
class Grid{
	Cell [][]cell;
	int cnt;
	public Grid(){
		cell=new Cell[3][3];
		cnt=0;
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				cell[i][j]=new Cell();
			}
		}
	}
}

public class Problem10472 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Queue<Grid> queue=new LinkedList<Grid>(); 
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			Grid target=new Grid();
			for(int a=0;a<3;a++){
				String curStr=in.next();
				for(int b=0;b<3;b++){
					Cell curCell=new Cell();
					curCell.value=curStr.charAt(b);
					target.cell[a][b]=curCell;
				}
			}
			
			for(int a=0;a<3;a++){
				for(int b=0;b<3;b++){
					Grid curGrid=new Grid();
					curGrid.cnt++;
					curGrid.cell[a][b].visited=true;
					queue.offer(makeDots(a,b,curGrid));
				}
			}
			
			while(!queue.isEmpty()){
				Grid cur=queue.poll();
				
				/*
				for(int a=0;a<3;a++){
					for(int b=0;b<3;b++){
						System.out.print(cur.cell[a][b].value+" ");
					}
					System.out.println("");
				}
				System.out.println("------------------------");
			
				*/
				if(check(target,cur)){
					System.out.println(cur.cnt);
					break;
				}
				
				for(int a=0;a<3;a++){
					for(int b=0;b<3;b++){
						if(!cur.cell[a][b].visited){
							Grid newGrid=new Grid();
							
							for(int c=0;c<3;c++){
								for(int d=0;d<3;d++){
									newGrid.cell[c][d].value=cur.cell[c][d].value;
									newGrid.cell[c][d].visited=cur.cell[c][d].visited;
								}
							}
							
							newGrid.cnt=cur.cnt+1;
							newGrid.cell[a][b].visited=true;
							
							Grid offerGrid=new Grid();
							offerGrid=makeDots(a,b,newGrid);
							queue.offer(offerGrid);
							
							for(int c=0;c<3;c++){
								for(int d=0;d<3;d++){
									System.out.print(offerGrid.cell[c][d].visited+" ");
								}
								System.out.println("");
							}
							System.out.println("------------------------");
						
						}
					}
				}
			}
		}
	}
	//사방을 방문해서 *->. .->* 로 변환해주는 함수
	static Grid makeDots(int x,int y,Grid grid){
		int []offsetX={0,-1,0,1};
		int []offsetY={-1,0,1,0};
		
		if(grid.cell[x][y].value=='.'){
			grid.cell[x][y].value='*';
		}
		else{
			grid.cell[x][y].value='.';
		}
		
		for(int i=0;i<4;i++){
			if(x+offsetX[i]>=0&&x+offsetX[i]<3&&y+offsetY[i]>=0&&y+offsetY[i]<3){
				if(grid.cell[x+offsetX[i]][y+offsetY[i]].value=='.'){
					grid.cell[x+offsetX[i]][y+offsetY[i]].value='*';
				}
				else{
					grid.cell[x+offsetX[i]][y+offsetY[i]].value='.';
				}
			}
		}
		return grid;
	}
	
	static boolean check(Grid target,Grid current){
		int count=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(target.cell[i][j].value==current.cell[i][j].value){
					count++;
				}
			}
		}
		if(count==9){
			return true;
		}
		else{
			return false;
		}
	}
}
