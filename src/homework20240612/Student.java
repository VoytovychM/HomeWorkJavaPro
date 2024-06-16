package homework20240612;
// Имеется класс Student с полями name, surname, age. Создать аннотацию @StudentInfo и соответствующий инжектор через рефлексию,
//чтобы с их помощью иметь возможность инициализировать переменные типа Student.
public class Student {

    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
