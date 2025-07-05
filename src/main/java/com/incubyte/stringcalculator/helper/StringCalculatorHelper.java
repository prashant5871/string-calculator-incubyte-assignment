package com.incubyte.stringcalculator.helper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculatorHelper {

    public static int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = extractCustomDelimiter(input.substring(2, delimiterEndIndex));
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] tokens = input.split(delimiter);
        return compute(tokens);
    }

    private static String extractCustomDelimiter(String def) {
        if (def.startsWith("[") && def.endsWith("]")) {
            List<String> delimiters = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(def);
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }
            return String.join("|", delimiters); // regex using OR (|) between delimiters
        } else {
            return Pattern.quote(def);
        }
    }



    private static int compute(String[] tokens) {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) {
                    negatives.add(num);
                } else if (num <= 1000) {
                    sum += num;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " +
                    negatives.stream().map(String::valueOf).collect(Collectors.joining(", "))
            );
        }

        return sum;
    }
}
