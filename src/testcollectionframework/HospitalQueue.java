package testcollectionframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HospitalQueue {

    public static void main(String[] args) {

        Schedule schedule = new Schedule();
        schedule.makeAppointment("Schmidt", 1);
        schedule.makeAppointment("Langner", 8);
        schedule.makeAppointment("Mayer", 2);
        schedule.makeAppointment("Zimmermann", 7);

        schedule.printSchedule();

    }


    static class Appointment {
        String name;
        Integer slot;

        public Appointment(String name, Integer slot) {
            this.name = name;
            this.slot = slot;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSlot() {
            return slot;
        }

        public void setSlot(Integer slot) {
            this.slot = slot;
        }

        @Override
        public String toString() {
            return "Appointment{" +
                    "name='" + name + '\'' +
                    ", slot=" + slot +
                    '}';
        }
    }
    static class Schedule{
        private List<Appointment> apointmentList;

        public Schedule() {
            this.apointmentList = new ArrayList<>();
        }
        public void makeAppointment(String name, Integer slot){
            Appointment newApp = new Appointment(name, slot);
            apointmentList.add(newApp);
        }

        public void printSchedule(){
            Collections.sort(apointmentList, new Comparator<Appointment>() {
                @Override
                public int compare(Appointment o1, Appointment o2) {
                    return o1.slot.compareTo(o2.slot);
                }
            });
            System.out.println(apointmentList);
        }
    }
}

