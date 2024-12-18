package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    public static List<String> read(String year, String day) throws FileNotFoundException{
        List<String> inputList = new ArrayList<>();
        File f = new File("src/input/" + year + "_" + day + ".txt");
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            inputList.add(s.nextLine());
        }
        s.close();
        return inputList;
    }
}
