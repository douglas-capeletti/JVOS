package br.com.jvos;

import br.com.jvos.instructions.Instruction;
import br.com.jvos.instructions.operation.IType.ADDI;
import br.com.jvos.instructions.operation.IType.LDD;
import br.com.jvos.instructions.operation.IType.LDI;
import br.com.jvos.instructions.operation.IType.STD;
import br.com.jvos.instructions.operation.IType.SUBI;
import br.com.jvos.instructions.operation.JType.JMP;
import br.com.jvos.instructions.operation.JType.JMPI;
import br.com.jvos.instructions.operation.JType.JMPIE;
import br.com.jvos.instructions.operation.JType.JMPIG;
import br.com.jvos.instructions.operation.JType.JMPIL;
import br.com.jvos.instructions.operation.R1Type.STOP;
import br.com.jvos.instructions.operation.R2Type.ADD;
import br.com.jvos.instructions.operation.R2Type.LDX;
import br.com.jvos.instructions.operation.R2Type.MULT;
import br.com.jvos.instructions.operation.R2Type.STX;
import br.com.jvos.instructions.operation.R2Type.SUB;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Loader {

    public Program load(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getFile()))) {
            return new Program(lines.map(interpreter()).collect(Collectors.toList()).toArray(Instruction[]::new));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load program!");
        }
    }

    public Function<String, Instruction> interpreter() {
        return string -> {
            String[] word = string.split("( |,)");
            Instruction instruction = parseOperation(word);
            return instruction;
        };
    }

    private Instruction parseOperation(String[] word) {

        int position = 0;
        int[] parameters = new int[4];
        for (int i = 1; i < word.length; i++) {
            if (word[i].contains("R") || word[i].contains("r")) {
                parameters[position] = extractInt(word[i]);
                position++;
            } else {
                parameters[2] = extractInt(word[i]);
            }
        }

        switch (word[0].toUpperCase()) {
            case "ADDI":
                return new ADDI(parameters);
            case "LDD":
                return new LDD(parameters);
            case "LDI":
                return new LDI(parameters);
            case "STD":
                return new STD(parameters);
            case "SUBI":
                return new SUBI(parameters);
            case "JMP":
                return new JMP(parameters);
            case "JMPI":
                return new JMPI(parameters);
            case "JMPIE":
                return new JMPIE(parameters);
            case "JMPIG":
                return new JMPIG(parameters);
            case "JMPIL":
                return new JMPIL(parameters);
            case "STOP":
                return new STOP(parameters);
            case "ADD":
                return new ADD(parameters);
            case "LDX":
                return new LDX(parameters);
            case "MULT":
                return new MULT(parameters);
            case "STX":
                return new STX(parameters);
            case "SUB":
                return new SUB(parameters);
        }
        throw new RuntimeException("Operation [" + String.join(" ", word) + "] not found");
    }


    int extractInt(String value) {
        int result = Integer.parseInt(value.replaceAll("\\D", ""));
        if (value.contains("-")) result = -result;
        return result;
    }

}
