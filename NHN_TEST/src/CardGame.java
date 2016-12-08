/*
Java언어를 사용하여 구현하였습니다.
각 Player에게 겹치지 않게 카드를 분배한 뒤, 가진 카드의 숫자의 합만 비교하면 승자를 찾을 수 있지만 문제에서 제시한 게임의 형식을 구현하기위해 무늬도 포함하여 구현하였습니다.
*/

import java.util.Arrays;
import java.util.Random;

/* 카드의 무늬와 번호를 가지는 Card class */
class Card{
	char pattern;
	int number;
	public Card(char pattern, int number){
		this.pattern=pattern;
		this.number=number;
	}
}

/* player의 정보를 가지는 Player class */
class Player{
	int idx;
	int score;
	public Player(int idx){
		this.idx=idx;
		score=0;
	}
}

public class CardGame {

	static Card cards[]=new Card[52];
	
	public static void main(String[] args) {
		
		/* cards 배열을 초기화 */
		init();
		
		/* 게임 시작 */
		playGame();

	}
	
	/* 전체 52개의 카드를 cards 배열에 넣어주는 메서드 */
	static void init(){
		
		Card newCard;
		
		for(int i=0;i<13;i++){
			newCard=new Card('S',i+1);
			cards[i]=newCard;
		}
		for(int i=13;i<26;i++){
			newCard=new Card('D',i-12);
			cards[i]=newCard;
		}
		for(int i=26;i<39;i++){
			newCard=new Card('H',i-25);
			cards[i]=newCard;
		}
		for(int i=39;i<52;i++){
			newCard=new Card('C',i-38);
			cards[i]=newCard;
		}
	}
	
	/* 카드를 섞은 후 분배하고, 우승자를 가리는 메서드 */
	static void playGame(){
		
		int result;
		
		shuffle();
		
		Card player1[]=new Card[7];
		Card player2[]=new Card[7];
		Card player3[]=new Card[7];
		Card player4[]=new Card[7];
		
		for(int i=0;i<7;i++){
			player1[i]=cards[i];
		}
		for(int i=0;i<7;i++){
			player2[i]=cards[i+7];
		}
		for(int i=0;i<7;i++){
			player3[i]=cards[i+14];
		}
		for(int i=0;i<7;i++){
			player4[i]=cards[i+21];
		}
		
		result=findWinner(player1,player2,player3,player4);
		
		/* 우승자가 2명이상이라면 승자가 가려질때까지 게임 반복 */
		if(result==-1){
			playGame();
		}
		else{
			System.out.println("Winner : Player"+result);
		}
		
	}
	
	/* cards 배열을 랜덤하게 섞는 메서드 */
	static void shuffle(){
		
		int randIdx;
		Random rand=new Random();
		
		for(int i=0;i<52;i++){
			randIdx=rand.nextInt(52);
			Card temp=cards[i];
			cards[i]=cards[randIdx];
			cards[randIdx]=temp;
		}
	}
	
	/* 승자를 찾는 메서드 */
	static int findWinner(Card[]p1,Card[]p2,Card[]p3,Card[]p4){
		
		Player rank[]=new Player[4];
		
		for(int i=0;i<4;i++){
			rank[i]=new Player(i+1);
		}
		
		for(int i=0;i<7;i++){
			rank[0].score+=p1[i].number;
			rank[1].score+=p2[i].number;
			rank[2].score+=p3[i].number;
			rank[3].score+=p4[i].number;
		}
		
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				if(rank[j].score>rank[j+1].score){
					Player temp=rank[j];
					rank[j]=rank[j+1];
					rank[j+1]=temp;
				}
			}
		}
		
		/* 승자를 가릴 수 없는 경우 */
		if(rank[0].score==rank[1].score){
			return -1;
		}
		
		/* 승자를 가릴 수 있는 경우 */
		else{
			return rank[0].idx;
		}
	}
}