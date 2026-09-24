import java.util.ArrayList;

public class HeroSim2 {

    // VARIABLES
    String name = "Jarl";
    int health = 100;
    int maxHealth = 200;
    int level = 3;
    int xp = 2300;
    int levelUp = level * 500;
    double gold = 20.5;
    boolean isAlive = true;
    char heroClass = 'W';
    ArrayList<String> items = new ArrayList<>();
    //String[] items = {"Void staff", "Health potion", "Rat tail", "Chaos Robe"}; har lavet arraylist i stedet for at kunne lave et shop system med en tilføjelig list
    //int inventorySpace = 4; ville bruge i en while loop, men glemte det + lavede for each i stedet
    int percentage = 25;
    int healingSpell;
    int incomingDamage;
    double goldGained;
    int xpGained;
    String currentMonster;
    boolean healthCritical; // hvis det skulle bruges

    void printTitle(String name) {
        System.out.println("=== " + name + " ===");
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

    /*void levelUpCheck(){        // Ville lave en ny level up check der skal komme efter combat og loot
        if (xp >= levelUp){
            System.out.println("Ready to level up!");
        }

    }
    */

    void monsterType(String monsterName) {
        currentMonster = monsterName;
        System.out.println(name + " encounters " + currentMonster);
        spaceBuffer();
    }

    void combatCheck(int damage) {
        // Damage check
        incomingDamage = damage;
        System.out.println(" -" + currentMonster + "s turn- ");
        System.out.println(currentMonster + " does " + incomingDamage + " damage!");
        System.out.println(name + "'s Health: " + health + " -> " + (health = health - incomingDamage));

        // Health check
        if (health <= (maxHealth * percentage / 100)) {
            System.out.println("!WARNING!: Health critical!");
        }
        if (health <= 0) {
            isAlive = false;
            System.out.println(name + " is dead");
        } else {
            System.out.println(name + " is still alive");
        }
        spaceBuffer();
    }

    boolean isHealthCritical() {
        if (health <= (maxHealth * percentage / 100)) {
            System.out.println("!WARNING!: Health critical!");
            return healthCritical = true;
        }
        return healthCritical;
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
            maxHealth += 100;
            levelUp = level * 500;

        }

           /*for(level = 3; xp >= levelUp;){ // kunne kun levele op til 4 grundet jeg har sat level til en fast værdi af 3
               xp -= levelUp;
               level++;
               maxHealth += 100;
               levelUp = level * 500;
           }

            */
        System.out.println(name + " leveled up!");
        System.out.println(name + " is now level: " + level);
        System.out.println("Total xp: " + xp + "/" + levelUp);
        spaceBuffer();







        /* if (level < 100 && xp >= levelUp) {
           System.out.println(name + " leveled up!");
           level++;
           xp -= levelUp;
           levelUp = level * 500;
           System.out.println(name + " is now level: " + level);
       }

           if (xp >= levelUp) {
           System.out.println(name + " leveled up!");
           level++;
           System.out.println(level);
           xp = xp % levelUp;
       }
        */


    }

    void shopStop(String shopItem) {
        if (gold >= 70) {
            System.out.println("You have bought " + shopItem + "!");
            items.add(shopItem);
            gold -= 70;
        } else {
            System.out.println("You cant afford my goods");


        }
        spaceBuffer();
    }






        /*if (xp >= levelUp){     // Vil hellere lave et level up system end at der bare står man kan level up
           System.out.println("Ready to level up!");
       }
       */




    /*void healthCheck(){
        if (health <= ((maxHealth * percentage)/100)) {
            System.out.println("!WARNING!: Health critical!");
        }
        if (health <= 0){
            isAlive = false;
            System.out.println("Jarl is dead");
        } else {
            System.out.println("Jarl is still alive");
        }
    }

    void damageCheck(){
        System.out.println("Jarl took " + (incomingDamage) + " damage!");
        //System.out.println("Health: " + health + " -> " + (health - incomingDamage)); Havde glemt og tildele health en ny værdi, så den printede aldrig warning ud
        System.out.println("Health: " + health + " -> " + (health = health - incomingDamage));

    }
    */

    void spaceBuffer() {
        System.out.println("");
    }


    void main() {
        items.add("Void staff");
        items.add("Health potion");
        items.add("Rat tail");
        items.add("Chaos Robe");


        // VARIABLES
        /*String name = "Jarl";
        int health = 100;
        int maxHealth = 200;
        int level = 3;
        int xp = 2300;
        int levelUp = level*500;
        double gold = 20.5;
        boolean isAlive = true;
        char heroClass = 'W';
        String[] items = {"Void staff", "Health potion", "Rat tail", "Chaos Robe"};
        int inventorySpace = 4;
        int percentage = 25;

         */

        // CHARACTER STATS
        printTitle("Character stats");
        characterStats();
        /*System.out.println("=== Character stats ===");

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
        System.out.println("Health: " + health +"/"+maxHealth);
        System.out.println("Level: " + level);
        System.out.println("Experience points: "+xp);
        System.out.println("Gold: "+gold);
        System.out.println("Alive: "+isAlive);
        spaceBuffer();

         */

        // INVENTORY
        printTitle("Inventory");
        printInventory();
        spaceBuffer();
        //System.out.println("=== Inventory ===");
        /*for (String item : items){
            System.out.println("- " + item);
        }
         */

        /*while(inventorySpace <= 4){
            System.out.println("- " + items[0]);
            System.out.println("- " + items[1]);
            System.out.println("- " + items[2]);
            System.out.println("- " + items[3]);
            inventorySpace++;
        }
         */

       /* System.out.println("- "+items[0]);
        System.out.println("- "+items[1]);
        System.out.println("- "+items[2]);
        System.out.println("- "+items[3]);

        */


        //STATUS
        /*titles("Status");            // Har ændret i layout og hvornår der kommer level check
        levelUpCheck();
        spaceBuffer();
        */


        //System.out.println("=== Status ===");
        // Leveling system

        /*if (xp >= levelUp){    // ved ikke om det er smart at have i sin egen
            System.out.println("Ready to level up!");
        }
        System.out.println(" ");
        */


        // HERO LOGIC
        /*if (health <= ((maxHealth * percentage)/100)) {   Har haft health check inden combat hvilket godt kunne ligge efter
            System.out.println("!WARNING!: Health critical!");
        }
        if (health <= 0){
            isAlive = false;
            System.out.println("Jarl is dead");
        } else {
            System.out.println("Jarl is still alive");
        }

         */


        // COMBAT
        printTitle("Combat");
        monsterType("Ghoul");
        combatCheck(50);
        healing();
        printTitle("Combat loot");
        monsterLoot(800, 70);
        levelUpCheck();
        printTitle("Shopkeeper");
        shopStop("Crojiro");
        printTitle("Inventory");
        printInventory();
        System.out.println(isHealthCritical());
    }
}

        /*damageCheck();  //Tænkte det var smartere og samle damage og health check sammen -> kombinerede til combat check
        healthCheck();
        */

        //System.out.println("=== Combat ===");
        //int incomingDamage = 50;  flytter op til mine andre variabler så kan den ændres + ligger i sin egen metode
        //System.out.println("Jarl took " + (incomingDamage) + " damage!");
        //System.out.println("Health: " + health + " -> " + (health - incomingDamage));

        /*if (health > 0){   Har haft hero logic stående inden combat, og har prøvet og lave det her
            System.out.println("Jarl is still alive");
        } else {
            System.out.println("Jarl is dead");
        }
         */

        /*if (health <= ((maxHealth * percentage)/100)) { // lagde det efter combat, men ville hellere lave en method for health check, så det kunne bruges i flere situationer
            System.out.println("!WARNING!: Health critical!");
        }
        if (health <= 0){
            isAlive = false;
            System.out.println("Jarl is dead");
        } else {
            System.out.println("Jarl is still alive");
        }

         */

