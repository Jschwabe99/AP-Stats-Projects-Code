import java.lang.Thread;

public class Trial  { 
    public double P1Prob;
    public double P2Prob;
    public double tieProb;
    public double avgRoundNum;
    public int highestRound;
    public int maxP1DiceCount;
    public int maxP2DiceCount;


    public Trial (){
        Game[] Games = new Game[100000];
        for(int i = 0; i < Games.length;i++){
            Games[i] = new Game();
            Games[i].play();
        }

        for(Game obj: Games){
            P1Prob += obj.getP1Win();
        }
        P1Prob = P1Prob/Games.length;

        for(Game obj: Games){
            P2Prob += obj.getP2Win();
        }
        P2Prob = P2Prob/Games.length;

        for(Game obj: Games){
            tieProb += obj.getTie();
        }
        tieProb = tieProb/Games.length;

        for(Game obj: Games){
            avgRoundNum += obj.getRoundNum();
        }
        avgRoundNum = avgRoundNum/Games.length;

        for(Game obj: Games){
            if(highestRound<obj.getRoundNum()){
                highestRound = obj.getRoundNum();
            }
        }

        for(Game obj: Games){
            if(maxP1DiceCount<obj.getP1DiceCountMax()){
                maxP1DiceCount = obj.getRoundNum();
            }
        }

        for(Game obj: Games){
            if(maxP2DiceCount<obj.getP2DiceCountMax()){
                maxP2DiceCount = obj.getRoundNum();
            }
        }
    


    }
}