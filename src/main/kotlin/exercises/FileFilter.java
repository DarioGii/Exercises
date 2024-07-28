package exercises;

import java.util.Arrays;
import java.util.List;

public class FileFilter {
    public String solution(String S) {
        double fileSizeLimit = 14 * Math.pow(2, 20);
        String[] lines = S.split("\\n");
        List<List<String>> filteredFiles = new java.util.ArrayList<>();


        Arrays.stream(lines)
                .forEach(line -> {
                    List<String> file = Arrays.stream(line.split(" ")).toList();
                    int fileSize = Integer.parseInt(file.get(5));

                    if (file.get(0).equals("admin") && file.get(1).contains("x") && fileSize <= fileSizeLimit) {
                        filteredFiles.add(file);
                    }
                });

    }
}
