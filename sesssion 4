import java.util.*;

// ---------- Problem 1: Highest Value Palindrome ----------
class HighestValuePalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        System.out.println(highestValuePalindrome(s, n, k));
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        char[] arr = s.toCharArray();
        boolean[] changed = new boolean[n];

        int l = 0, r = n - 1;
        while (l < r) {
            if (arr[l] != arr[r]) {
                char maxChar = (char) Math.max(arr[l], arr[r]);
                arr[l] = arr[r] = maxChar;
                changed[l] = changed[r] = true;
                k--;
            }
            l++; r--;
        }
        if (k < 0) return "-1";

        l = 0; r = n - 1;
        while (l <= r && k > 0) {
            if (l == r) {
                if (arr[l] != '9' && k >= 1) arr[l] = '9';
            } else {
                if (arr[l] != '9') {
                    if (changed[l] && k >= 1) {
                        arr[l] = arr[r] = '9';
                        k--;
                    } else if (!changed[l] && k >= 2) {
                        arr[l] = arr[r] = '9';
                        k -= 2;
                    }
                }
            }
            l++; r--;
        }
        return new String(arr);
    }
}

// ---------- Problem 2: Gridland Metro ----------
class GridlandMetro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] tracks = new int[k][3];
        for (int i = 0; i < k; i++) {
            tracks[i][0] = sc.nextInt();
            tracks[i][1] = sc.nextInt();
            tracks[i][2] = sc.nextInt();
        }
        System.out.println(gridlandMetro(n, m, k, tracks));
    }

    public static long gridlandMetro(int n, int m, int k, int[][] tracks) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] t : tracks) {
            map.putIfAbsent(t[0], new ArrayList<>());
            map.get(t[0]).add(new int[]{t[1], t[2]});
        }
        long occupied = 0;
        for (List<int[]> list : map.values()) {
            list.sort(Comparator.comparingInt(a -> a[0]));
            int start = -1, end = -1;
            for (int[] track : list) {
                if (track[0] > end) {
                    if (start != -1) occupied += end - start + 1;
                    start = track[0];
                    end = track[1];
                }
                end = Math.max(end, track[2]);
            }
            occupied += end - start + 1;
        }
        return (long) n * m - occupied;
    }
}

// ---------- Problem 3: Minimum Loss ----------
class MinimumLoss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] prices = new long[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextLong();
        System.out.println(minimumLoss(prices));
    }

    public static long minimumLoss(long[] price) {
        int n = price.length;
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = price[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Long.compare(b[0], a[0]));
        long minLoss = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[i][1] < arr[i - 1][1]) {
                minLoss = Math.min(minLoss, arr[i - 1][0] - arr[i][0]);
            }
        }
        return minLoss;
    }
}
