package github.benlewis9000.adventuregame.entity;

public enum Resource implements Item {

    WOOD ("Wood", "Used as a crafting component."),
    IRON ("Iron", "Used as a crafting component.");

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


    Resource (String name, String desc){
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
