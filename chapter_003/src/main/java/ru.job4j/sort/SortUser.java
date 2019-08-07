package ru.job4j.sort;

import java.util.*;

public class SortUser{
    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<User>();
        users.addAll(list);
        return users;
    }

    public List<User> sortNameLength(List<User> list) {
        List<User> result = list;
        result.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
        );
        return result;
    }

    public List<User> sortByAllFields(List<User> list) {
        List<User> result = list;
        result.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int compare = o1.getName().compareTo(o2.getName());
                        return compare != 0 ? compare : Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
        return result;
    }
}
