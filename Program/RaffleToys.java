package Program;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import InfoToys.Toy;

public class RaffleToys {
    private int smallToys = 30;
    private int mediumToys = 50;
    private int bigToys = 70;

    public RaffleToys() {
    }

    public Toy drawToy(List<Toy> toys) {
        List<Toy> eligibleToys = new ArrayList<Toy>();
        int totalWeight = 0;
        Iterator<Toy> var5 = toys.iterator();

        while(var5.hasNext()) {
            Toy toy = (Toy)var5.next();
            if (toy.getQuantity() > 0) {
                eligibleToys.add(toy);
                totalWeight += this.getToyWeight(toy);
            }
        }

        if (eligibleToys.isEmpty()) {
            return null;
        } else {
            Random random = new Random();
            int weight = random.nextInt(totalWeight) + 1;
            int accumulatedWeight = 0;
            Toy selectedToy = null;
            Iterator<Toy> var9 = eligibleToys.iterator();

            while(var9.hasNext()) {
                Toy toy = (Toy)var9.next();
                int toyWeight = this.getToyWeight(toy);
                int weightW = toyWeight ; 
                accumulatedWeight += weightW;
                if (accumulatedWeight >= weight) {
                    selectedToy = toy;
                    break;
                }
            }

            if (selectedToy != null) {
                selectedToy.decreaseQuantity();
            }

            return selectedToy;
        }
    }

    private int getToyWeight(Toy toy) {
        int weight = toy.getWeight();
        if (weight <= this.smallToys) {
            return 65;
        } else if (weight <= this.mediumToys) {
            return 35;
        } else {
            return weight <= this.bigToys ? 10 : 1;
        }
    }


    public void setSmallToys(int smallToys) {
        this.smallToys = smallToys;
    }

    public void setMediumToys(int mediumToys) {
        this.mediumToys = mediumToys;
    }

    public void setBigToys(int bigToys) {
        this.bigToys = bigToys;
    }

    public int getSmallToys() {
        return this.smallToys;
    }

    public int getMediumToys() {
        return this.mediumToys;
    }

    public int getBigToys() {
        return this.bigToys;
    }
}