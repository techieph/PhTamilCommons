package com.ph.tamil.commons.data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AsciiYezhluthuMapSupplier {

    private static Map<String, Integer> data = new HashMap<>();

    // Used Supplier for Lazy Initialisation
    public static Supplier<Map<String, Integer>> getAsciiYezhluthuMapSupplier() {
        return () -> {
            if(data.isEmpty()) {
                int index = 1;
                for (String yezhuluthu : YezhluthukalData.yezhuluthukalData) {
                    String key = yezhuluthu.charAt(0) + (yezhuluthu.length() == 2 ? "-" + yezhuluthu.charAt(1) : "");
                    data.put(key, index++);
                }
            }
            return data;
        };
    }

}
