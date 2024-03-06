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

    public Hare getHare() {
        return hare;
    }
}



