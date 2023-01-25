package com.gmail.morozowau.model.logic;

import com.gmail.morozowau.model.entities.Address;
import com.gmail.morozowau.model.entities.BuildingFloors;
import com.gmail.morozowau.model.interfaces.Logic;

import java.util.*;

public class CountOfFloorsAndDuplicateEntriesLogic implements Logic<BuildingFloors> {
    private final List<Address> addresses;

    public CountOfFloorsAndDuplicateEntriesLogic(List<Address> addresses) {
        this.addresses = addresses;
    }


    @Override
    public Map<String, Integer> findDuplicate() {
        Map<String, Integer> map = new HashMap<>();

        for (Address adr :
                addresses) {
            Integer count = map.get(adr.getInitData()) == null ? 0 : map.get(adr.getInitData());
            map.put(adr.getInitData(), ++count);
        }

        return map;
    }

    @Override
    public Map<String, BuildingFloors> findCountOfFloorsInCity() {
        Map<String, BuildingFloors> map = new HashMap<>();
        Set<Address> addressSet = new HashSet<>(addresses);

        for (Address adr :
                addressSet) {
            BuildingFloors buildingFloors = map.get(adr.getCity()) == null ? new BuildingFloors() : map.get(adr.getCity());
            buildingFloors.addOneToFloorCount(Integer.parseInt(adr.getFlor()));
            map.put(adr.getCity(), buildingFloors);
        }
        return map;
    }
}
