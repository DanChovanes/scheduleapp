package com.chovanes.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Schedule implements Serializable {
    Map<String, Class[]> sch = new HashMap<>();

    public Schedule() {
        Class[] mwfSchedule = new Class[2];
        Class[] tuesSchedule = new Class[2];
        Class[] thursSchedule = new Class[1];

        Class biology = new Class("Biology", "314", "10:10am", "11:05am");
        Class bioLab = new Class("Biology - Lab", "316", "10:30am", "12:25pm");
        Class music = new Class("Music History", "116", "12:30pm", "2:30pm");
        Class econ = new Class("Economics", "114", "11:15am", "12:05pm");

        mwfSchedule[0] = biology;
        mwfSchedule[1] = econ;
        tuesSchedule[0] = bioLab;
        tuesSchedule[1] = music;
        thursSchedule[0] = music;

        sch.put("Monday", mwfSchedule);
        sch.put("Tuesday", tuesSchedule);
        sch.put("Wednesday", mwfSchedule);
        sch.put("Thursday", thursSchedule);
        sch.put("Friday", mwfSchedule);
    }

    public static void main(String[] args) {
        Schedule s = new Schedule();
        Class[] item = s.sch.get("Tuesday");
        for (Class c : item) {
            System.out.println(c.toString());
            System.out.println();
        }
    }
}

@Data
@AllArgsConstructor
class Class {
    private String className, roomNum, startTime, endTime;

    @Override
    public String toString() {
        return className + " {\n\tRoom Number: " + roomNum +
                "\n\tStart Time: " + startTime + "\n\tEnd Time: " + endTime + "\n}";
    }
}
