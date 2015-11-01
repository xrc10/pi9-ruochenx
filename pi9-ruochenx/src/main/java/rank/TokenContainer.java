package rank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.jcas.tcas.Annotation;

import type.Token;

public class TokenContainer implements Container {

  public ArrayList<String> tokens;

  private Pattern tokenPattern = Pattern.compile("\\w+");

  private Pattern htmlTagPattern = Pattern.compile("</??\\w+>");

  private ArrayList<String> stopwords = readStopwords("src/main/resources/stopwords.txt");

  @Override
  public Iterator getIterator() {
    return new TokenIterator();
  }

  public void tokenize(String inputStr) {
    tokens = new ArrayList<String>();
    Matcher htmlMatcher = htmlTagPattern.matcher(inputStr);
    while (htmlMatcher.find()) {
      inputStr = inputStr.replaceAll(htmlMatcher.group(),
              String.format("%1$" + htmlMatcher.group().length() + "s", ""));
    }
    // tokenize
    Matcher matcher = tokenPattern.matcher(inputStr);
    while (matcher.find()) {
      if (stopwords.contains(matcher.group(0).toLowerCase())) {
        continue;
      }
      tokens.add(matcher.group());
    }
  }

  private class TokenIterator implements Iterator {
    int index;

    @Override
    public boolean hasNext() {

      if (index < tokens.size()) {
        return true;
      }
      return false;
    }

    @Override
    public Object next() {

      if (this.hasNext()) {
        return tokens.get(index++);
      }
      return null;
    }
  }

  public ArrayList<String> readStopwords(String fileName) {
    ArrayList<String> stopwords = new ArrayList<String>();
    try {
      Scanner sc = new Scanner(new File(fileName));
      while (sc.hasNextLine()) {
        stopwords.add(sc.nextLine());
      }
      sc.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return stopwords;
  }
}
