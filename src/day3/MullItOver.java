package day3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {

    public static void main(String[] args) {
        List<String> matrix = readInput().lines().toList();
        part1(matrix);

        part2(matrix);
    }

    private static String readInput() {
        try {
            return Files.readString(new File("src/day3/input").getAbsoluteFile().toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void part1(List<String> matrix) {

        int total = 0;
        for (String line : matrix) {

            Pattern pattern = Pattern.compile("mul\\(\\d+(,\\d+)*\\)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String[] values = matcher.group().replaceAll("\\D", " ").trim().split(" ");
                if (values.length == 2) {
                    total += Integer.parseInt(values[0]) * Integer.parseInt(values[1]);
                }
            }
        }

        System.out.println(total);

    }

    public static void part2(List<String> matrix) {
        int total = 0;
        boolean doNext = true;
        for (String line : matrix) {
            boolean start = true;

            Pattern pattern = Pattern.compile("mul\\(\\d+(,\\d+)*\\)|do\\(\\)|don't\\(\\)");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String foundValue = matcher.group();

                if (start || (doNext && !foundValue.contains("do"))) {

                    System.out.println("Processing: " + foundValue);
                    String[] values = foundValue.replaceAll("\\D", " ").trim().split(" ");
                    if (values.length == 2) {
                        System.out.println("mul(" + values[0] + "," + values[1] + ")");
                        total += Integer.parseInt(values[0]) * Integer.parseInt(values[1]);
                    }
                    start = false;
                } else {
                    System.out.println("Ignoring: " + foundValue);
                }

                if (foundValue.equalsIgnoreCase("do()")) {
                    doNext = true;
                } else if (foundValue.equalsIgnoreCase("don't()")) {
                    doNext = false;
                }
            }
        }
        System.out.println(total);
    }


}
