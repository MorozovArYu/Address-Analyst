package com.gmail.morozowau.model.entities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.*;

class BuildingFloorsTest extends BuildingFloors {

    private final int numberOfTests = 1_000;

    @Test
    void WhenEnteringFloorThenOneIsAdded() {
        for (int i = 0; i < numberOfTests; i++) {
            TreeMap<Integer, Integer> expected =  createExpected();
            Assert.assertEquals(expected,createBuildingFloor(expected).getFloors());
        }
    }

    private TreeMap<Integer, Integer> createExpected(){
        TreeMap<Integer, Integer> expected = new TreeMap<>();
        for (int i = 0; i < (int) round(random()*10 + 3); i++) {
            expected.put(i,(int) round(random()*5 + 1));
        }
        return expected;
    }

    private BuildingFloors createBuildingFloor(TreeMap<Integer, Integer> expected){
        BuildingFloors entity = new BuildingFloors();
        for (Map.Entry<Integer, Integer> entry :
                expected.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                entity.addOneToFloorCount(entry.getKey());
            }
        }
        return entity;
    }
}
