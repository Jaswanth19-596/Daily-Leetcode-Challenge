class Solution {


    public static boolean isPossible(String word, HashMap<Character, Integer> freq, HashMap<Character, Integer> sco){
        
        HashMap<Character, Integer> mapOfWord = new HashMap<>();
        for(char ch : word.toCharArray()){
            mapOfWord.put(ch, mapOfWord.getOrDefault(ch, 0)+1);
        }

        for(char ch = 'a';ch <= 'z';ch++){
            if(mapOfWord.containsKey(ch) && !freq.containsKey(ch))  return false;
            if(mapOfWord.containsKey(ch) && freq.containsKey(ch) && freq.get(ch) < mapOfWord.get(ch)){
                return false;
            }
        }

        return true;
    }


    static int func(int i, String []words, HashMap<Character, Integer> freq, HashMap<Character, Integer> sco){

        if(i == words.length){
            return 0;
        }

        int notpick = func(i+1, words, freq, sco);   



        int pick = 0;
        int score = 0;
        if(isPossible(words[i], freq, sco)){
            
            for(char ch : words[i].toCharArray()){
                score += sco.get(ch);
                freq.put(ch, freq.get(ch)-1);
            }

            pick = score + func(i+1, words, freq, sco);

            for(char ch : words[i].toCharArray()){
                freq.put(ch, freq.get(ch)+1);
            }
        }
        return Math.max(pick, notpick);

    }




    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> sco = new HashMap<>();

        for(char ch : letters){
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }

        for(char ch = 'a'; ch <= 'z';ch++){
            sco.put(ch, score[ch-'a']);
        }

        return func(0, words, freq, sco);
        

    }
}