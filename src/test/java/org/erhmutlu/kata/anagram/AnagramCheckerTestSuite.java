package org.erhmutlu.kata.anagram;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        org.erhmutlu.kata.anagram.v1.AnagramCheckerTest.class,
        org.erhmutlu.kata.anagram.v2.AnagramCheckerTest.class
})
public class AnagramCheckerTestSuite {
}
