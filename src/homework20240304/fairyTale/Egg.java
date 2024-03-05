package homework20240304.fairyTale;

import java.util.Objects;

public class Egg {

    private Needle needle;

    public Egg(Needle needle) {
        this.needle = needle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Egg egg = (Egg) o;
        return Objects.equals(needle, egg.needle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(needle);
    }
}
