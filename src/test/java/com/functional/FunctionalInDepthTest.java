package com.functional;

import io.vavr.collection.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInDepthTest {

    private static final String ARTEMAS = "artemas";
    private static final String SARAH = "sarah";
    private static final String TOM = "tom";
    private static final String HARRY = "harry";
    private static final String MARTHA = "martha";
    private FunctionalInDepth functionalInDepth;

    @BeforeEach
    void setup() {
        functionalInDepth = new FunctionalInDepth();
    }

    @Test
    @DisplayName("Should return all names in the list")
    void returnAllNamesInListAsUppercase() {
        List<String> names = List.of(ARTEMAS, SARAH, TOM, HARRY, MARTHA);

        List<String> capitalisedNames = functionalInDepth.getNamesCapitalised(names);

        assertThat(capitalisedNames).isNotEmpty();
        assertThat(capitalisedNames).hasSize(5);
        assertThat(capitalisedNames).containsExactly("ARTEMAS", "SARAH", "TOM", "HARRY", "MARTHA");
    }

    @Test
    @DisplayName("Should return an empty list if names list is null")
    void returnEmptyListWhenNamesIsNull() {
        List<String> capitalisedNames = functionalInDepth.getNamesCapitalised(null);

        assertThat(capitalisedNames).isEmpty();
    }

    @Test
    @DisplayName("Should return list of non null value names")
    void returnNonNullNames() {
        List<String> names = List.of(ARTEMAS, SARAH, null, HARRY, MARTHA);

        List<String> capitalisedNames = functionalInDepth.getNamesCapitalised(names);

        assertThat(capitalisedNames).isNotEmpty();
        assertThat(capitalisedNames).hasSize(4);
    }
}
