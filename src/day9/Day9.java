package src.day9;

import java.util.List;

import src.FileUtil;

public class Day9 {

    private static int part1(List<String> data) {
        Rope rope = new Rope();
        for (String s : data) {
            try {
               rope.moveHead(s); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rope.squaresTailVisited();
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Day[n] [fileName]");
            System.exit(1);
        }
        List<String> fileContents = FileUtil.readFile(args[0]);

        int squaresVisited = part1(fileContents);
        System.out.printf("The tail has visited %d squares.%n", squaresVisited);
    }
}
