package problems;

import interfaces.Problem;

import java.util.List;

public class Problem_2024_04 implements Problem {
    @Override
    public String solvePart1(List<String> input) {

        int totalXmas = 0;

        // Horizontal + Reverse Horizontal
        for (String s : input) {
            for (int i = 0; i < s.length() - 3; i++) {
                if ("XMAS".equals(s.substring(i, i + 4)) || "SAMX".equals(s.substring(i, i + 4))) {
                    totalXmas++;
                }
            }
        }

        int height = input.size();

        // Vertical + Reverse Vertical
        for (int i = 0; i < input.getFirst().length() - 3; i++) {
            for (int h = 0; h < height; h++) {
                if ("X".equals(input.get(i).substring(h, h + 1)) && "M".equals(input.get(i + 1).substring(h, h + 1))
                && "A".equals(input.get(i + 2).substring(h, h + 1)) && "S".equals(input.get(i + 3).substring(h, h + 1))) {
                    totalXmas++;
                }
                if ("S".equals(input.get(i).substring(h, h + 1)) && "A".equals(input.get(i + 1).substring(h, h + 1))
                        && "M".equals(input.get(i + 2).substring(h, h + 1)) && "X".equals(input.get(i + 3).substring(h, h + 1))) {
                    totalXmas++;
                }
            }
        }

        // Diagonal
        for (int i = 0; i < input.getFirst().length() - 3; i++) {
            for (int h = 0; h < height - 3; h++) {
                if ("X".equals(input.get(i).substring(h, h + 1)) && "M".equals(input.get(i + 1).substring(h + 1, h + 2))
                        && "A".equals(input.get(i + 2).substring(h + 2, h + 3)) && "S".equals(input.get(i + 3).substring(h + 3, h + 4))) {
                    totalXmas++;
                }
                if ("S".equals(input.get(i).substring(h, h + 1)) && "A".equals(input.get(i + 1).substring(h + 1, h + 2))
                        && "M".equals(input.get(i + 2).substring(h + 2, h + 3)) && "X".equals(input.get(i + 3).substring(h + 3, h + 4))) {
                    totalXmas++;
                }
            }
        }

        // Other Diagonal
        for (int i = 0; i < input.getFirst().length() - 3; i++) {
            for (int h = 0; h < height - 3; h++) {
                if ("X".equals(input.get(i).substring(h + 3, h + 4)) && "M".equals(input.get(i + 1).substring(h + 2, h + 3))
                        && "A".equals(input.get(i + 2).substring(h + 1, h + 2)) && "S".equals(input.get(i + 3).substring(h, h + 1))) {
                    totalXmas++;
                }
                if ("S".equals(input.get(i).substring(h + 3, h + 4)) && "A".equals(input.get(i + 1).substring(h + 2, h + 3))
                        && "M".equals(input.get(i + 2).substring(h + 1, h + 2)) && "X".equals(input.get(i + 3).substring(h, h + 1))) {
                    totalXmas++;
                }
            }
        }

        return "XMAS: " + totalXmas;
    }

    @Override
    public String solvePart2(List<String> input) {

        int totalMas = 0;

        for (int y = 0; y < input.size() - 2; y++) {
            for (int x = 0; x < input.get(y).length() - 2; x++) {
                if ("A".equals(input.get(y + 1).substring(x + 1, x + 2)) &&
                        (("M".equals(input.get(y).substring(x, x + 1)) && "S".equals(input.get(y + 2).substring(x + 2, x + 3)))
                        || ("S".equals(input.get(y).substring(x, x + 1)) && "M".equals(input.get(y + 2).substring(x + 2, x + 3))))

                        &&

                        (("M".equals(input.get(y + 2).substring(x, x + 1)) && "S".equals(input.get(y).substring(x + 2, x + 3)))
                        || ("S".equals(input.get(y + 2).substring(x, x + 1)) && "M".equals(input.get(y).substring(x + 2, x + 3))))) {
                    totalMas++;
                }
            }
        }

        return "MAS: " + totalMas;
    }
}
