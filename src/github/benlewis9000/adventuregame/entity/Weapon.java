package github.benlewis9000.adventuregame.entity;

public enum Weapon implements Item {

    // Todo: enum WeaponType for these defaults, taken into object Weapon object and modifiable variables (e.g. int upgrade) added

    DAGGER              ("Dagger", "Light, fast, and accurate - as all weapons should be.", 4, 0.7f, 0.95f, 1),
    SWORD               ("Sword", "Sharp and durable, the sword is a reliable and well balanced weapon.", 12, 0.3f, 0.9f, 2),
    BATTLE_AXE          ("Battle Axe", "Chop a path through your enemies.", 18, 0.1f, 0.87f, 3),
    WAR_HAMMER          ("War Hammer", "Deal untold damage, if you can handle it...", 24, 0.0f, 0.7f, 4);

    String name;
    String desc;
    int damage;
    float speed;
    float accuracy;
    int priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    Weapon (String name, String desc, int damage, float speed, float accuracy, int priority){
        this.setName(name);
        this.setDescription(desc);
        this.setDamage(damage);
        this.setSpeed(speed);
        this.setAccuracy(accuracy);
        this.setPriority(priority);
    }

    @Override
    public String[] getInfo() {

        String[] info = new String[5];
        info[0] = name;
        info[1] = desc;
        info[2] = "Damage: " + damage;
        info[3] = "Speed: " + speed;
        info[4] = "Accuracy: " + accuracy;

        return info;
    }


}
