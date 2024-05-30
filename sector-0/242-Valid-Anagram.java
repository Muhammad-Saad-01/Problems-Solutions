class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> charactersFrequency = new HashMap<>();

        for (Character character : s.toCharArray()) {
            charactersFrequency.put(character, charactersFrequency.getOrDefault(character, 0) + 1);
        }

        for (Character character : t.toCharArray()) {
            charactersFrequency.put(character, charactersFrequency.getOrDefault(character, 0) - 1);
        }

        for (Integer count : charactersFrequency.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}