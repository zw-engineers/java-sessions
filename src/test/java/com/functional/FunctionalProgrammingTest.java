package com.functional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.functional.FunctionalProgramming.mapNamesToAgesWithGuavaStreams;
import static com.functional.FunctionalProgramming.mapNamesToAgesWithJavaStreams;
import static org.assertj.core.api.Assertions.assertThat;

class FunctionalProgrammingTest {

    private final static List<String> names = List.of("John", "Jane", "Jack", "Dennis"); // 4 names
    private final static List<Integer> ages = List.of(24, 25, 27, 29, 30); // 5 ages
    private static final String[] NAMES_WITH_AGES = {"John:24", "Jane:25", "Jack:27", "Dennis:29"};


    @Test
    @DisplayName("Should zip ages collection to names collection")
    void zipFunctionWithJavaStreams() {
        List<String> mappedAgesToNames = mapNamesToAgesWithJavaStreams(names, ages);

        assertThat(mappedAgesToNames).isNotEmpty();
        assertThat(mappedAgesToNames).hasSize(4);
        assertThat(mappedAgesToNames).containsExactly(NAMES_WITH_AGES);
    }

    @Test
    @DisplayName("Should zip ages collection to names collection with Guava")
    void zipFunctionWithGuava() {
        List<String> mappedAgesToNames = mapNamesToAgesWithGuavaStreams(names, ages);

        assertThat(mappedAgesToNames).isNotEmpty();
        assertThat(mappedAgesToNames).hasSize(4);
        assertThat(mappedAgesToNames).containsExactly(NAMES_WITH_AGES);
    }
}
