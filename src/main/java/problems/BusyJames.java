package problems;

import java.util.Arrays;
import java.util.Locale;

public class BusyJames {

    private int[] schedule = new int[10080];

    public static void main(String[] args) {
        //
        BusyJames j = new BusyJames();
        String s = "Sun 10:00-20:00\n" +
                "Fri 05:00-10:00\n" +
                "Fri 16:30-23:50\n" +
                "Sat 10:00-24:00\n" +
                "Sun 01:00-04:00\n" +
                "Sat 02:00-06:00\n" +
                "Tue 03:30-18:15\n" +
                "Tue 19:00-20:00\n" +
                "Wed 04:25-15:14\n" +
                "Wed 15:14-22:40\n" +
                "Thu 00:00-23:59\n" +
                "Mon 05:00-13:00\n" +
                "Mon 15:00-21:00";
        s = "Mon 01:00-23:00\n" +
                "Tue 01:00-23:00\n" +
                "Wed 01:00-23:00\n" +
                "Thu 01:00-23:00\n" +
                "Fri 01:00-23:00\n" +
                "Sat 01:00-23:00\n" +
                "Sun 01:00-21:00";
        System.out.println(j.solution(s));
    }

    public int solution(String S) {
        // write your code in Java SE 8
        bookMeetings(S);
        return longestSleepMins();
    }

    private int longestSleepMins() {
        int maxSleepMin = 0;
        int sleepCounter = 0;
        for (int j : schedule) {
            if (j != 1) {
                sleepCounter++;
            } else {
                if (sleepCounter > maxSleepMin) {
                    maxSleepMin = sleepCounter;
                }
                sleepCounter = 0;
            }
        }

        return Math.max(sleepCounter, maxSleepMin);
    }

    private void bookMeetings(String meetings) {
        String[] s1 = meetings.split("\\n");
        for (String meeting : s1) {
            parseMeeting(meeting);
        }
    }

    private void parseMeeting(String meeting) {
        // TODO: Use Pattern match
        String[] s1 = meeting.split("\\s");
        String[] s2 = s1[1].split("-");
        String day = s1[0];
        String startTime = s2[0];
        String endTime = s2[1];

        String[] s3 = startTime.split(":");
        int startHour = Integer.parseInt(s3[0]);
        int startMin = Integer.parseInt(s3[1]);

        String[] s4 = endTime.split(":");
        int endHour = Integer.parseInt(s4[0]);
        int endMin = Integer.parseInt(s4[1]);

        int dayOffset = 0;
        switch (day.toLowerCase()) {
            case "mon":
                dayOffset = 0;
                break;
            case "tue":
                dayOffset = 1;
                break;
            case "wed":
                dayOffset = 2;
                break;
            case "thu":
                dayOffset = 3;
                break;
            case "fri":
                dayOffset = 4;
                break;
            case "sat":
                dayOffset = 5;
                break;
            case "sun":
                dayOffset = 6;
                break;
        }
        // (Number of mins in a day * day offset) + (start hour * 60) + start min
        int startIndex = (dayOffset * 1440) + (startHour * 60) + startMin;
        int endIndex = (dayOffset * 1440) + (endHour * 60) + endMin;
        Arrays.fill(schedule, startIndex, endIndex, 1);
    }


}
