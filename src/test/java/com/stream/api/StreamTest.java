package com.stream.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.stream.api.StreamExample.convertToStream;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StreamTest {
    private final static Integer someNumber = null;

    @Test
    @DisplayName("Should return an empty Stream when the value to be streamed is null")
    void nullStream() {
        Stream<Integer> valueStream = convertToStream(someNumber);

        assertThat(valueStream).isEmpty(); // Bare in mind that Empty != null...
    }

}
