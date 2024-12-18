package problems;

import classes.FileBlock;
import classes.FileBlockSegment;
import interfaces.Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem_2024_09 implements Problem {
    @Override
    public String solvePart1(List<String> input) {
        // Reformat input
        List<FileBlock> fileBlocks = new ArrayList<>();
        int id = 0;
        long pos = 0;
        boolean discs = true;
        char[] charArray = input.getFirst().toCharArray();
        for (char c : charArray) {
            for (int j = 0; j < Character.getNumericValue(c); j++) {
                fileBlocks.add(new FileBlock(discs ? id : null, pos++));
            }
            if (discs) {
                id++;
            }
            discs = !discs;
        }

        int l = 0;
        int r = fileBlocks.size() - 1;

        while (l < r) {
            if (fileBlocks.get(l).id == null) {
                fileBlocks.get(l++).id = fileBlocks.get(r).id;
                fileBlocks.get(r--).id = null;
                while (r > 0 && fileBlocks.get(r).id == null) {
                    r--;
                }
            }
            else {
                l++;
            }
        }

        long productSum = 0;
        for (FileBlock fileBlock : fileBlocks) {
            if (fileBlock.id == null) {
                break;
            } else {
                productSum += fileBlock.getValueByPos();
            }
        }
        return "Testing part 1: " + productSum;
    }

    @Override
    public String solvePart2(List<String> input) {
        // Reformat input
        List<FileBlock> fileBlocks = new ArrayList<>();
        int id = 0;
        long pos = 0;
        boolean discs = true;
        char[] charArray = input.getFirst().toCharArray();
        for (char c : charArray) {
            for (int j = 0; j < Character.getNumericValue(c); j++) {
                fileBlocks.add(new FileBlock(discs ? id : null, pos++));
            }
            if (discs) {
                id++;
            }
            discs = !discs;
        }

        // Create file block segments
        List<FileBlockSegment> segments = new ArrayList<>();
        int currentLength = 0;
        for (int i = 0; i < fileBlocks.size(); i++) {
            if (fileBlocks.get(i).id == null) {
                currentLength++;
            }
            else if (currentLength > 0) {
                segments.add(new FileBlockSegment(i - currentLength, currentLength));
                currentLength = 0;
            }
        }

        // Now go through and fill in where appropriate
        Integer rValue = null;
        int rLength = 0;
        System.out.println(segments.subList(0, 100));
        System.out.println(fileBlocks.subList(0, 50));

        for (int r = fileBlocks.size() - 1; r >= 0; r--) {
            FileBlock fb = fileBlocks.get(r);
            if (rLength == 0) {
                rValue = fb.id;
                if (rValue != null) {
                    rLength++;
                }
            }
            else if (fb.id == rValue) {
                rLength++;
            }
            else {
                // Try to place
                for (FileBlockSegment seg : segments) {
                    if (seg.size >= rLength && seg.index < (r + 1)) {
                        // Place
                        for (int i = seg.index; i < seg.index + rLength; i++) {
                            fileBlocks.get(i).id = rValue;
                        }
                        // Update segments
                        if (seg.size == rLength) {
                            segments.remove(seg);
                        }
                        else {
                            seg.size -= rLength;
                            seg.index += rLength;
                        }
                        // Remove
                        for (int i = r + 1; i < r + 1 + rLength; i++) {
                            fileBlocks.get(i).id = null;
                        }
                        break;
                    }
                }
                if (fb.id == null) {
                    rValue = null;
                    rLength = 0;
                }
                else {
                    rValue = fb.id;
                    rLength = 1;
                }
            }
        }
        System.out.println(fileBlocks.subList(0, 50));

        long productSum = 0;
        for (FileBlock fileBlock : fileBlocks) {
            if (fileBlock.id != null) {
                productSum += fileBlock.getValueByPos();
            }
        }
        return "Testing part 2: " + productSum;
    }
}
