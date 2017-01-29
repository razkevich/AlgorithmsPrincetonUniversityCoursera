import java.util.Random;

public class QuickShuffle {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int s = new Random().nextInt(i + 1);
            String temp = args[i];
            args[i] = args[s];
            args[s] = temp;
        }
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
