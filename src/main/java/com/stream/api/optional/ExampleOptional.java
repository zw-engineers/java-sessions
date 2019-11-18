package com.stream.api.optional;

import java.util.Optional;

class ExampleOptional {
    Optional<String> getOptional(String value) {
        return Optional.ofNullable(value);
    }

    Integer getOptionalWithDefault(Integer integer) {
        return Optional.ofNullable(integer).orElse(0);
    }

    Long getOptionalWithException(Long longValue) throws MyException {
        return Optional.ofNullable(longValue).orElseThrow( () -> new MyException("Missing Long value"));
    }
}
