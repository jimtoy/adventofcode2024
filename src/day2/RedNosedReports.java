package day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class RedNosedReports {
    public static void main(String[] args) {
        List<String> matrix = readInput().lines().toList();
        part1(matrix);
        part2(matrix);

    }

    private static String readInput() {
        try {
            return Files.readString(new File("src/day2/input").getAbsoluteFile().toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void part1(List<String> matrix) {

        int safeCounter = 0;
        boolean safe;
        for (String line : matrix) {
            int prev = -1;
            safe = false;
            String[] values = line.split(" ");
            boolean ascending = Integer.parseInt(values[0]) <= Integer.parseInt(values[values.length - 1]);

            for (int i = 0; i < values.length; i++) {
                int current = Integer.parseInt(values[i]);
                if (i == 0) {
                    prev = Integer.parseInt(values[i]);
                    continue;
                }

                safe = isSafe(prev, current, ascending);
                if (!safe) {
                    break;
                }

                prev = current;

            }
            if (safe) {
                safeCounter++;
            }
        }
        System.out.println(safeCounter);

    }

    public static boolean isSafe(int previous, int current, boolean ascending) {

        int diff = previous - current;

        if (!ascending) {
            return previous > current && diff <= 3;

        } else {
            return previous < current && diff >= -3;
        }

    }

    public static void part2(List<String> matrix) {

    }
}

