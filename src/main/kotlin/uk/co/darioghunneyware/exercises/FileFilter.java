package uk.co.darioghunneyware.exercises;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileFilter {
    public static String solution(String S) {
        double fileSizeLimit = 14 * Math.pow(2, 20);
        String dateFormat = "dd MMM yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat, Locale.ENGLISH);
        String[] lines = S.split("\\n");
        List<List<String>> filteredFiles = new java.util.ArrayList<>();

        Arrays.stream(lines)
                .forEach(line -> {
                    List<String> file = new java.util.ArrayList<>(Arrays.stream(line.split(" ")).toList());
                    file.removeAll(List.of(""));
                    int fileSize = Integer.parseInt(file.get(5));

                    if (file.get(0).equals("admin") && file.get(1).contains("x") && fileSize < fileSizeLimit) {
                        filteredFiles.add(file);
                    }
                });

        filteredFiles.sort((file1, file2) -> {
            LocalDate date1 = LocalDate.parse(file1.get(2) + " " + file1.get(3) + " " + file1.get(4), formatter);
            LocalDate date2 = LocalDate.parse(file2.get(2) + " " + file2.get(3) + " " + file2.get(4), formatter);

            return date1.compareTo(date2);
        });

        Optional<List<String>> fileOptional = filteredFiles.stream()
                .findFirst();

        if (fileOptional.isPresent()) {
            List<String> earliestModifiedFile = fileOptional.get();
            return earliestModifiedFile.get(2) + " " + earliestModifiedFile.get(3) + " " + earliestModifiedFile.get(4);
        } else {
            return "NO FILES";
        }
    }
}
