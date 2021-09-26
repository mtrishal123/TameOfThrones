package com.Geektrust.TameOfThrones.services;


import com.Geektrust.TameOfThrones.constants.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputProcessor {

    static List<String> ally=new ArrayList<>();
    public static List<String> allies(String Ally) {
        ally.add(Ally);
        return ally;

    }
}
