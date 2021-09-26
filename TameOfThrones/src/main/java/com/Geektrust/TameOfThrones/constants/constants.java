package com.Geektrust.TameOfThrones.constants;

import java.util.HashMap;
import java.util.Map;

public interface constants {
    public static final int min_allies_count=3;
    public static final String no_allies="NONE";
    Map<String,String> Kingdom_Symbol=new HashMap<String,String>() {
        {
            put("AIR", "OWL");
            put("FIRE", "DRAGON");
            put("ICE", "MAMMOTH");
            put("LAND", "PANDA");
            put("WATER", "OCTOPUS");
        }
    };


}
