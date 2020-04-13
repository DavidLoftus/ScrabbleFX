package scrabble.bot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class GaddagTest {

    private static Set<String> wordList = new HashSet<>();

    @BeforeAll
    static void initWordList() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("csw.txt"))) {
            reader.lines()
                    .filter(s -> s.length() < 8)
                    .forEach(wordList::add);
        }
    }

    private Gaddag gaddag;

    @BeforeEach
    void init() {
        this.gaddag = new Gaddag(wordList);
    }

    @Test
    void findWords() {
        AtomicBoolean foundExplain = new AtomicBoolean(false);
        gaddag.findWords("lain").forEach(join -> {
            String word = join.getWord();
            assertTrue(wordList.contains(word), "bad word: " + word);
            if (word.equals("explain")) {
                 foundExplain.set(true);
            }
        });
        assertTrue(foundExplain.get());
    }
}