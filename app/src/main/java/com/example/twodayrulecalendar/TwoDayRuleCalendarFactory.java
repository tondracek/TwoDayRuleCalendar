package com.example.twodayrulecalendar;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TwoDayRuleCalendarFactory {
    private static final String objectPath = "/calendar_save.bin";

    public static TwoDayRuleCalendar getCalendar(Context context) {
        TwoDayRuleCalendar calendar = loadSavedCalendar(context);

        if (calendar != null && calendar.isActual()) {
            return calendar;
        } else {
            return new TwoDayRuleCalendar();
        }
    }

    private static TwoDayRuleCalendar loadSavedCalendar(Context context) {
        String path = context.getFilesDir().getPath() + objectPath;

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            TwoDayRuleCalendar calendar = (TwoDayRuleCalendar) objectInputStream.readObject();

            objectInputStream.close();
            return calendar;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
