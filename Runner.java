public class Runner {

    public static void main(String[] args) {
        // Creates a list of 100 Trials 
        Trial[] simulation = new Trial[100];
        for(int i = 0; i < simulation.length; i++){
            simulation[i] = new Trial();
        }
        for(Trial test : simulation){
            System.out.println(test.P1Prob);
        }
    }
}
