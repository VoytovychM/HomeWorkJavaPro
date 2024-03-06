package homework20240304.fairyTale;

import java.util.Objects;

public class Hare {
    private Duck duck;

    public Hare(Duck duck) {
        this.duck = duck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hare hare = (Hare) o;
        return Objects.equals(duck, hare.duck);
    }

    @Override
    public int hashCode() {

        return Objects.hash(duck);
    }


}
