class Solution {

    public int countPalindromes(String s) {

        final long MOD = 1_000_000_007;

        int n = s.length();

        long[][] left = new long[10][10];
        long[][] right = new long[10][10];

        // Build all pairs for the right side
        long[] rightCount = new long[10];

        for (int i = n - 1; i >= 0; i--) {

            int digit = s.charAt(i) - '0';

            // digit comes before every existing digit
            for (int j = 0; j < 10; j++) {
                right[digit][j] += rightCount[j];
            }

            rightCount[digit]++;
        }

        long[] leftCount = new long[10];

        long answer = 0;

        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            // Current character cannot be part of the right side
            rightCount[digit]--;

            // Remove pairs starting with current digit
            for (int j = 0; j < 10; j++) {
                right[digit][j] -= rightCount[j];
            }

            // Count x y [digit] y x
            for (int x = 0; x < 10; x++) {

                for (int y = 0; y < 10; y++) {

                    answer += left[x][y] * right[y][x];
                    answer %= MOD;
                }
            }

            // Add current digit to left side
            for (int j = 0; j < 10; j++) {
                left[j][digit] += leftCount[j];
            }

            leftCount[digit]++;
        }

        return (int) answer;
    }
}