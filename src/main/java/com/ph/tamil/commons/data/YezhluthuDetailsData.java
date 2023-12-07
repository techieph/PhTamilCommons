package com.ph.tamil.commons.data;

import com.ph.tamil.commons.enums.YezhluthuConstantType;
import com.ph.tamil.commons.enums.YezhluthuSoundType;
import com.ph.tamil.commons.enums.YezhluthuType;
import com.ph.tamil.commons.model.YezhluthuDetails;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class YezhluthuDetailsData {

    private static HashMap<Integer, YezhluthuDetails> data = new HashMap<>();
    private static List<Integer> kurilIndexesOutOf12 = Arrays.asList(0,2,4,6,9);
    private static List<Integer> vallinamIndexesOutOf18 = Arrays.asList(0,2,4,6,8,16);
    private static List<Integer> mellinamIndexesOutOf18 = Arrays.asList(1,3,5,7,9,17);

    // Data HashMap will be loaded only On-Demand for a given yezhluthuIndex
    public static Function<Integer, YezhluthuDetails> getYezhluthuDetails = yezhluthuIndex -> {
        if(!data.containsKey(yezhluthuIndex)) {
            data.put(yezhluthuIndex, new YezhluthuDetails(
                    YezhluthukalData.yezhuluthukalData[yezhluthuIndex-1],
                    YezhluthukalData.yezhuluthukalData[yezhluthuIndex-1].charAt(0) +
                            YezhluthukalData.yezhuluthukalData[yezhluthuIndex-1].length() == 2 ? "-" + YezhluthukalData.yezhuluthukalData[yezhluthuIndex-1].charAt(1) : "",
                    yezhluthuIndex >= 34 && yezhluthuIndex <= 285 ? (kurilIndexesOutOf12.contains((yezhluthuIndex-34)%12)
                            ? YezhluthuSoundType.Kuril : YezhluthuSoundType.Nedil) :
                            yezhluthuIndex <=12 ? (kurilIndexesOutOf12.contains((yezhluthuIndex-1)%12)
                            ? YezhluthuSoundType.Kuril : YezhluthuSoundType.Nedil) : YezhluthuSoundType.Mei,
                    yezhluthuIndex <= 12 ? YezhluthuType.Uyir
                            : yezhluthuIndex >= 34 && yezhluthuIndex <= 285  ? YezhluthuType.UyirMei
                            : yezhluthuIndex == 286 ? YezhluthuType.Aayutham : YezhluthuType.Mei,
                    yezhluthuIndex < 34 || yezhluthuIndex > 249 ? YezhluthuConstantType.NotApplicable
                            : vallinamIndexesOutOf18.contains(((yezhluthuIndex-34)/12)%18) ? YezhluthuConstantType.Vallinam :
                            mellinamIndexesOutOf18.contains(((yezhluthuIndex-34)/12)%18) ? YezhluthuConstantType.Mellinam : YezhluthuConstantType.Idaiyinam
            ));
        }
        return data.get(yezhluthuIndex);
    };

}
