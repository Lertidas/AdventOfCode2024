import interfaces.Problem;
import util.InputReader;
import util.ProblemFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Problem problem = ProblemFactory.createProblem(args[0] + "-" + args[1]);
        List<String> inputArray;
        try {
            inputArray = InputReader.read(args[0], args[1]);
        }
        catch (FileNotFoundException e) {
            System.out.println("Exception: " + e);
            return;
        }
        // Solve problems
        System.out.println("\nProblem " + args[0] + " " + args[1] + "\n");
        System.out.println("Problem 1: " + problem.solvePart1(inputArray));
        System.out.println("Problem 2: " + problem.solvePart2(inputArray)+"\n");
    }
}

