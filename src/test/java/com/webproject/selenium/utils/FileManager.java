package com.webproject.selenium.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {
    public static File getRecursiveFiles(String directory, String filename) throws Exception {
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            List<File> matchingFiles = paths
                    .filter(Files::isRegularFile)
                    .filter((f) -> f.toFile().getName().replaceAll("\\..+", "").equals(filename))
                    .map(Path::toFile)
                    .collect(Collectors.toList());

            if (!matchingFiles.isEmpty()) {
                return matchingFiles.get(0);
            } else {
                // If no matching files, get the first regular file in the directory
                try (Stream<Path> allPaths = Files.walk(Paths.get(directory))) {
                    return allPaths
                            .filter(Files::isRegularFile)
                            .map(Path::toFile)
                            .findFirst()
                            .orElseThrow(() -> new Exception("No regular files found in the directory"));
                }
            }
        }
    }

}
