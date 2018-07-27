package github.benlewis9000.adventuregame.entity;

public enum Potion implements Item{

    HEALTH_POTION    ("Health Potion", "Consume to replenish health.", 10);

    String name;
    String desc;
    int strength;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    Potion(String name, String desc, int strength){
        this.setName(name);
        this.setDesc(desc);
        this.setStrength(strength);
    }

    @Override
    public String[] getInfo() {

        String[] info = new String[3];
        info[0] = name;
        info[1] = desc;
        info[2] = "Strength: " + strength;

        return info;
    }

}
