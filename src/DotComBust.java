import java.util.ArrayList;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();

    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Яндекс");

        DotCom two = new DotCom();
        two.setName("Гугл");

        DotCom three = new DotCom();
        three.setName("Озон");

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Ваша цель потопить три \"сайта\" .");
        System.out.println("Яндекс, Гугл, Озон");
        System.out.println("Попытайтесь потопить их за минимльное количесвто ходов");
        System.out.println("Создано игровое поле 7х7");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        System.out.println("D");
        System.out.println("E");
        System.out.println("F");
        System.out.println("G");
        System.out.println("     0  1  2  3  4  5  6");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);

            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");

        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у Вас всего " + numOfGuesses + " попыток");
            System.out.println("Вы успели выбраться до того, как Ваши вложения утонули");
        } else {
            System.out.println("Это заняло у Вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}




