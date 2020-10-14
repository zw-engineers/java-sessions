package com.stringsio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExampleIOTest {

    private ExampleIO exampleIO;

    @BeforeEach
    void before() {
        exampleIO = new ExampleIO();
    }

    @Test
    @DisplayName("Should return true when file location exists and file contains ERROR word")
    void should_return_true_when_file_location_exists_and_file_contains_ERROR_word() {
        String location = "src/main/resources/example.txt";
        
        boolean doesFileExist = exampleIO.doesFileExist(location);
        
        assertThat(doesFileExist).isTrue();
    }

    @Test
    @DisplayName("Should return false when file location is invalid")
    void should_return_false_when_file_location_is_invalid() {
        String location = "example.txt";

        boolean doesFileExist = exampleIO.doesFileExist(location);
        
        assertThat(doesFileExist).isFalse();
    }

    @Test
    @DisplayName("Should return No Such Element Exception when file does not contain ERROR word")
    void should_return_NoSuchElementException_when_file_does_not_contain_ERROR_word() {
        assertThrows(NoSuchElementException.class, () -> {
            String location = "src/main/resources/people.txt";

            boolean doesFileExist = exampleIO.doesFileExist(location);
            
            assertThat(doesFileExist).isFalse();
        });
    }

    @Test
    @DisplayName("Should return true when file location exists and file contains Artemas")
    void should_return_true_when_file_location_exists_and_file_contains_Artemas() {
        String firstPath = "src/";
        String more = "main/resources";
        String fileName = "people.txt";

        boolean doesFileExists = exampleIO.doesFileExists(firstPath, more, fileName);
        
        assertThat(doesFileExists).isTrue();
    }

    @Test
    @DisplayName("Should return false when file does not exist")
    void should_return_false_when_file_does_not_exist() {
        String firstPath = "src/main/resources";
        String more = "artemas.txt";
        
        boolean doesFileExists = exampleIO.doesFileExists(firstPath, more);
        
        assertThat(doesFileExists).isFalse();
    }

    @Test
    @DisplayName("Should return No Such Element Exception when file does not contain Artemas word")
    void should_return_NoSuchElementException_when_file_does_not_contain_Artemas_word() {
        assertThrows(NoSuchElementException.class, () -> {
            String firstPath = "src/main/resources";
            String more = "example.txt";

            boolean doesFileExists = exampleIO.doesFileExists(firstPath, more);
            
            assertThat(doesFileExists).isFalse();
        });
    }

    @Test
    @DisplayName("Should return directories when a valid path is provided")
    void should_return_directories_when_a_valid_path_is_provided() {
        String path = "";

        List<Path> paths = exampleIO.directories(path);

        assertThat(paths.size()).isGreaterThan(0);
    }
}
