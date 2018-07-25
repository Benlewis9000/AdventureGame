package github.benlewis9000.adventuregame.entity;

public enum Weapon {

    DAGGER              ("Dagger", "Light, fast, and accurate - as all weapons should be.", 4, 0.7f, 0.95f),
    SWORD               ("Sword", "Sharp and durable, the sword is a reliable and well balanced weapon", 12, 0.3f, 0.9f),
    BATTLE_AXE          ("Battle Axe", "Use a boat to travel across water.", 18, 0.1f, 0.87f),
    WAR_HAMMER          ("War Hammer", "Deal untold damage, if you can handle it...", 24, 0.0f, 0.7f);

    Weapon (String name, String description, int damage, float speed, float accuracy){

    }



}
