package github.benlewis9000.adventuregame.entity;

public enum Misc implements Item{

    BOAT                ("Boat", "Use a boat to travel across water.");

    String name;
    String desc;

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

    Misc(String name, String desc){
        this.setName(name);
        this.setDesc(desc);
    }

    @Override
    public String[] getInfo() {

        String[] info = new String[2];
        info[0] = name;
        info[1] = desc;

        return info;
    }

}
