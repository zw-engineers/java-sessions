package com.stringsio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class ExampleIO {

    public boolean doesFileExist (String fileLocation) {

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

}
