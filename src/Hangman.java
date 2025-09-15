import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private String word;
    private char[] guessedWord;
    private StringBuilder health;
    private static final String[] words = {"Китка", "Делать", "Кусь", "Моей", "Рука"};

    public static void main(String[] args) {
        new Hangman().startGame();
    }

    public void startGame() {

        Random rand = new Random();
        this.word = words[rand.nextInt(words.length)];
        this.guessedWord = new char[word.length()];
        this.health = new StringBuilder("\u2764\uFE0F\u2764\uFE0F\u2764\uFE0F\u2764\uFE0F");
        boolean wordGuessed = false;

        initializeGuessedWord();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Это игра Виселица, угадайте слово по буквам или умрите UwU\n");

        while (health.length() > 0 && !wordGuessed) {
            System.out.println("Ваше здоровье: " + health + "\n");
            System.out.println("Введите букву:");
            char input = scanner.nextLine().toLowerCase().charAt(0);

            makeGuess(input);
            System.out.print("Отгадываемое слово: ");
            System.out.println(guessedWord);

            wordGuessed = new String(guessedWord).equals(word);
        }

        if (wordGuessed) {
            System.out.println("\n🎊 Вы справились! 🎊");
            System.out.println("Загаданное слово было: " + word);
            System.out.println("     😊😊😊     ");
            System.out.println("    (  O O )    ");
            System.out.println("     \\  ^  /    ");
            System.out.println("      \\___/     ");
        } else {
            System.out.println("\n💔 Увы, вы не смогли отгадать слово... 💔");
            System.out.println("Загаданное слово было: " + word);
            System.out.println(" __     ______  _    _    _______ (●)   ________ _______ ");
            System.out.println(" \\ \\   / / __ \\| |  | |  |  __ \\| |  | |  ____| |  __ \\|");
            System.out.println("  \\ \\_/ / |  | | |  | |  | |  | | |  | | |__    | |  | |");
            System.out.println("   \\   /| |  | | |  | |  | |  | | |  | |  __|   | |  | |");
            System.out.println("    | | | |__| | |__| |  | |__| | |  | | |____  | |__| |");
            System.out.println("    |_|  \\____/ \\____/   |_____/| |  | |______| |_____/|");
        }
    }

    private void initializeGuessedWord() { // строка для проверки отгаданных букв
        for (int i = 0; i < word.length(); i++) {
            guessedWord[i] = '_';
        }
    }

    private void makeGuess(char input) { //проверяем угадана ли буква
        boolean correctGuess = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == input) {
                guessedWord[i] = word.charAt(i);
                correctGuess = true;
            }
        }
        if (!correctGuess) {
            health.deleteCharAt(health.length() - 1); // Уменьшаем здоровье
        }
    }


}