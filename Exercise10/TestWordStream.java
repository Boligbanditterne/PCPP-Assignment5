// PCPP 
// sestoft@itu.dk * 2015-09-08, 2026-10-26

package exercises10; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestWordStream {
  public static void main(String[] args) {
    String filename = "words.txt";
    // 10.1.1:
    Stream<String> words = readWords(filename);
    System.out.println("Word count: " + words.count());
    System.out.println("----------------------------------------");    
    // 10.1.2:
    Stream<String> words2 = readWords(filename);
    words2.limit(20).forEach(System.out::println);
    System.out.println("----------------------------------------");
    // 10.1.3:
    Stream<String> words3 = readWords(filename);
    words3.filter(string -> string.length() > 22).forEach(System.out::println);

    System.out.println("----------------------------------------");
    // 10.1.4:
    Stream<String> words4 = readWords(filename);
    words4.map(string -> string.toLowerCase()).limit(20).forEach(System.out::println);

    System.out.println("----------------------------------------");
    // 10.1.5:
    Stream<String> words5 = readWords(filename);
    System.out.println(words5.map(string -> string.toLowerCase()).filter(string -> string.length() > 1 && string.matches("[a-z]+")).count());

    System.out.println("----------------------------------------");
    // 10.1.6:
    Stream<String> words6 = readWords(filename);

    List<String> cleanWords =  words6.map(string -> string.toLowerCase()).filter(
      string -> string.length() > 1 && string.matches("[a-z]+"))
      .distinct().collect(Collectors.toList());

    System.out.println("Number of clean words without duplicates " + cleanWords.size());
    System.out.println("----------------------------------------");
    // 10.1.7:
    cleanWords.stream().filter(string -> isPalindrome(string)).forEach(System.out::println);

    System.out.println("----------------------------------------");
    // 10.1.8 and 10.1.9:
    var lengthGroups = cleanWords.stream().
    collect(Collectors.groupingBy(string -> string.length()));

    System.out.println(lengthGroups.get(19));
   
    System.out.println("----------------------------------------");
    // 10.1.10:
    cleanWords.stream().limit(20).map(str -> counts(str)).forEach(System.out::println); //see how limit affects, what happens if it it set later

    System.out.println("----------------------------------------");
    // 10.1.11:
    Timer timer = new Timer();
    var anagram1 = cleanWords.stream().
     collect(Collectors.groupingBy(str -> counts(str)));
    timer.pause();
    
   
    anagram1.forEach((str,v) -> {
      if (v.size() > 1) {
        System.out.println(str);
        System.out.println(v);
      }}
    );

    System.out.println("----------------------------------------");
    // 10.1.12: 
    Timer timer2 = new Timer();

    var anagramPar = cleanWords.stream().parallel().
     collect(Collectors.groupingBy(str -> counts(str)));
     timer2.pause();
    
    System.out.println("Time for ana1: " + timer.check());
    System.out.println("Time for ana2 Parallel: " + timer2.check());

    System.out.println("----------------------------------------");
    // 10.1.13:

  }

  // 10.1.7:
  public static boolean isPalindrome(String s) {
    for(int i = 0; i < s.length()/2;i++){
      if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
    }
    return true; // replace with solution
  }

  // 10.1.14:
  public static Map<Character,Long> counts2(String s) {
    return null;  // replace with solution
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
    
  public static Map<Character,Long> counts(String s) {
    Map<Character,Long> res = new TreeMap<>();
    for (char c : s.toCharArray()) {
      res.putIfAbsent(c, 0L);
      res.put(c, res.get(c) + 1);
    }
    return res;
  }
}
