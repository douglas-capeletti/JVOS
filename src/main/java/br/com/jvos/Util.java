package br.com.jvos;

public class Util {

  private Util() {
  }

  public static String lineHeader(String identifier){
    return identifier.concat("       ").substring(0, 7).concat(" | ");
  }
}
