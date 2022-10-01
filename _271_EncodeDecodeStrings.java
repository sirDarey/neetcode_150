package neetcode_150;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sir Darey
 */

public class _271_EncodeDecodeStrings {
    
    public String encode (String [] array) {
        
        List <Character> chars = new  ArrayList<>();
        
        for (String s : array) {
            for (char c : s.toCharArray()) 
                chars.add(c);
            chars.add(' ');
        }
        
        int j = chars.size()-1;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars.size(); i++) {
            if (chars.get(i)==' ') {
                sb.append('$');
                continue;
            }
            sb.append(chars.get(i)-'1');
                    
            if (chars.get(i).equals(chars.get(j)))
                sb.append((char)(chars.get(j+1)-chars.get(i)));
            else
                sb.append((char)(chars.get(j)-chars.get(i)));
            j--;
        }
        
        return sb.toString();
    }
    
    public List <String> decode (String encodedString) {
        char [] chars = encodedString.toCharArray();
        
        List <String> result = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        StringBuilder wordBuild = new StringBuilder();
        int charStart = 0, charEnd = 0, wordStart = 0, wordEnd = 0;
        for (int i=0; i<chars.length; i++) {     
            
            if (Character.isDigit(chars[i]) || chars[i] == '-') {
                wordBuild.append(chars[i]);
                charEnd++;
            } else {
                if (chars[i] == '$') {
                    result.add(word.toString().substring(wordStart, wordEnd));
                    wordStart = wordEnd; 
                } else {
                    String newLetter = wordBuild.toString().substring(charStart, charEnd);
                    char newChar = (char)(Integer.parseInt(newLetter) + '1');
                    word.append(newChar);
                    charStart = charEnd;
                    wordEnd++;
                }
            }
        }
        
        return result;
    }
     
    public static void main(String[] args) {
        _271_EncodeDecodeStrings solution = new _271_EncodeDecodeStrings();
        
        String [] array = {"sssfsrfergergessqqwwewwessss"};
        
        System.out.println(solution.encode(array)); // Uncomment if you want to see encoded string output
        
        System.out.println(solution.decode(solution.encode(array)));
    }
    
}
