package src.day10;

import java.util.List;

import src.FileUtil;

public class Day10 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Day[n] [fileName]");
            System.exit(1);
        }
        List<String> fileContents = FileUtil.readFile(args[0]);

        CPU cpu = processInstructions(fileContents);

        int signalSum = getSignalStrength(cpu);
        System.out.printf("The sum of signal strengths is: %d%n", signalSum);

        drawStuff(cpu);
    }

    private static CPU processInstructions(List<String> data) {
        CPU cpu = new CPU();
        for (String s : data) {
            String[] opString = s.split(" ");
            if (opString[0].equals("noop")) {
                cpu.noop();
            } else {
                cpu.addx(Integer.parseInt(opString[1]));
            }
        }
        return cpu;
    }

    private static int getSignalStrength(CPU cpu) {
        int sum = 0;
        for (int i = 20; i < 221; i += 40) {
            sum += cpu.getSignalStrength(i);
        }
        return sum;
    }

    private static void drawStuff(CPU cpu) {
        final int ROW_LENGTH = 40;
        int pixelOffset = 1;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 40; ++j) {
                int cycle = pixelOffset + j;
                int spriteLocation = cpu.getxAt(cycle);
                int distance = Math.abs(spriteLocation - j);
                if (distance <= 1) {
                    System.out.print('#');
                } else {
                    System.out.print('.');
                }
            }
            pixelOffset += ROW_LENGTH;
            System.out.println();
        }
    }
}
