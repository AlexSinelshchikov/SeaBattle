public class SimpleDotComTestDrive {

    public static void main(String[] args) {
       SimpleDotCom dot = new SimpleDotCom();
       int[] location = {1, 2, 3};
       dot.setLocationCells(location);
       String userGuess = "2";

       String result = dot.checkYourself(userGuess);
    }



}
