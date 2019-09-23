package org.erhmutlu.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CodilityTest {

    private static final Character START_CHARACTER = 'x';

    public static String solution(int A, int B) {
        List<Character> resultList = traverse(new ArrayList<>(A + B), START_CHARACTER, A, B);
        return resultList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static List<Character> traverse(List<Character> characters, Character targetLetter, int A, int B) {
        if (isAllowed(characters, targetLetter)) {
            if (!START_CHARACTER.equals(targetLetter)) {
                characters.add(targetLetter);
            }

            if (A == 0 && B == 0) {
                return characters;
            } else if (A == 0 && B < 2) {
                return traverse(characters, 'b', A, (B - 1));
            } else if (B == 0 && A < 2) {
                return traverse(characters, 'a', (A - 1), B);
            }  else {
                List<Character> tmp;
                if (A > B) {
                    tmp = traverse(characters, 'a', (A - 1), B);
                    if (tmp == null) {
                        return traverse(characters, 'b', A, (B - 1));
                    }else {
                        return tmp;
                    }
                } else {
                    tmp = traverse(characters, 'b', A, (B - 1));
                    if (tmp == null) {
                        return traverse(characters, 'a', (A - 1), B);
                    } else {
                        return tmp;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isAllowed(List<Character> chars, Character letter) {
        if (chars.size() < 2) {
            return true;
        }

        boolean notAllowed = chars.get(chars.size() - 1).equals(letter) && chars.get(chars.size() - 2).equals(letter);
        return !notAllowed;
    }

    public static void main(String[] args) {
        System.out.println(solution(50, 40));
    }

}
