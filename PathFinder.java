package NavigationSubSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathFinder {
    private static Map<Character, Character> charMap = new HashMap<>();
    private static Map<Character, Integer> scoreMap = new HashMap<>();
    private static int  illegalCharPos = -1;
    private static List<Character>  pileOfChar = new ArrayList<>();

    public static void main(String[] args) {
        makeHashMap();
        List<String> totalPath = new ArrayList<>();
        int totalSum = 0;

        totalPath.add("[({(<(())[]>[[{[]{<()<>>");
        //data.add("[(()[<>])]({[<{<<[]>>(");

        for (String singlePath : totalPath) {
            System.out.println("line: " + singlePath);
           char[] ch = singlePath.toCharArray();
            for (int i=0 ; i< ch.length ; i++) {
                if (charMap.containsKey(ch[i])) {
                    pileOfChar.add(charMap.get(ch[i]));
                    System.out.println("if pileOfChar: " + pileOfChar);
                } else {
                    if (pileOfChar.get(pileOfChar.size() - 1).equals(ch[i])) {
                        pileOfChar.remove(pileOfChar.size() - 1);
                        System.out.println("else pileOfChar: " + pileOfChar);
                    }else{
                        System.out.println("break: " + i + "ch[i]" + ch[i]);
                        if(illegalCharPos == -1){
                            illegalCharPos = i;
                        }
                    }
                }
            }
        }

        for(int j =0 ; j< pileOfChar.size() ; j++ ){
            totalSum = totalSum + scoreMap.get(pileOfChar.get(j));
        }

        System.out.println("illegalCharPos: " + illegalCharPos);
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
