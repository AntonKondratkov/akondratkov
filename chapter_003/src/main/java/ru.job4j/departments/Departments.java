package ru.job4j.departments;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();

        for (String value : deps) {
            tmp.addAll(Arrays.asList(value.split("/")));
        }

        if (tmp.contains("SK1")) {
            if (tmp.contains("K1")) {
                tmp.add("K1/SK1");
            }
            if (tmp.contains("K2")) {
                tmp.add("K2/SK1");
            }
            tmp.remove("SK1");
        }
        if (tmp.contains("SSK1")) {
            if (tmp.contains("K1/SK1")) {
                tmp.add("K1/SK1/SSK1");
            }
            if (tmp.contains("K2/SK1")) {
                tmp.add("K2/SK1/SSK1");
            }
            tmp.remove("SSK1");
        }
        if (tmp.contains("SSK2")) {
            if (tmp.contains("K1/SK1")) {
                tmp.add("K1/SK1/SSK2");
            }
            if (tmp.contains("K2/SK1")) {
                tmp.add("K2/SK1/SSK2");
            }
            tmp.remove("SSK2");
        }
        if (tmp.contains("SK2") & tmp.contains("K1")) {
            tmp.add("K1/SK2");
            tmp.remove("SK2");
        }

        List<String> list = new ArrayList<>(tmp);
        sortAsc(list);

        return list;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs);
    }
}