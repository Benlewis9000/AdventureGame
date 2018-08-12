package github.benlewis9000.adventuregame.entity;

public enum Potion implements Item{

    HEALTH_POTION    ("Health Potion", "Consume to replenish your health.", 10f),
    STRENGTH_POTION ("Strength Potion", "Consume to temporarily increase the strength of your attacks", 1.5f);

    String id;
    String desc;
    float strength;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    Potion(String id, String desc, float strength){
        this.setId(id);
        this.setDesc(desc);
        this.setStrength(strength);
    }

    @Override
    public String[] getInfo() {

        String[] info = new String[3];
        info[0] = id;
        info[1] = desc;
        info[2] = "Strength: " + strength;

        return info;
    }

}
