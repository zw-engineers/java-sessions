package com.functional;

import io.vavr.collection.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInDepthTest {

    private FunctionalInDepth functionalInDepth;

    @BeforeEach
    void setup() {
        functionalInDepth = new FunctionalInDepth();
    }

    @Test
    @DisplayName("Should return all names in the list")
    void returnAllNamesInListAsUppercase() {
        List<String> names = List.of("artemas", "sarah", "tom", "harry", "martha");

        List<String> capitalisedNames = functionalInDepth.getNamesCapitalised(names);

        assertThat(capitalisedNames).isNotEmpty();
    }

    @Test
    @DisplayName("Should return an empty list if names list is null")
    void returnEmptyListWhenNamesIsNull() {
        List<String> capitalisedNames = functionalInDepth.getNamesCapitalised(null);

        assertThat(capitalisedNames).isEmpty();
    }
}
