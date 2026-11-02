// PCPP 
// sestoft@itu.dk * 2026-10-26

package exercises10; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSpellingBee {
  public static void main(String[] args) {
    String filename = "words.txt";
    // 10.2.1:
    Stream<String> words6 = readWords(filename);
    List<String> cleanWords =  words6.map(string -> string.toLowerCase()).filter(
      string -> string.length() > 3 && string.matches("[a-z]+"))
      .distinct().collect(Collectors.toList());

    System.out.println("Number of clean words " + cleanWords.size());    
    System.out.println("----------------------------------------");    
    // 10.2.4:
    Puzzle puzz = new Puzzle('h', letterSet("chikmnu"));

    System.out.println(puzz.solutions(cleanWords).toList());
    System.out.println(puzz.solutions(cleanWords).toList().size());


    System.out.println("----------------------------------------");
    // 10.2.5:
    var puzzles = cleanWords.stream().map(str -> letterSet(str)).
      filter(set -> set.size() == 7).distinct().
       flatMap(set2 -> set2.stream().map(c -> new Puzzle(c,set2))).
        toList();

    System.out.println("Number of puzzles " + puzzles.size());
    System.out.println("----------------------------------------");
    // 10.2.6:
    System.out.println(puzzles.stream().limit(20).toList());

    System.out.println("----------------------------------------");
    // 10.2.7: Warning: SLOW
    List<Puzzle> goodPuzzles = null;  // replace with solution

    //System.out.println("Number of good puzzles " + goodPuzzles.size());
  }

  public static Stream<String> readWords(String filename) {
    try {      
      return new BufferedReader(new FileReader(filename)).lines();
    } catch (IOException exn) { 
      return Stream.<String>empty();
    }
  }

  public static boolean onlyaz(String s) {
    return s.chars().allMatch(ch -> 'a' <= ch && ch <= 'z');  
  }
  
  public static Set<Character> letterSet(String s) {
    return s.chars().mapToObj(i -> (char)i).collect(Collectors.toSet());
  }

  static class Puzzle {
    final char m;
    final Set<Character> W;
    public Puzzle(char m, Set<Character> W) {
      this.m = m;
      this.W = W;
    }

    // 10.2.2:
    public boolean hasSolution(String s) {
      var chars = letterSet(s);
      var newChars = chars.stream().filter(ch -> this.W.contains(ch)).toList();
      return chars.size() == newChars.size() && chars.contains(this.m);
    }

    // 10.2.3:
    public Stream<String> solutions(List<String> cleanWords) {
      return cleanWords.stream().filter(str -> hasSolution(str));
    }

    public String toString() {
      return String.format("(%c, %s)", m, W.stream().map(String::valueOf).collect(Collectors.joining(",", "{", "}")));
    }
  }
}
