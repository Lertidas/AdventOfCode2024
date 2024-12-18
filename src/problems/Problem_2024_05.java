package problems;

import interfaces.Problem;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_2024_05  implements Problem {
    @Override
    public String solvePart1(List<String> input) {

        // Split up input into two parts
        int index = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isEmpty()) {
                index = i;
            }
        }

        List<String> comparators = input.subList(0, index);
        List<String> sequences = input.subList(index + 1, input.size());

        HashMap<String, List<String>> before = new HashMap<>();
        HashMap<String, List<String>> after = new HashMap<>();

        for (String s : comparators) {
            String[] result = s.split("\\|");
            // After
            List<String> current = after.get(result[0]);
            if (current == null) {
                current = new ArrayList<>();
                current.add(result[1]);
                after.put(result[0], current);
            }
            else {
                current.add(result[1]);
            }

            // Before
            current = before.get(result[1]);
            if (current == null) {
                current = new ArrayList<>();
                current.add(result[0]);
                before.put(result[1], current);
            }
            else {
                current.add(result[0]);
            }
        }

        int sumCount = 0;
        for (String sequence : sequences) {
            String[] numbers = sequence.split(",");
            boolean fail = false;

            for (int i = 0; i < numbers.length; i++) {
                String value = numbers[i];
                for (int j = i + 1; j < numbers.length; j++) {
                    if (before.containsKey(value) && before.get(value).contains(numbers[j])) {
                        fail = true;
                    }
                }
            }

            if (!fail) {
                sumCount += Integer.parseInt(numbers[numbers.length / 2]);
            }
        }

        return "Answer: " + sumCount;
    }

    @Override
    public String solvePart2(List<String> input) {

        // Split up input into two parts
        int index = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isEmpty()) {
                index = i;
            }
        }

        List<String> comparators = input.subList(0, index);
        List<String> sequences = input.subList(index + 1, input.size());

        HashMap<String, List<String>> before = new HashMap<>();
        HashMap<String, List<String>> after = new HashMap<>();

        for (String s : comparators) {
            String[] result = s.split("\\|");
            // After
            List<String> current = after.get(result[0]);
            if (current == null) {
                current = new ArrayList<>();
                current.add(result[1]);
                after.put(result[0], current);
            }
            else {
                current.add(result[1]);
            }

            // Before
            current = before.get(result[1]);
            if (current == null) {
                current = new ArrayList<>();
                current.add(result[0]);
                before.put(result[1], current);
            }
            else {
                current.add(result[0]);
            }
        }

        int incorrectMiddleCount = 0;
        for (String sequence : sequences) {
            String[] numbers = sequence.split(",");
            boolean fail = false;

            for (int i = 0; i < numbers.length; i++) {
                String value = numbers[i];
                for (int j = i + 1; j < numbers.length; j++) {
                    if (before.containsKey(value) && before.get(value).contains(numbers[j])) {
                        fail = true;
                    }
                }
            }

            if (fail) {
                // Now that this is an incorrect sequence
                List<String> numbersList = Arrays.asList(numbers);
                int target = numbers.length / 2;
                int counter = -1;
                String currentVal = "";
                while (counter != target) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        String value = numbersList.get(i);
                        boolean hasNoBefore = true;
                        for (int j = 0; j < numbersList.size(); j++) {
                            if (j != i && before.containsKey(value) && before.get(value).contains(numbersList.get(j))) {
                                hasNoBefore = false;
                            }
                        }
                        if (hasNoBefore) {
                            numbersList = numbersList.stream().filter(v -> !value.equals(v)).toList();
                            currentVal = value;
                            break;
                        }
                    }
                    counter++;
                }
                incorrectMiddleCount += Integer.parseInt(currentVal);
            }
        }

        return "Answer: " + incorrectMiddleCount;
    }
}
