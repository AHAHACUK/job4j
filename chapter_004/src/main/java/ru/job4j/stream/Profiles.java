package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).distinct().sorted(new Comparator<Address>() {
            @Override
            public int compare(Address o1, Address o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        }).collect(Collectors.toList());
    }
}
