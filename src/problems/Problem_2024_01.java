package problems;

import interfaces.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem_2024_01 implements Problem {
    @Override
    public String solvePart1(List<String> input) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (String s : input) {
            left.add(Integer.valueOf(s.toString().split("   ")[0]));
            right.add(Integer.valueOf(s.toString().split("   ")[1]));
        }

        // Sort
        Collections.sort(left);
        Collections.sort(right);

        int totalDistance = 0;
        for (int i = 0; i < left.size(); i++) {
            totalDistance += (Math.abs(left.get(i) - right.get(i)));
        }

        return String.valueOf(totalDistance);
    }

    @Override
    public String solvePart2(List<String> input) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (String s : input) {
            left.add(Integer.valueOf(s.toString().split("   ")[0]));
            right.add(Integer.valueOf(s.toString().split("   ")[1]));
        }

        // Sort
        Collections.sort(left);
        Collections.sort(right);

        int totalDistance = 0;
        for (int i = 0; i < left.size(); i++) {
            int totalOccurances = 0;
            for (int j = 0; j < right.size(); j++) {
                if (Objects.equals(left.get(i), right.get(j))) {
                    totalOccurances++;
                }
            }
            totalDistance += (left.get(i) * totalOccurances);
        }

        return String.valueOf(totalDistance);
    }
}
