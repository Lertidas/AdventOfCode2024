package problems;

import interfaces.Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem_2024_02 implements Problem {
    @Override
    public String solvePart1(List<String> input) {
        int correctReports = 0;
        for (String report : input) {
            boolean correct = true;
            List<String> data = List.of(report.split(" "));
            boolean negative = Integer.valueOf(data.get(0)) - Integer.valueOf(data.get(1)) < 0;
            for (int i = 0; i < data.size() - 1; i++) {
                int value = Integer.valueOf(data.get(i)) - Integer.valueOf(data.get(i + 1));
                int absValue = Math.abs(value);
                if ((negative && value > 0) || (!negative && value < 0) || absValue > 3 || absValue < 1) {
                    correct = false;
                }
            }
            if (correct) {
                correctReports++;
            }
        }
        return "Testing part 1: " + correctReports;
    }

    @Override
    public String solvePart2(List<String> input) {
        int correctReports = 0;
        for (String report : input) {
            boolean correct = true;
            List<String> data = List.of(report.split(" "));
            // Test all values
            boolean negative = Integer.valueOf(data.get(0)) - Integer.valueOf(data.get(1)) < 0;
            for (int i = 0; i < data.size() - 1; i++) {
                int value = Integer.valueOf(data.get(i)) - Integer.valueOf(data.get(i + 1));
                int absValue = Math.abs(value);
                if ((negative && value > 0) || (!negative && value < 0) || absValue > 3 || absValue < 1) {
                    correct = false;
                }
            }
            if (correct) {
                correctReports++;
            }
            else {
                correct = false;
                // Test by removing
                for (int indexToRemove = 0; indexToRemove < data.size(); indexToRemove++) {
                    boolean individualCorrect = true;
                    List<String> filteredData = new ArrayList<>();
                    for (int j = 0; j < data.size(); j++) {
                        if (j != indexToRemove) {
                            filteredData.add(data.get(j));
                        }
                    }
                    // Test all values
                    negative = Integer.valueOf(filteredData.get(0)) - Integer.valueOf(filteredData.get(1)) < 0;
                    for (int i = 0; i < filteredData.size() - 1; i++) {
                        int value = Integer.valueOf(filteredData.get(i)) - Integer.valueOf(filteredData.get(i + 1));
                        int absValue = Math.abs(value);
                        if ((negative && value > 0) || (!negative && value < 0) || absValue > 3 || absValue < 1) {
                            individualCorrect = false;
                        }
                    }
                    if (individualCorrect) {
                        correct = true;
                    }
                }
                if (correct) {
                    correctReports++;
                }
            }
        }
        return "Testing part 2: " + correctReports;
    }
}
