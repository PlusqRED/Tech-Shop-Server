package ru.course.server.controllers.checkers;

import lombok.NonNull;

import java.time.LocalDate;

public class DateValidator {
    private static long until;
    private static long till;

    public static void dateValidate(@NonNull LocalDate localDate) {
        until = 1;
        till = until;
        for (int i = 0; i < localDate.getMonth().getValue(); i++) {
            if (until == i) {
                break;
            } else {
                till++;
                ++until;
            }
        }
    }
}
