/*
Java�� ����Ͽ� �����Ͽ����ϴ�.
�� Player���� ��ġ�� �ʰ� ī�带 �й��� ��, ���� ī���� ������ �ո� ���ϸ� ���ڸ� ã�� �� ������ �������� ������ ������ ������ �����ϱ����� ���̵� �����Ͽ� �����Ͽ����ϴ�.
*/

import java.util.Arrays;
import java.util.Random;

/* ī���� ���̿� ��ȣ�� ������ Card class */
class Card{
	char pattern;
	int number;
	public Card(char pattern, int number){
		this.pattern=pattern;
		this.number=number;
	}
}

/* player�� ������ ������ Player class */
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
		
		/* cards �迭�� �ʱ�ȭ */
		init();
		
		/* ���� ���� */
		playGame();

	}
	
	/* ��ü 52���� ī�带 cards �迭�� �־��ִ� �޼��� */
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
	
	/* ī�带 ���� �� �й��ϰ�, ����ڸ� ������ �޼��� */
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
		
		/* ����ڰ� 2���̻��̶�� ���ڰ� ������������ ���� �ݺ� */
		if(result==-1){
			playGame();
		}
		else{
			System.out.println("Winner : Player"+result);
		}
		
	}
	
	/* cards �迭�� �����ϰ� ���� �޼��� */
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
	
	/* ���ڸ� ã�� �޼��� */
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
		
		/* ���ڸ� ���� �� ���� ��� */
		if(rank[0].score==rank[1].score){
			return -1;
		}
		
		/* ���ڸ� ���� �� �ִ� ��� */
		else{
			return rank[0].idx;
		}
	}
}