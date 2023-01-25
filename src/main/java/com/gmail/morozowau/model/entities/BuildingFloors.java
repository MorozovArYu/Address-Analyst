package com.gmail.morozowau.model.entities;

import com.gmail.morozowau.model.exceptions.ImpossibleFloorException;

import java.util.*;

public class BuildingFloors {
    private SortedMap<Integer, Integer> floors = new TreeMap<>();

    public BuildingFloors() {

    }

    public BuildingFloors(int...floors) {
        for (int i = 0; i < floors.length; i++) {
            this.floors.put(i,floors[i]);
        }
    }

    public SortedMap<Integer, Integer> getFloors() {
        return floors;
    }

    public void addOneToFloorCount(int floor) {
        if (floor > 163)
            throw new ImpossibleFloorException("Не существует настолько больших зданий"); // Максимальное количество этажей - Бурдж-Халифа, Дубай, 163 этажа :)
        Integer newValue = floors.get(floor) == null ? 0 : floors.get(floor);
        floors.put(floor, ++newValue);
        /*
         *   Вариант класса с полями этажей и данным методом через case работает быстрее,
         * но массив позволяет обрабатывать большое количество этажей без необходимости
         * менять класс
         * */
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingFloors that = (BuildingFloors) o;
        return Objects.equals(floors, that.floors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floors);
    }

    @Override
    public String toString() {
        return "BuildingFloors{" +
                "floors=" + floors +
                '}';
    }
}
