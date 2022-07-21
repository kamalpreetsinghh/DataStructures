package com.cleverdev;

import java.util.Arrays;
import java.util.List;

public class BalancedEquation {
    private final List<Character> leftBracketCharacters = Arrays.asList('(', '{', '[', '<');
    private final List<Character> rightBracketCharacters = Arrays.asList(')', '}', ']', '>');

    public boolean isBalancedEquation(String equation) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char ch: equation.toCharArray()) {
            if (leftBracketCharacters.contains(ch)) {
                stack.push(ch);
            } else if (rightBracketCharacters.contains(ch)) {
                if(stack.isEmpty()) return  false;

                char leftBracket = stack.pop();
                if(!bracketsMatch(leftBracket, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBracketCharacters.indexOf(left) == rightBracketCharacters.indexOf(right);
    }
}
