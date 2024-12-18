package problems;

import classes.Direction;
import classes.Position;
import interfaces.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem_2024_06 implements Problem {
    @Override
    public String solvePart1(List<String> input) {

        List<List<String>> grid = new ArrayList<>();
        for (String s : input) {
            grid.add(Arrays.asList(s.split("")));
        }

        HashSet<String> visitedSpots = new HashSet<>();

        // Find initial position
        Position position = new Position(0, 0, Direction.UP);

        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(y).size(); x++) {
                if ("^".equals(grid.get(y).get(x))) {
                    position.y = y;
                    position.x = x;
                    position.direction = Direction.UP;
                }
                else if (">".equals(grid.get(y).get(x))) {
                    position.y = y;
                    position.x = x;
                    position.direction = Direction.RIGHT;
                }
                else if ("v".equals(grid.get(y).get(x))) {
                    position.y = y;
                    position.x = x;
                    position.direction = Direction.DOWN;
                }
                else if ("<".equals(grid.get(y).get(x))) {
                    position.y = y;
                    position.x = x;
                    position.direction = Direction.LEFT;
                }
            }
        }
        visitedSpots.add(position.toHashValue());

        // Take actions until done
        while (!finished(position, grid.size(), grid.getFirst().size())) {
            position = takeAction(position, grid);
            visitedSpots.add(position.toHashValue());
        }

        return "Testing part 1: " + visitedSpots.size();
    }

    @Override
    public String solvePart2(List<String> input) {

        List<List<String>> grid = new ArrayList<>();
        for (String s : input) {
            grid.add(Arrays.asList(s.split("")));
        }

        int stuckPositions = 0;
        for (int yGridPos = 0; yGridPos < grid.size(); yGridPos++) {
            for (int xGridPos = 0; xGridPos < grid.get(yGridPos).size(); xGridPos++) {


                // Create grid with obstacle
                List<List<String>> newGrid = new ArrayList<>();
                for (int yNewGrid = 0; yNewGrid < grid.size(); yNewGrid++) {
                    newGrid.add(new ArrayList<>());
                    for (int xNewGrid = 0; xNewGrid < grid.get(yNewGrid).size(); xNewGrid++) {
                        if (yNewGrid == yGridPos && xNewGrid == xGridPos) {
                            newGrid.get(yNewGrid).add("#");
                        }
                        else {
                            newGrid.get(yNewGrid).add(grid.get(yNewGrid).get(xNewGrid));
                        }
                    }
                }

                HashSet<String> visitedSpots = new HashSet<>();

                // Find initial position
                Position position = new Position(0, 0, Direction.UP);

                for (int y = 0; y < newGrid.size(); y++) {
                    for (int x = 0; x < newGrid.get(y).size(); x++) {
                        if ("^".equals(newGrid.get(y).get(x))) {
                            position.y = y;
                            position.x = x;
                            position.direction = Direction.UP;
                        }
                        else if (">".equals(newGrid.get(y).get(x))) {
                            position.y = y;
                            position.x = x;
                            position.direction = Direction.RIGHT;
                        }
                        else if ("v".equals(newGrid.get(y).get(x))) {
                            position.y = y;
                            position.x = x;
                            position.direction = Direction.DOWN;
                        }
                        else if ("<".equals(newGrid.get(y).get(x))) {
                            position.y = y;
                            position.x = x;
                            position.direction = Direction.LEFT;
                        }
                    }
                }
                visitedSpots.add(position.toDirectionHashValue());

                // Take actions until done
                boolean breakLoop = false;
                while (!breakLoop && !finished(position, newGrid.size(), newGrid.getFirst().size())) {
                    position = takeAction(position, newGrid);
                    if (visitedSpots.contains(position.toDirectionHashValue())) {
                        stuckPositions++;
                        breakLoop = true;
                    }
                    else {
                        visitedSpots.add(position.toDirectionHashValue());
                    }
                }
            }
        }
        return "Part 2: Stuck positions " + stuckPositions;
    }

    public Position takeAction(Position startingPosition, List<List<String>> grid) {
        int moveY = startingPosition.y;
        int moveX = startingPosition.x;
        switch (startingPosition.direction) {
            case Direction.UP -> moveY -= 1;
            case Direction.RIGHT -> moveX += 1;
            case Direction.DOWN -> moveY += 1;
            case Direction.LEFT -> moveX -= 1;
        }

        // Rotate
        if ("#".equals(grid.get(moveY).get(moveX))) {
            Direction newDirection = startingPosition.direction;
            switch (startingPosition.direction) {
                case Direction.UP -> newDirection = Direction.RIGHT;
                case Direction.RIGHT -> newDirection = Direction.DOWN;
                case Direction.DOWN -> newDirection = Direction.LEFT;
                case Direction.LEFT -> newDirection = Direction.UP;
            }
            return new Position(startingPosition.x, startingPosition.y, newDirection);
        }
        // Move
        else {
            return new Position(moveX, moveY, startingPosition.direction);
        }
    }

    public boolean finished(Position position, int height, int width) {
        switch (position.direction) {
            case Direction.UP -> {
                return position.y == 0;
            }
            case Direction.RIGHT -> {
                return position.x == width - 1;
            }
            case Direction.DOWN -> {
                return position.y == height - 1;
            }
            case Direction.LEFT -> {
                return position.x == 0;
            }
        }
        return false;
    }
}
