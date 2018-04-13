package com.streams.optional;

import java.util.Optional;

public class ExampleOptional {
    public Optional<String> getOptional(String value) {
        return Optional.ofNullable(value);
    }

    public Integer getOptionalWithDefault(Integer integer) {
        return Optional.ofNullable(integer).orElse(0);
    }

    public Long getOptionalWithException(Long longValue) throws MyException {
        return Optional.ofNullable(longValue).orElseThrow( () -> new MyException("Missing Long value"));
    }
}
