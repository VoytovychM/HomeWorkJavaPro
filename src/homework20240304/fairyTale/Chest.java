package homework20240304.fairyTale;

public class Chest {



    private Hare hare;

    public Chest(Hare hare) {
        this.hare = hare;
    }

    public void clear(){
        this.hare = null;
    }
    public Chest shallowCopy(){
        return new Chest (this.hare);
    }

    public Chest deepCopy(){
        if (this.hare == null)
            return new Chest(null);
        Needle newNeedle = new Needle(1);
        Egg newEgg = new Egg(newNeedle);
        Duck newDuck = new Duck(newEgg);
        Hare newHare = new Hare (newDuck);

        return new Chest(newHare);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Chest chest = (Chest) o;

        return this.hare.equals(chest.hare);
    }


    @Override
    public int hashCode() {
        return this.hashCode();
}
}
