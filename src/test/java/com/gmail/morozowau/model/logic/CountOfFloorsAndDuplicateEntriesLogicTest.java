package com.gmail.morozowau.model.logic;

import com.gmail.morozowau.model.entities.Address;
import com.gmail.morozowau.model.entities.BuildingFloors;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.random;
import static java.lang.Math.round;

class CountOfFloorsAndDuplicateEntriesLogicTest {
    private List<Address> addresses = new ArrayList<>();
    private CountOfFloorsAndDuplicateEntriesLogic result = new CountOfFloorsAndDuplicateEntriesLogic(addresses);
    private final int numberOfTests = 100;
    private Map<String, Integer> expectedDuplicates = new HashMap<>();
    private Map<String, BuildingFloors> expectedFloors = new HashMap<>();

    {
        for (int i = 0; i < numberOfTests; i++) {
            Address address = createAddress(i+3);
            BuildingFloors buildingFloors = new BuildingFloors();
            int amount = (int) round(random()*8 + 1);
            for (int j = 0; j < amount; j++) {
                addresses.add(address);
            }
            expectedDuplicates.put(address.getInitData(),amount);
            buildingFloors.addOneToFloorCount(Integer.parseInt(address.getFlor()));
            expectedFloors.put(address.getCity(),buildingFloors);
        }
    }
    @Test
    void whenThereAreDuplicatesInListThenDuplicatesAreCountedCorrectly() {
        Assert.assertEquals(expectedDuplicates, result.findDuplicate());
    }

    @Test
    void whenListIsGeneratedThenFloorsAreCalculatedCorrectly() {
        Assert.assertEquals(expectedFloors, result.findCountOfFloorsInCity());
    }

    private String createString(int length) {
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) (i + 40);
        }
        return String.valueOf(result);
    }

    private Address createAddress(int length) {
        Address result = new Address(createString(length),
                createString(length + 10),
                createString(length+5),
                String.valueOf(length+2),
                String.valueOf(length+3));

        return result;
    }

}