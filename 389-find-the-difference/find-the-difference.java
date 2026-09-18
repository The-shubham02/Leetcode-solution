class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for( char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int[] freq2 = new int[26];
        for( char ch: t.toCharArray()){
            freq2[ch-'a']++;
        }
        for(int i = 0; i<26;i++){
            if( freq[i] != freq2[i]) return (char)('a' + i);
        }
        return ' ';
    }
}