package ru.isko.comparators;

import ru.isko.models.Comment;

import java.util.Comparator;

/**
 * created by Iskander Valiev
 * on 11/30/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
public class CommentsDateComparator implements Comparator<Comment> {

    @Override
    public int compare(Comment o1, Comment o2) {
        if (o1.getDate().getTime() > o2.getDate().getTime()) {
            return -1;
        } else if (o1.getDate().getTime() < o2.getDate().getTime()) {
            return 1;
        }
        return 0;
    }
}
