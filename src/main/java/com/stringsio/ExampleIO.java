package com.stringsio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ExampleIO {

    boolean doesFileExist(String fileLocation) {

        // Java 7 : try with resources
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(new File(fileLocation))
                     )
        ) {
            Stream<String> stream = reader.lines();
            return stream.filter(line -> line.contains("ERROR"))
                    .findFirst().get().length() > 0;
        } catch (IOException e) {
            e.getMessage();
        }

        return false;
    }

    boolean doesFileExists(String initialPathString, String... more) {
        // Java 7 : try with resources and use of Paths
        Path path = Paths.get(initialPathString, more);
        try (Stream<String> stream = Files.lines(path)) {
            return stream.filter(line -> line.contains("Artemas"))
                    .findFirst()
                    .get()
                    .length() > 0;
        } catch (IOException e) {
            e.getMessage();
        }
        return false;
    }

    List<Path> directories(String pathDirectory) {

        List<Path> directories = new ArrayList<>();
        // Java 7 : try with resources and use of Paths
        Path path = Paths.get(pathDirectory);
        try (Stream<Path> stream = Files.list(path)) {
            directories = stream.filter(p -> p.toFile().isDirectory()).collect(Collectors.toList());
            return directories;
        } catch (IOException e) {
            e.getMessage();
        }

        return directories;
    }

}
