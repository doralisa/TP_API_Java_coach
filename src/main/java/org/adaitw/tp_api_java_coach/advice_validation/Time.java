package org.adaitw.tp_api_java_coach.advice_validation;

import java.sql.Timestamp;

public class Time {
    public static Timestamp getTime() {
        return new Timestamp(System.currentTimeMillis());
    }
}