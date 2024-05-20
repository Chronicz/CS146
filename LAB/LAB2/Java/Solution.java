class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        // Count the frequency of characters in string s
        for (char i : s.toCharArray()) {
            count[i - 'a']++;
        }

        // Decrement the frequency of characters in string t
        for (char i : t.toCharArray()) {
            count[i - 'a']--;
        }

        // Check if any character has non-zero frequency
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}