# Anagram Checker

Two strings, and, are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.

### Constraints

Strings and consist of English alphabetic characters.
The comparison should NOT be case sensitive.

#### Output Format
Return true if and are case-insensitive anagrams of each other; otherwise, return false instead.

#### Sample Input 0
anagram
margana

#### Sample Output 0
true

#### Sample Input 1
anagramm
marganaa

#### Sample Output 1
false

# Anagram Maker

Calculate character differency between two string to be anagram.

#### Sample Input
cde
abc

#### Sample Output
4

#### Explanation
We delete the following characters from our two strings to turn them into anagrams of each other:
Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.