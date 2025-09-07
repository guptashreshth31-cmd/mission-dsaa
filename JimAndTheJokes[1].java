import java.util.*;

public class JimAndTheJokes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] jokes = new int[n][2];
        for (int i = 0; i < n; i++) {
            jokes[i][0] = sc.nextInt();
            jokes[i][1] = sc.nextInt();
        }
        System.out.println(jimAndTheJokes(jokes));
    }

    public static long jimAndTheJokes(int[][] jokes) {
        Map<Long, Long> map = new HashMap<>();
        long result = 0;
        for (int[] joke : jokes) {
            long value = joke[0] * 60L + joke[1];
            long base = Long.toString(value, joke[0]).chars().allMatch(Character::isDigit) ? value : -1;
            if (base != -1) {
                map.put(base, map.getOrDefault(base, 0L) + 1);
            }
        }
        for (long count : map.values()) {
            result += count * (count - 1) / 2;
        }
        return result;
    }
}