class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // calculating frq for ransomnote
        int[] freq = new int[26];
        for( char ch:ransomNote.toCharArray() ){
                freq[ch-'a']++;
        }
        int [] freq2 = new int[26];
        for( char ch : magazine.toCharArray()){
            freq2[ch-'a']++;
        }
                 for(int i = 0; i< freq.length; i++){
                 if(freq[i]>freq2[i]) return false;}

                 return true;

        
    }
}