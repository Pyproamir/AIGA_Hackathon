package com.example.aiga_hackathon.client.virtualCharacter;

public class VirtualFighter {
    private String fighterName;
    private int fighterLvl;
    private int fighterHp;
    private int fighterSkill;
    private int fighterPlace;
    private int fighterMaxHp;

    public VirtualFighter(String fighterName, int fighterLvl, int fighterHp, int fighterMaxHp, int fighterSkill, int fighterPlace) {
        this.fighterName = fighterName;
        this.fighterLvl = fighterLvl;
        this.fighterHp = fighterHp;
        this.fighterSkill = fighterSkill;
        this.fighterPlace = fighterPlace;
        this.fighterMaxHp = fighterMaxHp;
    }

    public String getFighterName() {
        return fighterName;
    }

    public void setFighterName(String fighterName) {
        this.fighterName = fighterName;
    }

    public int getFighterLvl() {
        return fighterLvl;
    }

    public void setFighterLvl(int fighterLvl) {
        this.fighterLvl = fighterLvl;
    }

    public int getFighterHp() {
        return fighterHp;
    }

    public void setFighterHp(int fighterHp) {
        this.fighterHp = fighterHp;
    }

    public int getFighterSkill() {
        return fighterSkill;
    }

    public void setFighterSkill(int fighterSkill) {
        this.fighterSkill = fighterSkill;
    }

    public int getFighterPlace() {
        return fighterPlace;
    }

    public void setFighterPlace(int fighterPlace) {
        this.fighterPlace = fighterPlace;
    }

    public int getFighterMaxHp() {
        return fighterMaxHp;
    }

    public void setFighterMaxHp(int fighterMaxHp) {
        this.fighterMaxHp = fighterMaxHp;
    }
}
