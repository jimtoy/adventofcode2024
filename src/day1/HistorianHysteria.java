package day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorianHysteria {

    public static void main(String[] args) {
        List<String> matrix = readInput().lines().toList();
        part1(matrix);
        part2(matrix);

    }

    private static String readInput() {
        try {
            return Files.readString(new File("src/day1/input").getAbsoluteFile().toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void part1(List<String> matrix) {
        List<Integer> groupOne = new ArrayList<>();
        List<Integer> groupTwo = new ArrayList<>();
        for (String line : matrix) {
            String[] numbers = line.split("\\s+");
            groupOne.add(Integer.parseInt(numbers[0]));
            groupTwo.add(Integer.parseInt(numbers[1]));
        }
        Collections.sort(groupOne);
        Collections.sort(groupTwo);
        int sum = 0;
        for (int i = 0; i < groupOne.size(); i++) {
            System.out.println(groupOne.get(i) + " " + groupTwo.get(i));
            sum += Math.abs(groupOne.get(i) - groupTwo.get(i));
        }
        System.out.println(sum);
    }

    private static void part2(List<String> matrix) {

    }
}
