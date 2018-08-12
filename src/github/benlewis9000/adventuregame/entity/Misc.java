package github.benlewis9000.adventuregame.entity;

public enum Misc implements Item{

    BOAT                ("Boat", "Use a boat to travel across water."),
    PORTAL_PIECE        ("Portal Piece", "Collect all ");

    String id;
    String desc;

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

    Misc(String id, String desc){
        this.setId(id);
        this.setDesc(desc);
    }

    @Override
    public String[] getInfo() {

        String[] info = new String[2];
        info[0] = id;
        info[1] = desc;

        return info;
    }

}
