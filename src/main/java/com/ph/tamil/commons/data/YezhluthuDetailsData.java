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

    private static String[] yezhuluthukalData = new String[]{
            "அ", "ஆ", "இ", "ஈ", "உ", "ஊ", "எ", "ஏ", "ஐ", "ஒ", "ஓ", "ஔ",
            "க்", "ங்", "ச்", "ஞ்", "ட்", "ண்", "த்", "ந்", "ப்", "ம்", "ய்", "ர்", "ல்", "வ்", "ழ்", "ள்", "ற்", "ன்", "ஷ்", "ஸ்", "ஹ்",
            "க", "கா", "கி", "கீ", "கு", "கூ", "கெ", "கே", "கை", "கொ", "கோ", "கௌ",
            "ங", "ஙா", "ஙி", "ஙீ", "ஙு", "ஙூ", "ஙெ", "ஙே", "ஙை", "ஙொ", "ஙோ", "ஙௌ",
            "ச", "சா", "சி", "சீ", "சு", "சூ", "செ", "சே", "சை", "சொ", "சோ", "சௌ",
            "ஞ", "ஞா", "ஞி", "ஞீ", "ஞு", "ஞூ", "ஞெ", "ஞே", "ஞை", "ஞொ", "ஞோ", "ஞௌ",
            "ட", "டா", "டி", "டீ", "டு", "டூ", "டெ", "டே", "டை", "டொ", "டோ", "டௌ",
            "ண", "ணா", "ணி", "ணீ", "ணு", "ணூ", "ணெ", "ணே", "ணை", "ணொ", "ணோ", "ணௌ",
            "த", "தா", "தி", "தீ", "து", "தூ", "தெ", "தே", "தை", "தொ", "தோ", "தௌ",
            "ந", "நா", "நி", "நீ", "நு", "நூ", "நெ", "நே", "நை", "நொ", "நோ", "நௌ",
            "ப", "பா", "பி", "பீ", "பு", "பூ", "பெ", "பே", "பை", "பொ", "போ", "பௌ",
            "ம", "மா", "மி", "மீ", "மு", "மூ", "மெ", "மே", "மை", "மொ", "மோ", "மௌ",
            "ய", "யா", "யி", "யீ", "யு", "யூ", "யெ", "யே", "யை", "யொ", "யோ", "யௌ",
            "ர", "ரா", "ரி", "ரீ", "ரு", "ரூ", "ரெ", "ரே", "ரை", "ரொ", "ரோ", "ரௌ",
            "ல", "லா", "லி", "லீ", "லு", "லூ", "லெ", "லே", "லை", "லொ", "லோ", "லௌ",
            "வ", "வா", "வி", "வீ", "வு", "வூ", "வெ", "வே", "வை", "வொ", "வோ", "வௌ",
            "ழ", "ழா", "ழி", "ழீ", "ழு", "ழூ", "ழெ", "ழே", "ழை", "ழொ", "ழோ", "ழௌ",
            "ள", "ளா", "ளி", "ளீ", "ளு", "ளூ", "ளெ", "ளே", "ளை", "ளொ", "ளோ", "ளௌ",
            "ற", "றா", "றி", "றீ", "று", "றூ", "றெ", "றே", "றை", "றொ", "றோ", "றௌ",
            "ன", "னா", "னி", "னீ", "னு", "னூ", "னெ", "னே", "னை", "னொ", "னோ", "னௌ",
            "ஷ", "ஷா", "ஷி", "ஷீ", "ஷு", "ஷூ", "ஷெ", "ஷே", "ஷை", "ஷொ", "ஷோ", "ஷௌ",
            "ஸ", "ஸா", "ஸி", "ஸீ", "ஸு", "ஸூ", "ஸெ", "ஸே", "ஸை", "ஸொ", "ஸோ", "ஸௌ",
            "ஹ", "ஹா", "ஹி", "ஹீ", "ஹு", "ஹூ", "ஹெ", "ஹே", "ஹை", "ஹொ", "ஹோ", "ஹௌ",
             "ஃ"
    };

    // Data HashMap will be loaded only On-Demand for a given yezhluthuIndex
    public static Function<Integer, YezhluthuDetails> getYezhluthuDetails = yezhluthuIndex -> {
        if(!data.containsKey(yezhluthuIndex)) {
            data.put(yezhluthuIndex, new YezhluthuDetails(
                    yezhuluthukalData[yezhluthuIndex-1],
                    yezhuluthukalData[yezhluthuIndex-1].charAt(0) +
                            yezhuluthukalData[yezhluthuIndex-1].length() == 2 ? "-" + yezhuluthukalData[yezhluthuIndex-1].charAt(1) : "",
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
