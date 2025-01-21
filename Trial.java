
public class Trial  { 
    public double P1Prob;
    public double P2Prob;
    public double avgRoundNum;
    public int highestRound;
    public int maxP1DiceCount;
    public int maxP2DiceCount;


    public Trial (){
        // Creats an empty list of Game objects
        Game[] Games = new Game[100000];
        // for every index in the Games list it runs one game simulation
        for(int i = 0; i < Games.length;i++){
            // Creates new Game object at index i
            Games[i] = new Game();
            // Runs simulation
            Games[i].play();
        }

        // Adds up all the games where P1 wins and then divids by number of games 
        for(Game obj: Games){
            P1Prob += obj.getP1Win();
        }
        P1Prob = P1Prob/Games.length;

        // Adds up all the games where P2 wins and then divids by number of games 
        for(Game obj: Games){
            P2Prob += obj.getP2Win();
        }
        P2Prob = P2Prob/Games.length;
        
        // Adds up all round numbers from each game and divids by number of games
        for(Game obj: Games){
            avgRoundNum += obj.getRoundNum();
        }
        avgRoundNum = avgRoundNum/Games.length;

        // finds the game with the highest round number
        for(Game obj: Games){
            if(highestRound<obj.getRoundNum()){
                highestRound = obj.getRoundNum();
            }
        }

        // finds the game with the highest P1 dice amount
        for(Game obj: Games){
            if(maxP1DiceCount<obj.getP1DiceCountMax()){
                maxP1DiceCount = obj.getRoundNum();
            }
        }

        // finds the game with the highest p2 dice amount
        for(Game obj: Games){
            if(maxP2DiceCount<obj.getP2DiceCountMax()){
                maxP2DiceCount = obj.getRoundNum();
            }
        }
    


    }
}
