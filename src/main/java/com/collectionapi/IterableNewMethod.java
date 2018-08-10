package com.collectionapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IterableNewMethod {

    public List<String> names() {
        List<String> names = Arrays.asList("Artemas", "Thomas", "Bob");
        List<String> namesInUpperCase = new ArrayList<>();
        names.forEach(name -> namesInUpperCase.add(name.toUpperCase()));
        return namesInUpperCase;
    }

}
