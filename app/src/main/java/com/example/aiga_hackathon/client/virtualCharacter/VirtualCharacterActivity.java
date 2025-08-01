package com.example.aiga_hackathon.client.virtualCharacter;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aiga_hackathon.R;

public class VirtualCharacterActivity extends AppCompatActivity {

    private TextView place, lvl, hp, skill, skillSlots, fighterPlace, fighterLvl, fighterHp, fighterSkill, fighterName;
    private ProgressBar hpBar, fightBar, energyBar;
    private ImageView fight, fighterButton;
    private ImageButton addButton, backButton;
    private EditText name;
    private View fighterContainer, dim;
    private VirtualFighter virtualFighter;
    private VirtualCharacter virtualCharacter;
    private Handler handler = new Handler();
    private Runnable combatRunnable;
    private boolean isFighting = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_virtual_character);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        place = findViewById(R.id.tx_leaderboard_place);
        lvl = findViewById(R.id.tx_lvl);
        hp = findViewById(R.id.tx_hp);
        skillSlots = findViewById(R.id.tx_skill_slots);
        skill = findViewById(R.id.tx_grappling_skill);

        hpBar = findViewById(R.id.hp_bar);
        fightBar = findViewById(R.id.fight_bar);
        energyBar = findViewById(R.id.energy_bar);

        fight = findViewById(R.id.iv_fight);
        addButton = findViewById(R.id.ib_add);
        name = findViewById(R.id.name_fight_input);
        fighterContainer = findViewById(R.id.popup_view);
        dim = findViewById(R.id.dim_background);

        // fighter_item
        fighterPlace = fighterContainer.findViewById(R.id.tx_fighter_rank);
        fighterLvl = fighterContainer.findViewById(R.id.tx_fighter_lvl);
        fighterHp = fighterContainer.findViewById(R.id.tx_fighter_hp);
        fighterSkill = fighterContainer.findViewById(R.id.tx_fighter_skill);
        fighterName = fighterContainer.findViewById(R.id.tx_fighter_name);
        fighterButton = fighterContainer.findViewById(R.id.iv_fight_fighter);
        backButton = fighterContainer.findViewById(R.id.back_fighter_button);

        virtualCharacter = new VirtualCharacter(94, 24667, 24667,11, 506, 20,1248 );

        virtualFighter = new VirtualFighter("Amankeldi Ibrahim", 99, 29057, 29057,600, 500);


        fight.setOnClickListener(v->{
            if(name.getText().toString().trim().isEmpty() || name.getText().toString() == null){
                name.setError("Enter user name to fight");
                return;
            }
            else{
                fighterName.setText(virtualFighter.getFighterName());
                fighterLvl.setText(String.format("LVL: %d", virtualFighter.getFighterLvl()));
                fighterHp.setText(String.format("HP - %d/%d", virtualFighter.getFighterHp(), virtualFighter.getFighterMaxHp()));
                fighterPlace.setText(String.format("Rank: %d", virtualFighter.getFighterPlace()));
                fighterSkill.setText(String.format("Grappling Skill: %d", virtualFighter.getFighterSkill()));

                fighterContainer.setVisibility(View.VISIBLE);
                dim.setVisibility(View.VISIBLE);
            }

        });

        fighterButton.setOnClickListener(v->{
            startAutoFight();
        });
        backButton.setOnClickListener(v -> {
            fighterContainer.setVisibility(View.GONE);
            dim.setVisibility(View.GONE);
        });
        addButton.setOnClickListener(v->{
            applySkillSlots();
        });







    }
    private void bindCharacterInfo(VirtualCharacter character) {
        lvl.setText("LVL: " + character.getLvl());
        hp.setText("HP - " + character.getHp() + "/" + character.getMaxHp());
        skill.setText("Grappling Skill: " + character.getSkill());
        skillSlots.setText("Skill Slots: " + character.getSkillSlots());
        place.setText("Rank: " + character.getRank());

        int hpPercent = (int) ((character.getHp() * 100.0f) / character.getMaxHp());
        ObjectAnimator.ofInt(hpBar, "progress", hpPercent)
                .setDuration(500)
                .start();
    }

    private void applySkillSlots() {
        int skillGain = virtualCharacter.getSkillSlots() * 10;
        virtualCharacter.setSkill(virtualCharacter.getSkill() + skillGain);
        virtualCharacter.setSkillSlots(0);
        bindCharacterInfo(virtualCharacter);
    }


    public void startAutoFight() {
        isFighting = true;
        fightBar.setProgress(0);
        final int totalSteps = 10;
        final int delay = 500; // milliseconds
        final int maxEnergyLoss = 15;

        combatRunnable = new Runnable() {
            int step = 0;
            int playerHp = virtualCharacter.getHp();
            int fighterHp = virtualFighter.getFighterHp();
            int playerPower = calculatePower(virtualCharacter);
            int fighterPower = calculateFighterPower(virtualFighter);

            @Override
            public void run() {
                if (step < totalSteps && playerHp > 0 && fighterHp > 0) {
                    int dmgToFighter = generateDamage(playerPower);
                    int dmgToPlayer = generateDamage(fighterPower);

                    fighterHp = Math.max(0, fighterHp - dmgToFighter);
                    playerHp = Math.max(0, playerHp - dmgToPlayer);

                    updateFightUI(playerHp, fighterHp, (step + 1) * 10);

                    step++;
                    handler.postDelayed(this, delay);
                } else {
                    finishFight(playerHp, fighterHp, maxEnergyLoss);
                    isFighting = false;
                }
            }
        };

        handler.post(combatRunnable);
    }

    private int calculatePower(VirtualCharacter character) {
        return character.getSkill() + character.getLvl() * 3 + (int)(character.getHp() * 0.01f);}

    private int calculateFighterPower(VirtualFighter fighter) {
        return fighter.getFighterSkill() + fighter.getFighterLvl() * 3 + (int)(fighter.getFighterHp() * 0.01f);
    }

    private int generateDamage(int power) {
        return (int)(power * (0.7 + Math.random() * 0.3));
    }

    private void updateFightUI(int newPlayerHp, int newFighterHp, int fightProgress) {
        virtualCharacter.setHp(newPlayerHp);
        virtualFighter.setFighterHp(newFighterHp);

        hp.setText("HP - " + newPlayerHp + "/" + virtualCharacter.getMaxHp());
        fighterHp.setText("HP - " + newFighterHp + "/" + virtualFighter.getFighterMaxHp());

        hpBar.setProgress((int)((newPlayerHp * 100f) / virtualCharacter.getMaxHp()));
        fightBar.setProgress(fightProgress);
    }
    private void finishFight(int playerHp, int fighterHp, int energyLoss) {
        dim.setVisibility(View.GONE);
        fighterContainer.setVisibility(View.GONE);

        energyBar.setProgress(Math.max(0, energyBar.getProgress() - energyLoss));

        if (fighterHp == 0 && playerHp > 0) {
            virtualCharacter.setSkill(virtualCharacter.getSkill() + 20);
            virtualCharacter.setLvl(virtualCharacter.getLvl() + 1);
            virtualCharacter.setHp(virtualCharacter.getMaxHp());

            Toast.makeText(this, "Victory! +1 LVL, +20 Skill", Toast.LENGTH_SHORT).show();


            if (virtualFighter.getFighterPlace() < virtualCharacter.getRank()) {
                int tmp = virtualCharacter.getRank();
                virtualCharacter.setRank(virtualFighter.getFighterPlace());
                virtualFighter.setFighterPlace(tmp);
            }

        } else if (playerHp == 0 && fighterHp > 0) {
            Toast.makeText(this, "Defeated!", Toast.LENGTH_SHORT).show();


            if (virtualFighter.getFighterPlace() > virtualCharacter.getRank()) {
                int tmp = virtualCharacter.getRank();
                virtualCharacter.setRank(virtualFighter.getFighterPlace());
                virtualFighter.setFighterPlace(tmp);
            }
        } else {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }

        bindCharacterInfo(virtualCharacter);
    }



}