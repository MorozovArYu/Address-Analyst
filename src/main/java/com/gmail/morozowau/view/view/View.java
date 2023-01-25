package com.gmail.morozowau.view.view;

import com.gmail.morozowau.model.entities.BuildingFloors;
import com.gmail.morozowau.view.interfaces.ShowCountOfFloors;
import com.gmail.morozowau.view.interfaces.ShowDuplicateEntries;
import com.gmail.morozowau.view.interfaces.ShowView;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class View implements ShowView {
    final private Map<String, BuildingFloors> countOfFloors;
    final private Map<String, Integer> duplicateEntries;

    public View(Map<String, BuildingFloors> countOfFloors, Map<String, Integer> duplicateEntries) {
        this.countOfFloors = countOfFloors;
        this.duplicateEntries = duplicateEntries;
    }

    @Override
    public void showCountOfFloors() {
        for (Map.Entry<String, BuildingFloors> entry :
                countOfFloors.entrySet()) {
            SortedMap<Integer, Integer> countOfFloors = entry.getValue().getFloors();
            System.out.printf("Здания в городе |%s|:\n", entry.getKey());
            countOfFloors.forEach((k,v) -> System.out.printf("%5d-этажных зданий: %d\n",k,v));
        }
    }

    @Override
    public void showDuplicateEntries() {
        for (Map.Entry<String, Integer> entry :
                duplicateEntries.entrySet()) {
            if (entry.getValue() > 1)
                System.out.printf("Значение |%s| повторяется |%d| раз;\n", entry.getKey(), entry.getValue());
        }
    }
}
