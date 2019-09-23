package org.erhmutlu.kata.paranthesis.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesisChecker {

    private static Map<Character, Character> map;

    static {
        map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public static boolean isBalanced(String str){
        Stack<Character> characterStack = new Stack<>();
        boolean fail = false;
        for (final char character : str.toCharArray()) {
            if (isOpenParanthesis(character)) {
                characterStack.push(character);
            }else if(isCloseParanthesis(character)){
                if (characterStack.isEmpty()){
                    fail = true;
                    break;
                }else{
                    Character closeableParanthesis = findCloseableParanthesis(character);
                    Character lastCharacter = characterStack.pop();
                    if (closeableParanthesis != lastCharacter){
                        fail = true;
                        break;
                    }
                }
            }else {
                fail = true;
                break;
            }
        }
        return !fail && characterStack.isEmpty();
    }

    private static boolean isOpenParanthesis(Character character){
        return map.containsKey(character);
    }

    private static boolean isCloseParanthesis(Character character){
        return map.containsValue(character);
    }

    private static Character findCloseableParanthesis(Character character){
        Character relatedOpenCharacter = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == character)
                .map(Map.Entry::getKey)
                .findFirst().get();
        return relatedOpenCharacter;
    }
}
