package problems;

import classes.Position;
import interfaces.Problem;

import java.util.*;

public class Problem_2024_08 implements Problem {
    @Override
    public String solvePart1(List<String> input) {

        HashMap<String, List<Position>> locations = new HashMap<>();
        HashSet<String> uniqueLocations = new HashSet<>();

        int yBounds = input.size();
        int xBounds = input.getFirst().length();

        for (int y = 0; y < input.size(); y++) {
            String[] gridRow = input.get(y).split("");
            for (int x = 0; x < gridRow.length; x++) {
                if (!".".equals(gridRow[x])) {
                    if (locations.containsKey(gridRow[x])) {
                        List<Position> oldPositions = locations.get(gridRow[x]);
                        oldPositions.add(new Position(x, y));
                    }
                    else {
                        List<Position> positions = new ArrayList<>();
                        positions.add(new Position(x, y));
                        locations.put(gridRow[x], positions);
                    }
                }
            }
        }

        // Iterate through locations to map frequencies
        for (String key : locations.keySet()) {
            List<Position> locationsByKey = locations.get(key);
            for (int i = 0; i < locationsByKey.size(); i++) {
                for (int j = 0; j < locationsByKey.size(); j++) {
                    if (i != j) {
                        // Add unique location
                        // Difference in location
                        int yDiff = Math.abs(locationsByKey.get(i).y - locationsByKey.get(j).y);
                        int xDiff = Math.abs(locationsByKey.get(i).x - locationsByKey.get(j).x);
                        // First location
                        int x1 = locationsByKey.get(i).x < locationsByKey.get(j).x ? (locationsByKey.get(i).x - xDiff) : (locationsByKey.get(i).x + xDiff);
                        int y1 = locationsByKey.get(i).y < locationsByKey.get(j).y ? (locationsByKey.get(i).y - yDiff) : (locationsByKey.get(i).y + yDiff);
                        if (x1 >= 0 && x1 < xBounds && y1 >= 0 && y1 < yBounds) {
                            Position pos = new Position(x1, y1);
                            uniqueLocations.add(pos.toHashValue());
                        }
                        // Second location
                        int x2 = locationsByKey.get(i).x < locationsByKey.get(j).x ? (locationsByKey.get(i).x - xDiff) : (locationsByKey.get(i).x + xDiff);
                        int y2 = locationsByKey.get(i).y < locationsByKey.get(j).y ? (locationsByKey.get(i).y - yDiff) : (locationsByKey.get(i).y + yDiff);
                        if (x2 >= 0 && x2 < xBounds && y2 >= 0 && y2 < yBounds) {
                            Position pos = new Position(x2, y2);
                            uniqueLocations.add(pos.toHashValue());
                        }
                    }
                }
            }
        }

        return "Unique locations: " + uniqueLocations.size();
    }

    @Override
    public String solvePart2(List<String> input) {

        HashMap<String, List<Position>> locations = new HashMap<>();
        HashSet<String> uniqueLocations = new HashSet<>();

        int yBounds = input.size();
        int xBounds = input.getFirst().length();

        for (int y = 0; y < input.size(); y++) {
            String[] gridRow = input.get(y).split("");
            for (int x = 0; x < gridRow.length; x++) {
                if (!".".equals(gridRow[x])) {
                    if (locations.containsKey(gridRow[x])) {
                        List<Position> oldPositions = locations.get(gridRow[x]);
                        oldPositions.add(new Position(x, y));
                    }
                    else {
                        List<Position> positions = new ArrayList<>();
                        positions.add(new Position(x, y));
                        locations.put(gridRow[x], positions);
                    }
                }
            }
        }

        // Iterate through locations to map frequencies
        for (String key : locations.keySet()) {
            List<Position> locationsByKey = locations.get(key);
            for (int i = 0; i < locationsByKey.size(); i++) {
                for (int j = 0; j < locationsByKey.size(); j++) {
                    if (i != j) {
                        // Add unique location
                        // Difference in location
                        int yDiff = locationsByKey.get(i).y - locationsByKey.get(j).y;
                        int xDiff = locationsByKey.get(i).x - locationsByKey.get(j).x;

                        // Negative direction
                        int currentX = locationsByKey.get(i).x;
                        int currentY = locationsByKey.get(i).y;
                        while (currentX >= 0 && currentY >= 0 && currentX < xBounds && currentY < yBounds) {
                            Position pos = new Position(currentX, currentY);
                            uniqueLocations.add(pos.toHashValue());
                            currentX -= xDiff;
                            currentY -= yDiff;
                        }
                        // Positive direction
                        currentX = locationsByKey.get(i).x + xDiff;
                        currentY = locationsByKey.get(i).y + yDiff;
                        while (currentX >= 0 && currentY >= 0 && currentX < xBounds && currentY < yBounds) {
                            Position pos = new Position(currentX, currentY);
                            uniqueLocations.add(pos.toHashValue());
                            currentX += xDiff;
                            currentY += yDiff;
                        }
                    }
                }
            }
        }

        return "Unique locations: " + uniqueLocations.size();
    }
}