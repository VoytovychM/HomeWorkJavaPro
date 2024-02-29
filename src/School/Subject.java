package School;

public enum Subject {

    MATH("Mr Smith", "Types of Triangles, Factorial"),
    SCIENCE("Mr Johnson", "Significance of Photosynthesis"),
    PHYSICS("Mr Williams", "Projectile Motion"),
    ART("Mr Brown", "Modernism"),
    HISTORY("Mr Schwarz", "The period of Late Antiquity");

    private final String teacher;
    private final String description;

    Subject(String teacher, String description) {
        this.teacher = teacher;
        this.description = description;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "teacher='" + teacher + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
