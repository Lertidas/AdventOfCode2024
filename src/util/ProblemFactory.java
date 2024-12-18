package util;

import interfaces.Problem;
import problems.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProblemFactory {
    private static final Map<String, Supplier<Problem>> problemMap = new HashMap<>();

    static {
        problemMap.put("2023-01", Problem_2023_01::new);
        problemMap.put("2024-01", Problem_2024_01::new);
        problemMap.put("2024-02", Problem_2024_02::new);
        problemMap.put("2024-03", Problem_2024_03::new);
        problemMap.put("2024-04", Problem_2024_04::new);
        problemMap.put("2024-05", Problem_2024_05::new);
        problemMap.put("2024-06", Problem_2024_06::new);
        problemMap.put("2024-07", Problem_2024_07::new);
        problemMap.put("2024-08", Problem_2024_08::new);
        problemMap.put("2024-09", Problem_2024_09::new);
    }

    public static Problem createProblem(String problemId) {

        Supplier<Problem> problemSupplier = problemMap.get(problemId);
        if (problemSupplier != null) {
            return problemSupplier.get();
        } else {
            throw new IllegalArgumentException("Problem: " + problemId + " does not exist.");
        }
    }
}
