package School;

public class Student {

    private String name;
    private Subject[] subjects = new Subject[Subject.values().length];

    public Student(String name) {
        this.name = name;
    }

    private int index = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void learn(Subject subject){
        subjects[index] = subject;
        index++;
    }

    public boolean knows(Subject subject){
        for (Subject j: subjects) {
         if(j == subject){
             return true;
         }
        }

        return false;
    }



}
