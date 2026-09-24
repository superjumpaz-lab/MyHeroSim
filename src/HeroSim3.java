import java.util.ArrayList;

public class HeroSim3 {

    // VARIABLES
    String name = "Jarl";
    int health = 100;
    int maxHealth = 200;
    int lvlHealthGain = 100;
    int level = 3;
    int xp = 2300;
    int levelUp = level * 500;
    double gold = 20.5;
    boolean isAlive = true;
    char heroClass = 'W';
    ArrayList<String> items = new ArrayList<>();
    int percentage = 25;
    int healingSpell;
    int incomingDamage;
    double goldGained;
    int xpGained;
    String currentMonster;
    int itemCost;


    void printTitle(String name) {
        System.out.println("=== " + name + " ===");
    }


    double getHealthPercentage() {
        return (double) health / maxHealth * 100;
    }

    void characterStats() {
        System.out.println("Name: " + name);
        switch (heroClass) {
            case 'R':
                System.out.println("Class: R (Rouge");
                break;
            case 'M':
                System.out.println("Class: M (Mage)");
                break;
            case 'W':
                System.out.println("Class: W (Warlock)");
                break;
        }
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Level: " + level);
        System.out.println("Experience points: " + xp);
        System.out.println("Gold: " + gold);
        System.out.println("Alive: " + isAlive);
        spaceBuffer();
    }

    void printInventory() {
        for (String item : items) {
            System.out.println("- " + item);
        }
        spaceBuffer();
    }


    void monsterType(String monsterName) {
        currentMonster = monsterName;
        System.out.println(name + " encounters " + currentMonster);
        spaceBuffer();
    }

    boolean isAlive() {
        return health >= 0;
    }

    boolean isHealthCritical() {
        return health <= maxHealth * percentage / 100;
    }

    void damageCheck(int damage) {
        incomingDamage = damage;
        System.out.println(" -" + currentMonster + "s turn- ");
        System.out.println(currentMonster + " does " + incomingDamage + " damage!");
        System.out.println(name + "'s Health: " + health + " -> " + (health = health - incomingDamage));
    }


    void combatCheck(int damage) {
        // Damage check
        damageCheck(damage);

        // Health critical check
        if (isHealthCritical()) {
            System.out.println("!WARNING!: Health critical!");
        }

        // IsAlive check
        if (!isAlive()) {
            System.out.println(name + " is dead");
        } else {
            System.out.println(name + " is still alive");
        }

        spaceBuffer();
    }


    void healing() {
        healingSpell = 40;
        System.out.println(" -" + name + "'s turn- ");
        if (health <= (maxHealth - 40)) {
            System.out.println(name + " healed " + healingSpell + " health");
            System.out.println("Health: " + health + " -> " + (health = health + healingSpell));
        }
        System.out.println(name + " has defeated " + currentMonster + "!");
        spaceBuffer();

    }


    void monsterLoot(int experience, double goldEarned) {
        xpGained = experience;
        goldGained = goldEarned;
        xp += xpGained;
        gold += goldGained;

        System.out.println(name + " earned " + goldGained + " gold");
        System.out.println("Total gold: " + gold);
        System.out.println(name + " earned " + xpGained + " xp");


    }


    void levelUpCheck() {

        if (xp >= levelUp) {
            xp -= levelUp;
            level++;
            maxHealth += lvlHealthGain;
            levelUp = level * 500;
        }

        System.out.println(name + " leveled up!");
        System.out.println("Health increased by " + lvlHealthGain);
        System.out.println(name + " is now level: " + level);
        System.out.println("Total xp: " + xp + "/" + levelUp);
        System.out.println("Total health: " + health + "/" + maxHealth + "(" + getHealthPercentage() + "%)");

        spaceBuffer();
    }

    boolean removeGold(double amount) {
        return gold >= amount;
    }

    void showGold() {
        System.out.println("You h");
    }

    void shopStop(double itemPrice, String shopItem) {
        System.out.println("Welcome traveller! Browse my items and flip some coin");
        if (removeGold(itemPrice)) {
            System.out.println("You have bought " + shopItem + "!");
            System.out.println("Remaining gold: " + gold);
            items.add(shopItem);
            gold -= itemPrice;
        } else {
            System.out.println("You cant afford my goods");


        }
        spaceBuffer();
    }


    void spaceBuffer() {
        System.out.println("");
    }


    void main() {
        items.add("Void staff");
        items.add("Health potion");
        items.add("Rat tail");
        items.add("Chaos Robe");


        // CHARACTER STATS
        printTitle("Character stats");
        characterStats();


        // INVENTORY
        printTitle("Inventory");
        printInventory();
        spaceBuffer();


        // COMBAT
        printTitle("Combat");
        monsterType("Ghoul");
        combatCheck(50);
        healing();
        printTitle("Combat loot");
        monsterLoot(800, 70);
        levelUpCheck();
        printTitle("Shopkeeper");
        shopStop(20, "Crojiro");
        printTitle("Inventory");
        printInventory();

    }

}




