package github.benlewis9000.adventuregame.entity;

public enum Weapon implements Item {

    // Todo: enum WeaponType for these defaults, taken into object Weapon object and modifiable variables (e.g. int upgrade) added

    FIST("Fist", "You'll want something a bit sharper than this...", 3, 0.7f, 0.8f),
    DAGGER("Dagger", "Light, fast, and accurate - as all weapons should be.", 6, 0.9f, 0.95f),
    SWORD("Sword", "Sharp and durable, the sword is a reliable and well balanced weapon.", 12, 0.75f, 0.9f),
    BATTLE_AXE("Battle Axe", "Chop a path through your enemies.", 22, 0.7f, 0.7f),
    WAR_HAMMER("War Hammer", "Deal untold damage, if you can handle it...", 30, 0.6f, 0.7f);


    String id;
    String desc;
    int damage; // Base damage (later run through +-20% modifier)
    float speed; // percentage (decimal) that they will hit per swing - fail means too slow, thus monster strikes
    float accuracy; // percentage (decimal) that a fast enough swing will collide with monster - fail means swing is attempted again


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    Weapon (String id, String desc, int damage, float speed, float accuracy){
        this.setId(id);
        this.setDescription(desc);
        this.setDamage(damage);
        this.setSpeed(speed);
        this.setAccuracy(accuracy);
    }

    @Override
    public String[] getInfo() {

        String[] info = new String[5];
        info[0] = id;
        info[1] = desc;
        info[2] = "Damage: " + damage;
        info[3] = "Speed: " + speed;
        info[4] = "Accuracy: " + accuracy;

        return info;
    }


}
