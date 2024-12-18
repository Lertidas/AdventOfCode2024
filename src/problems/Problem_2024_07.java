package problems;

import interfaces.Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem_2024_07 implements Problem {
    @Override
    public String solvePart1(List<String> input) {

        long totalSum = 0;

        for (String s : input) {
            long value = Long.parseLong(s.split(": ")[0]);
            String valuesString = s.split(": ")[1];
            String[] stringValues = valuesString.split(" ");
            List<Long> values = new ArrayList<>();
            for (String sv : stringValues) {
                values.add(Long.parseLong(sv));
            }
            if (equalsValue(value, 0, values)) {
                totalSum += value;
            }
        }

        return "Testing part 1: " + totalSum;
    }

    public boolean equalsValue(long target, long current, List<Long> values) {
        if (values.isEmpty()) {
            return target == current;
        }
        else {
            return equalsValue(target, current + values.getFirst(), values.subList(1, values.size())) ||
                    equalsValue(target, current * values.getFirst(), values.subList(1, values.size()));
        }
    }

    @Override
    public String solvePart2(List<String> input) {

        long totalSum = 0;

        for (String s : input) {
            long value = Long.parseLong(s.split(": ")[0]);
            String valuesString = s.split(": ")[1];
            String[] stringValues = valuesString.split(" ");
            List<Long> values = new ArrayList<>();
            for (String sv : stringValues) {
                values.add(Long.parseLong(sv));
            }
            if (equalsValueExtra(value, values.getFirst(), values.subList(1, values.size()))) {
                totalSum += value;
            }
        }

        return "Testing part 2: " + totalSum;
    }

    public boolean equalsValueExtra(long target, long current, List<Long> values) {
        if (values.isEmpty()) {
            return target == current;
        }
        else {
            return equalsValueExtra(target, Long.parseLong(Long.toString(current).concat(Long.toString(values.getFirst()))), values.subList(1, values.size())) ||
                    equalsValueExtra(target, current + values.getFirst(), values.subList(1, values.size())) ||
                    equalsValueExtra(target, current * values.getFirst(), values.subList(1, values.size()));
        }
    }
}
