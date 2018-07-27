package github.benlewis9000.adventuregame.entity;

public enum Weapon implements Item {

    DAGGER              ("Dagger", "Light, fast, and accurate - as all weapons should be.", 4, 0.7f, 0.95f),
    SWORD               ("Sword", "Sharp and durable, the sword is a reliable and well balanced weapon", 12, 0.3f, 0.9f),
    BATTLE_AXE          ("Battle Axe", "Chop a path through your enemies.", 18, 0.1f, 0.87f),
    WAR_HAMMER          ("War Hammer", "Deal untold damage, if you can handle it...", 24, 0.0f, 0.7f);

    String name;
    String desc;
    int damage;
    float speed;
    float accuracy;

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

    Weapon (String name, String desc, int damage, float speed, float accuracy){
        this.setName(name);
        this.setDescription(desc);
        this.setDamage(damage);
        this.setSpeed(speed);
        this.setAccuracy(accuracy);
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
