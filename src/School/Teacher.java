package School;

public class Teacher {

  private Subject subject;
 public void teach(Student student){
  student.learn(this.subject);
 }

    public Teacher(Subject subject) {
        this.subject = subject;
    }

    public void teach (Student[] students){
        for (Student s: students) {
            this.teach(s);
        }

        }

    }



