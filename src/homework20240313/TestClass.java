package homework20240313;

public class TestClass {

    String field;

    public TestClass(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "field='" + field + '\'' +
                '}';
    }

    public Object getName() {

        return null;
    }
}
