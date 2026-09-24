import java.util.ArrayList;
public class HeroSim {

    class Item {
        String name;
        int weight;
        double value;

        Item(String name, int weight, double value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
    }

    class Weapon{
        String name;
        int damage;
        int durability;

        Weapon(String name, int damage, int durability){
            this.name = name;
            this.damage = damage;
            this.durability = durability;
        }

    }

    class Armor{
        String name;
        int defence;
        int durability;

        Armor(String name, int defence, int durability){
            this.name = name;
            this.defence = defence;
            this.durability = durability;
        }
    }

        class Character {
            String name;
            String heroClass;
            int health;
            int maxHealth;
            int attackPower;
            double gold;
            int level;
            ArrayList<Item> inventory = new ArrayList<>();
            Weapon weapon;
            Armor armor;

            Character(String name, String heroClass, int health, int maxHealth, int attackPower, double gold, int level) {
                this.name = name;
                this.heroClass = heroClass;
                this.health = health;
                this.maxHealth = maxHealth;
                this.attackPower = attackPower;
                this.gold = gold;
                this.level = level;

            }


            void printTitleCharacter(String name) {
                System.out.println("=== " + name + " (" + heroClass + ")" + " ===");
            }

            void printTitle(String name) {
                System.out.println("=== " + name + " ===");
            }


            void characterStats() {
                printTitleCharacter(name);
                System.out.println("Level: " + level + " | " + "Health: " + health + "/" + maxHealth + " | " + "Gold: " + gold);
                spaceBuffer();
            /*System.out.println("Name: " + name);
            switch (HeroSim.this.heroClass) {
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
            */

                //System.out.println("Health: " + health + "/" + maxHealth);
                // System.out.println("Experience points: " + xp);
                //System.out.println("Gold: " + gold);
                //System.out.println("Alive: " + isAlive);

            }

            void buyItem(Item item) {
                if(gold >= item.value && inventroyWeight() + item.weight <= 30) {
                    inventory.add(item);
                    System.out.println("You bought " + item.name + "!");
                    gold -= item.value;
                } else if (gold >= item.value && inventroyWeight() + item.weight > 30) {
                    System.out.println("You cannot carry anymore goods!");
                    spaceBuffer();
                }


            }

            void printInventroy(){
                for(Item item : inventory){
                    System.out.println("- " + item.name);
                }

            }

            int inventroyWeight(){
                int totalWeight = 0;
                for(Item item: inventory) {
                    totalWeight += item.weight;
                }
                return totalWeight;
            }


            void equipGear(Weapon weapon, Armor armor){
                this.weapon = weapon;
                this.armor = armor;
            }




            void damageCheck(Character target) {
                int incomingDamage = attackPower + weapon.damage;
                int totalDamage = (attackPower + weapon.damage) - target.armor.defence;
                if(target.armor.defence >= incomingDamage && weapon.durability > 0) {
                    System.out.println("Attack blocked!");
                    target.armor.durability -= 1;
                } else if (target.armor.defence < incomingDamage && weapon.durability > 0) {
                    printTitle(name);
                    System.out.println(name + " does " + totalDamage + " damage to " + target.name + "!");
                    target.health -= totalDamage;
                    weapon.durability -= 1;
                } else {
                    printTitle(name);
                    System.out.println("Weapon is broken!");
                    totalDamage -= (totalDamage * 80 / 100);
                    System.out.println(name + " does " + totalDamage + " damage to " + target.name + "!");
                    target.health -= totalDamage;
                }

            }


            void spaceBuffer() {
                System.out.println("");
            }

        }

        // VARIABLES
        boolean running = true;


        void main() {
            Character hero = new Character("Jarl", "Warlock", 150, 150, 25,200,3);
            Character enemy = new Character("Goblin", "Marauder",120 , 120, 15,10,1);

            Weapon heroWeapon = new Weapon("Shard Of The Northern realm",20,2);
            Weapon enemyWeapon = new Weapon("Copper Axe",10,5);

            Armor heroArmor = new Armor("Divine tabard",10,5);
            Armor enemyArmor = new Armor("Leather harness",5,5);

            hero.characterStats();
            enemy.characterStats();
            hero.equipGear(heroWeapon,heroArmor);
            enemy.equipGear(enemyWeapon,enemyArmor);

            while (running) {
                hero.damageCheck(enemy);
                enemy.damageCheck(hero);
                hero.spaceBuffer();
                hero.characterStats();
                enemy.characterStats();
                if (hero.health <= 0) {
                    System.out.println(hero.name + " is dead!");
                    running = false;
                }
                if (enemy.health <= 0) {
                    System.out.println(enemy.name + " is dead!");
                    enemy.spaceBuffer();
                    running = false;
                }
            }


            Item[] shopItem = new Item[5];
            shopItem[0] = new Item("Dad",20,20);
            shopItem[1] = new Item("Healing Potion",3,10);
            shopItem[2] = new Item("Binary book", 30,70);
            shopItem[3] = new Item("Dog",50,10);
            shopItem[4] = new Item("Imp Stone",1,100);


            hero.printTitle("Shop");
            hero.buyItem(shopItem[0]);
            hero.buyItem(shopItem[3]);
            hero.printTitle("Inventory");
            hero.printInventroy();





        }

    }




