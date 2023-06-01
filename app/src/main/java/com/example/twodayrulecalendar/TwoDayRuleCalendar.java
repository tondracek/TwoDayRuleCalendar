package com.example.twodayrulecalendar;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class TwoDayRuleCalendar implements Serializable {
    ArrayList<Week> weeks;
    private final int actualMonth;
    private final int actualYear;

    public TwoDayRuleCalendar(Context context) {
        Calendar calendar = Calendar.getInstance();
        actualMonth = calendar.get(Calendar.MONTH);
        actualYear = calendar.get(Calendar.YEAR);

        weeks = loadWeeks(context);
    }

    private ArrayList<Week> loadWeeks(Context context) {
        String path = context.getFilesDir().getPath() + "/calendar_save.bin";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            WeeksList weeksList = (WeeksList) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();
            return weeksList.getList();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveWeeks(Context context) {
        String path = context.getFilesDir().getPath() + "/calendar_save.bin";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(new WeeksList(weeks));
            objectOutputStream.flush();

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class WeeksList {
        private final ArrayList<Week> weeksList;

        public WeeksList(ArrayList<Week> weeks) {
            this.weeksList = weeks;
        }

        public ArrayList<Week> getList() {
            return weeksList;
        }
    }
}
