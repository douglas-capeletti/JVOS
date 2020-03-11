package br.com.jvos.runtime;

public class Util {

    public static String toString(byte[] bytes) {
        return String.format("[%s] [%s] [%s] [%s]", bytes[0], bytes[1], bytes[2], bytes[3]);
    }

}
