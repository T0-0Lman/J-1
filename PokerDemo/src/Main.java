import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card{

    public Card(int rank, String suits) {
        this.rank = rank;
        this.suits = suits;
    }

    private int rank;
    private String suits;



    @Override
    public String toString() {
        return
                "[数值: " + rank + ", 花色: " + suits + "]";
    }

}

class CardDemo{
    private static final String[] suits = {"♥","♦","♣","♠"};
    public List<Card> buyDesk(){
        List<Card> desk = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <=13 ; j++) {
                int rank = j;
                String suit = suits[i];
                Card card = new Card(rank,suit);
                desk.add(card);
            }
        }
        return desk;
    }

    public void swap(List<Card> desk,int i,int index){
        //Card tmp = desk[i];
        Card tmp = desk.get(i);

        //desk[i] = desk[index];
        desk.set(i,desk.get(index));

        //desk[index] = tmp;
        desk.set(index,tmp);

    }
    public void shuffle(List<Card> desk){
        int len = desk.size();
        for (int i = len-1; i > 0 ; i--) {
            Random random = new Random();
            int index = random.nextInt(i);
            swap(desk,i,index);
        }
    }
}

public class Main {
    public static void main(String[] args){
        CardDemo cardDemo = new CardDemo();
        List<Card> desk = cardDemo.buyDesk();
        System.out.println("洗牌前：");
        System.out.println(desk);
        System.out.println("洗牌后：");
        cardDemo.shuffle(desk);
        System.out.println(desk);
        System.out.println("揭牌：");

        ArrayList<Card> player1 = new ArrayList<>();
        ArrayList<Card> player2 = new ArrayList<>();
        ArrayList<Card> player3 = new ArrayList<>();

        ArrayList<ArrayList<Card>> player = new ArrayList<>();
        player.add(player1);
        player.add(player2);
        player.add(player3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = desk.remove(0);
                player.get(j).add(card);
            }
        }

        for (int i = 0; i < player.size(); i++) {
            System.out.println(player.get(i));
        }


    }
}