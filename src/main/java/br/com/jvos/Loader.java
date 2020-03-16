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
import br.com.jvos.instructions.operation.R2Type.STX;
import br.com.jvos.instructions.operation.R2Type.SUB;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Loader {

    public Program run(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return new Program(
                    stream.map(buildInstruction())
                            .collect(Collectors.toList())
                            .toArray(Instruction[]::new)
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to load program!");
        }
    }

    private Function<String, Instruction> buildInstruction() {
        return string -> {
            String[] word = string.split("( |,)");
            return parseOperation(word);
        };
    }

    private Instruction parseOperation(String[] word) {

        int position = 0;
        int[] parameters = new int[4];
        for (String parameter : word) {
            if (parameter.contains("R") || parameter.contains("r")) {
                parameters[position] = extractInt(parameter);
                position++;
            } else {
                parameters[2] = extractInt(parameter);
            }
        }

        switch (word[0]) {
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
            case "STX":
                return new STX(parameters);
            case "SUB":
                return new SUB(parameters);
        }
        throw new RuntimeException("Operation [" + word + "] not found");
    }

    int extractInt(String value) {
        return Integer.parseInt(value.replace("\\D", ""));
    }

}
