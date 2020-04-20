package br.com.jvos;

import br.com.jvos.operations.Operation;
import br.com.jvos.operations.operation.IType.ADDI;
import br.com.jvos.operations.operation.IType.LDD;
import br.com.jvos.operations.operation.IType.LDI;
import br.com.jvos.operations.operation.IType.STD;
import br.com.jvos.operations.operation.IType.SUBI;
import br.com.jvos.operations.operation.JType.JMP;
import br.com.jvos.operations.operation.JType.JMPI;
import br.com.jvos.operations.operation.JType.JMPIE;
import br.com.jvos.operations.operation.JType.JMPIG;
import br.com.jvos.operations.operation.JType.JMPIL;
import br.com.jvos.operations.operation.R1Type.STOP;
import br.com.jvos.operations.operation.R2Type.ADD;
import br.com.jvos.operations.operation.R2Type.LDX;
import br.com.jvos.operations.operation.R2Type.MULT;
import br.com.jvos.operations.operation.R2Type.STX;
import br.com.jvos.operations.operation.R2Type.SUB;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Loader {

    public Program load(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getFile()))) {
            return new Program(lines.map(this::parseOperation).collect(Collectors.toList()).toArray(Operation[]::new));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load program!");
        }
    }

    private Operation parseOperation(String line) {

        String[] word = line.replaceAll("(, | {2})", " ").split(" ");

        int position = 0;
        int[] parameters = new int[4];
        for (int i = 1; i < word.length; i++) {
            String fragment = word[i];
            if (fragment.contains("R") || fragment.contains("r")) {
                parameters[position] = extractInt(fragment);
                position++;
            } else {
                parameters[2] = extractInt(fragment);
            }
        }

        switch (word[0].toUpperCase()) {
            case "ADDI":
                return new ADDI(parameters[0], parameters[1], parameters[2]);
            case "LDD":
                return new LDD(parameters[0], parameters[1], parameters[2]);
            case "LDI":
                return new LDI(parameters[0], parameters[1], parameters[2]);
            case "STD":
                return new STD(parameters[0], parameters[1], parameters[2]);
            case "SUBI":
                return new SUBI(parameters[0], parameters[1], parameters[2]);
            case "JMP":
                return new JMP(parameters[0], parameters[1], parameters[2]);
            case "JMPI":
                return new JMPI(parameters[0], parameters[1], parameters[2]);
            case "JMPIE":
                return new JMPIE(parameters[0], parameters[1], parameters[2]);
            case "JMPIG":
                return new JMPIG(parameters[0], parameters[1], parameters[2]);
            case "JMPIL":
                return new JMPIL(parameters[0], parameters[1], parameters[2]);
            case "STOP":
                return new STOP(parameters[0], parameters[1], parameters[2]);
            case "ADD":
                return new ADD(parameters[0], parameters[1], parameters[2]);
            case "LDX":
                return new LDX(parameters[0], parameters[1], parameters[2]);
            case "MULT":
                return new MULT(parameters[0], parameters[1], parameters[2]);
            case "STX":
                return new STX(parameters[0], parameters[1], parameters[2]);
            case "SUB":
                return new SUB(parameters[0], parameters[1], parameters[2]);
        }
        throw new RuntimeException("Operation [" + String.join(" ", word) + "] not found");
    }


    int extractInt(String value) {
        int result = Integer.parseInt(value.replaceAll("\\D", ""));
        if (value.contains("-")) result = -result;
        return result;
    }

}
