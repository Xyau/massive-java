package skyteacher;


import java.util.Arrays;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class StringsManipulations {

    public static HashMap<Character,Integer> getWordCount(String s){
        HashMap<Character,Integer> characters = new HashMap<>(25);
        char arr[] = s.toCharArray();
        for (char c : arr){
            if(characters.containsKey(c)){
                characters.put(c,characters.get(c)+1);
            } else {
                characters.put(c,1);
            }
        }
        return characters;
    }

    public static boolean allUniqueNaive(String string){
        boolean[] as = new boolean[300];
        for (int i = 0; i < string.length(); i++) {
            int c = string.charAt(i);
            if(as[c]) return false;
            else as[c] = true;
        }
        return true;
    }

    public static String reverse(String string){
        StringBuffer buffer = new StringBuffer();
        for (int i = string.length()-1; i >= 0 ; i--) {
            buffer.append(string.charAt(i));
        }
        return buffer.toString();
    }

    public static boolean isPermutation(String s1, String s2){
        HashMap<Integer,Integer> letters = new HashMap<>();
        if(s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i);
            if(letters.containsKey(c)) letters.put(c,letters.get(c)+1);
            else letters.put(c,1);
        }
        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i);
            if(!letters.containsKey(c)) return false;
            else letters.put(c,letters.get(c)-1);
            if(letters.get(c) < 0) return false;
        }
        return true;
    }


    public static char[] replaceInPlace(char[] string, char[] toReplace, char[] with){
        int replaceIndex=0;
        int stringIndex=0;
        int bufferIndex=0;
        int writeIndex=0;
        int maxBuffer=0;
        int bufferSize=34;
        char[] buffer = new char[bufferSize];
        char[] extendedString = new char[string.length+bufferSize];
        for (int i = 0; i < string.length; i++) {
            extendedString[i] = string[i];
        }

        do {
            char c ;
            if(maxBuffer > 0){
                c = buffer[bufferIndex];
                bufferIndex++;
                maxBuffer--;
                if(bufferIndex==bufferSize) bufferIndex=0;
            } else {
                c = extendedString[stringIndex];
                stringIndex++;
            }

            if(c == toReplace[replaceIndex]){
                replaceIndex++;
                if(replaceIndex == toReplace.length){
                    if(with.length > toReplace.length){
                        writeIndex -= toReplace.length-1;
                        for (int i = 0; i <with.length; i++) {
                            if(writeIndex >= stringIndex && string.length > stringIndex){
                                buffer[(bufferIndex+maxBuffer)%bufferSize] = extendedString[stringIndex];
                                maxBuffer++;
                                stringIndex++;
                            }
                            extendedString[writeIndex] = with[i];
                            writeIndex++;
                        }
                    } else {
                        //Aca me va a sobrar espacio
                        writeIndex -= toReplace.length-1;
                        for (int i = 0; i <with.length; i++) {
                            extendedString[writeIndex] = with[i];
                            writeIndex++;
                        }
                    }
                    replaceIndex = 0;
                } else {
                    if(writeIndex >= stringIndex && string.length > stringIndex){
                        buffer[(bufferIndex+maxBuffer)%bufferSize] = extendedString[stringIndex];
                        maxBuffer++;
                        stringIndex++;
                    }
                    extendedString[writeIndex] = c;
                    writeIndex++;
                }
            } else {
                replaceIndex = c == toReplace[0]? 1:0;
                if(writeIndex >= stringIndex && string.length > stringIndex){
                    buffer[(bufferIndex+maxBuffer)%bufferSize] = extendedString[stringIndex];
                    maxBuffer++;
                    stringIndex++;
                }
                extendedString[writeIndex] = c;
                writeIndex++;
            }
        }while (stringIndex<string.length || maxBuffer > 0);
        return Arrays.copyOf(extendedString,writeIndex);
    }


    public static String compress(String string){
        char charToCompress = string.charAt(0);
        int compressed = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(c == charToCompress){
                compressed++;
            } else {
                stringBuffer.append(charToCompress);
                stringBuffer.append(compressed);
                compressed=1;
                charToCompress = c;
            }
        }
        stringBuffer.append(charToCompress);
        stringBuffer.append(compressed);
        return stringBuffer.length()>string.length()?string:stringBuffer.toString();
    }


    public static Integer[][] rotate90degrees(Integer[][] image){
        int n = image.length-1;

        for (int x = 0; x < (n+1)/2; x++) {
            for (int y = 0; y < (n+1)/2+(n+1)%2; y++) {
                int saved = image[x][y];
                image[x][y] = image[n-x][y];
                image[n-x][y] = image[n-x][n-y];
                image[n-x][n-y] = image[x][n-y];
                image[x][n-y] = saved;
            }
        }
        return image;
    }

    public static boolean isIPV4(String str){
        String values [] = str.split("\\.");
        if(values.length != 4) return false;
        for (String value : values){
            Integer field = null;
            try{
                field= Integer.parseInt(value);
            }catch (NumberFormatException e){
                return false;
            }
            if(field == null) return false;
            if(field <0 || field > 255) return false;
        }
        return true;
    }

    public static boolean isIPV6(String str){
        String values [] = str.split(":");
        if(values.length != 8) return false;
        for (String value : values){
            Integer field = null;
            try{
                field= Integer.parseInt(value,16);
            }catch (NumberFormatException e){
                if(!value.isEmpty()){
                    return false;
                } else {
                    field = 0;
                }
            }
            if(field <0 || field > 65535) return false;
        }
        return true;
    }

    public static Integer countAnagrams(String word, String phrase){
        String phraseWords[] = phrase.split("[ .,]");
        Integer anagramCount = 0;
        for (String s : phraseWords){
            if(isAnagram(word,s)){
                anagramCount++;
            }
        }
        return anagramCount;
    }

    public static boolean isAnagram(String word, String s) {
        HashMap<Character, Integer> wordCount = getWordCount(word);
        HashMap<Character, Integer> sWordCount = getWordCount(s);
        if(word.length() != s.length())return false;
        for (Character c :sWordCount.keySet()){
            if(!wordCount.containsKey(c)) return false;
            else if(wordCount.get(c) != sWordCount.get(c)) return false;
        }
        return true;
    }


}

