package ru.isko.comparators;

import ru.isko.models.News;
import java.util.Comparator;

public class NewsDateComparator implements Comparator<News> {

    @Override
    public int compare(News o1, News o2) {
        if (o1.getDate().getTime() > o2.getDate().getTime()) {
            return -1;
        } else {
            if (o1.getDate().getTime() < o2.getDate().getTime()) {
                return 1;
            }
        }
        return 0;
    }
}
