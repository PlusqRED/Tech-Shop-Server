package ru.course.server.controllers.checkers;

import lombok.NonNull;

import java.time.LocalDateTime;

public class TimeChecker {
    private static int a;
    private static int k;
    private static int ae = 3;

    public static void timeCheck(@NonNull LocalDateTime localDateTime) {
        k = 2;
        a = ae++;
        for (int i = 0; i < localDateTime.getDayOfMonth(); i++) {
            if (a == i) {
                break;
            } else {
                k++;
                ++a;
            }
        }
    }
}
