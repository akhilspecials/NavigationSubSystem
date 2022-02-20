package NavigationSubSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathFinder {
    private static Map<Character, Character> charMap = new HashMap<>();
    private static Map<Character, Integer> scoreMap = new HashMap<>();
    private static boolean isIllegalCharFound = false;
    private static Character firstIllegalChar = null;
    private static List<Character>  pileOfChar = new ArrayList<>();
    private static List<Character>  illegalChar = new ArrayList<>();

    public static void main(String[] args) {
        makeHashMap();
        List<String> totalPath = new ArrayList<>();
        int totalSum = 0;

       // totalPath.add("[({(<(())[]>[[{[]{<()<>>");
      //  totalPath.add("{<[]})");
        totalPath.add("{[<(]>)}");

        for (String singlePath : totalPath) {
            System.out.println("line: " + singlePath);
           char[] ch = singlePath.toCharArray();
            for (int i=0 ; i< ch.length ; i++) {
                if (charMap.containsKey(ch[i])) {
                    pileOfChar.add(charMap.get(ch[i]));
                    System.out.println("if pileOfChar: " + pileOfChar);
                } else {
                   Character lastChar = pileOfChar.get(pileOfChar.size() - 1);
                    if (!lastChar.equals(ch[i])) {
                        illegalChar.add(ch[i]);
                        if(!isIllegalCharFound){
                            firstIllegalChar = lastChar;
                            isIllegalCharFound = true;
                        }
                    }
                    pileOfChar.remove(pileOfChar.size() - 1);
                    System.out.println("else pileOfChar: " + pileOfChar);
                }
            }
        }

        System.out.println("illegalChar: " + illegalChar);
        for(int j =0 ; j< illegalChar.size() ; j++ ){
            totalSum = totalSum + scoreMap.get(illegalChar.get(j));
        }

        System.out.println("firstIllegalChar: " + firstIllegalChar);
       System.out.println("totalSum: " + totalSum);


    }

    private static void makeHashMap() {
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');
        charMap.put('<', '>');

        scoreMap.put(')', 3);
        scoreMap.put(']', 57);
        scoreMap.put('}', 1197);
        scoreMap.put('>', 25137);
    }

}

