package com.example.twodayrulecalendar;

import android.content.Context;
import android.view.View;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class TwoDayRuleCalendar implements Serializable {
    ArrayList<Week> weeks;
    private final int actualMonth;
    private final int actualYear;
    private static String path;

    public TwoDayRuleCalendar(Context context) {
        Calendar calendar = Calendar.getInstance();
        actualMonth = calendar.get(Calendar.MONTH);
        actualYear = calendar.get(Calendar.YEAR);

        path = context.getFilesDir().getPath() + "/calendar_save.bin";
        weeks = WeeksList.loadWeeks(path);
    }

    public void saveCalendar() {
        WeeksList.saveWeeks(path, new WeeksList(weeks));
    }

    public List<Week> getActualWeeks() {
        return weeks.stream().filter(Week::isActual).collect(Collectors.toList());
    }


    private static class WeeksList {
        private final ArrayList<Week> weeksList;

        public WeeksList(ArrayList<Week> weeks) {
            this.weeksList = weeks;
        }

        public ArrayList<Week> getList() {
            return weeksList;
        }

        protected static ArrayList<Week> loadWeeks(String path) {
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

        protected static void saveWeeks(String path, WeeksList weeks) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(weeks);
                objectOutputStream.flush();

                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
