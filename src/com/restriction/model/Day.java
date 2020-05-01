package com.restriction.model;

import java.util.List;

public class Day {
    private String name;
    private List<Integer> restrictions;

    public Day(String name, List<Integer> restrictions) {
        this.name = name;
        this.restrictions = restrictions;
    }

    public boolean isRestricted(int lastDigitOfPlate) {
        return restrictions.stream().anyMatch(restriction -> restriction == lastDigitOfPlate);
    }

    public String getName() {
        return name;
    }
}
