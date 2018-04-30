package com.strings;

import java.util.StringJoiner;

public class StringConcat {
    public String usePlusSymbol(String str1, String str2) {
        return str1 + " " + str2;
    }

    public String useStringBuffer(String str1, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello");
        stringBuffer.append(" ").append("World");
        return stringBuffer.toString();
    }

    // The JDK 5 way
    public String useStringBuilder(String str1, String str2) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(" ").append("World");
        return builder.toString();
    }

    public String useStringJoiner(String str1, String str2) {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        joiner.add(str1).add(str2);
        return joiner.toString();
    }
}
