public class Game{
    final int P1_DICE_SIDE= 6;
    final int P2_DICE_SIDE = 4;
    private int roundNum = 0;
    int P1DiceCount = 2;
    private int P1DiceCountMax;
    int P2DiceCount = 3;
    private int P2DiceCountMax ;
    private int P1Win; 
    private int P2Win;
    private int tie;


    public int getRoundNum(){
        return roundNum;
    }
    public int getP1DiceCountMax(){
        return P1DiceCountMax;
    }
    public int getP2DiceCountMax(){
        return P2DiceCountMax;
    }
    public int getP1Win(){
        return P1Win;
    }

    public int getP2Win(){
        return P2Win;
    }

    public int getTie(){
        return tie;
    }

    public void play(){
        int P1Sum = 0;
        int P2Sum = 0;
        while(P1Sum != 7 && P2Sum != 7){
            roundNum++;
            P1Sum = 0;
            P2Sum = 0;
            

            for(int i = 0; i < P1DiceCount; i++){
                P1Sum += (int)(Math.random()*P1_DICE_SIDE)+1;
            }
            for(int i = 0; i < P2DiceCount; i++){
                P2Sum += (int)(Math.random()*P2_DICE_SIDE)+1;
            }
            //System.out.println("Round " + roundNum + ":\n" + "Player 1 Sum: " + P1Sum + "\n" + "Player 1 Dice Count: " + P1DiceCount + "\n" + "Player 2 Sum: " + P2Sum + "\n" + "Player 2 Dice Count: " + P2DiceCount);
            
            // Checks the current recored max dice count agianst the current game
            if(P1DiceCountMax<P1DiceCount){
                P1DiceCountMax = P1DiceCount;
            }
            if(P2DiceCountMax<P2DiceCount){
                P2DiceCountMax = P2DiceCount;
            }

           //player 1 dice count logic for increasing and decresing based on odd or even
            if(P1Sum % 2 == 0){
                P1DiceCount++;
            } else {
                P1DiceCount = Math.max(P1DiceCount-1, 2);
            }
            
            //player 2 dice count logic for increasing and decresing based on odd or even
            if(P2Sum % 2 == 0){
                P2DiceCount++;
            } else {
                P2DiceCount = Math.max(P2DiceCount-1, 2);
            }
            
        }
        //Winner conditonal check 
        if(P1Sum == 7 && P2Sum == 7){
            play(); // Dosent allow ties
        }else if(P2Sum == 7){
            P2Win = 1;
        } else {
            P1Win = 1;
        }
    }
}
