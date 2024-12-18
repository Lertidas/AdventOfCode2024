package problems;

import interfaces.Problem;

import java.util.List;

public class Problem_2024_03 implements Problem {
    @Override
    public String solvePart1(List<String> input) {
        StringBuilder fullInputString = new StringBuilder();
        for (String s : input) {
            fullInputString.append(s);
        }
        return solveMultPart(fullInputString.toString()).toString();
    }

    @Override
    public String solvePart2(List<String> input) {

        StringBuilder fullInputString = new StringBuilder();
        for (String s : input) {
            fullInputString.append(s);
        }

        String[] doSplit = fullInputString.toString().split("do\\(\\)");

        Integer total = 0;
        for (String s : doSplit) {
            total += solveMultPart(s.split("don't\\(\\)")[0]);
        }

        return total.toString();
    }

    public Integer solveMultPart(String input) {

        String[] splitIt = input.split("mul\\(");
        // Take off closing parenthesis
        for (int i = 0; i < splitIt.length; i++) {
            String[] closingSplit = splitIt[i].split("\\)");
            splitIt[i] = closingSplit.length > 0 ? closingSplit[0] : "";
        }

        Integer productSum = 0;
        for (String s : splitIt) {
            String[] finalSplit = s.split(",");
            if (finalSplit.length == 2 && !finalSplit[0].isEmpty() && finalSplit[0].length() <= 3
                    && !finalSplit[1].isEmpty() && finalSplit[1].length() <= 3) {
                Integer value1 = Integer.parseInt(finalSplit[0]);
                Integer value2 = Integer.parseInt(finalSplit[1]);
                productSum += (value1 * value2);
            }
        }

        return productSum;
    }
}
