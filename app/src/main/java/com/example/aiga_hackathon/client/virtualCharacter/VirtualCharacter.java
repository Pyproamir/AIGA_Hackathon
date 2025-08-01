package com.example.aiga_hackathon.client.virtualCharacter;

public class VirtualCharacter {
    private int lvl;
    private int hp;
    private int maxHp;
    private int skillSlots;
    private int skill;
    private int bonuses;
    private int rank;

    public VirtualCharacter(int lvl, int hp, int maxHp, int skillSlots, int skill, int bonuses, int rank) {
        this.lvl = lvl;
        this.hp = hp;
        this.skillSlots = skillSlots;
        this.skill = skill;
        this.bonuses = bonuses;
        this.rank = rank;
        this.maxHp = maxHp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSkillSlots() {
        return skillSlots;
    }

    public void setSkillSlots(int skillSlots) {
        this.skillSlots = skillSlots;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getBonuses() {
        return bonuses;
    }

    public void setBonuses(int bonuses) {
        this.bonuses = bonuses;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int max_hp) {
        this.maxHp = max_hp;
    }
}
