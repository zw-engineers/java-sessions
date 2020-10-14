package com.functional;

import io.vavr.collection.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class CapitaliseNamesTest {

    private static final String ARTEMAS = "artemas";
    private static final String SARAH = "sarah";
    private static final String TOM = "tom";
    private static final String HARRY = "harry";
    private static final String MARTHA = "martha";
    private CapitaliseNames capitaliseNames;

    @BeforeEach
    void setup() {
        capitaliseNames = new CapitaliseNames();
    }

    @Test
    @DisplayName("Should return all names in the list")
    void returnAllNamesInListAsUppercase() {
        List<String> names = List.of(ARTEMAS, SARAH, TOM, HARRY, MARTHA);

        List<String> capitalisedNames = capitaliseNames.getNamesCapitalised(names);

        assertThat(capitalisedNames)
                .isNotEmpty()
                .hasSize(5)
                .containsExactly("ARTEMAS", "SARAH", "TOM", "HARRY", "MARTHA");
    }

    @Test
    @DisplayName("Should return an empty list if names list is null")
    void returnEmptyListWhenNamesIsNull() {
        List<String> capitalisedNames = capitaliseNames.getNamesCapitalised(null);

        assertThat(capitalisedNames).isEmpty();
    }

    @Test
    @DisplayName("Should return all non null names in uppercase")
    void returnNonNullNames() {
        List<String> names = List.of(ARTEMAS, SARAH, null, HARRY, MARTHA);

        List<String> capitalisedNames = capitaliseNames.getNamesCapitalised(names);

        assertThat(capitalisedNames)
                .isNotEmpty()
                .hasSize(4)
                .containsExactly("ARTEMAS", "SARAH", "HARRY", "MARTHA");
    }
}
