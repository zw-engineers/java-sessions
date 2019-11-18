package com.stream.api;

import java.util.stream.Stream;

class StreamExample {
    static Stream<Integer> convertToStream(Integer value) {
        return Stream.ofNullable(value);
    }
}
