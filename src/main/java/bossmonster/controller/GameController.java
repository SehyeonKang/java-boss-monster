package bossmonster.controller;

import bossmonster.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.dto.BattleInfoDto;
import bossmonster.service.Battle;
import bossmonster.view.GameView;

import java.util.List;

public class GameController {

    final int END = 0;
    int turnCount;
    Player player;
    BossMonster bossMonster;
    Battle battle;
    GameView gameView;

    public void play() {
        turnCount = 1;
        battle = new Battle();
        gameView = new GameView();

        progressInitialSetting();
        progressBattle();
    }

    private void progressInitialSetting() {
        player = new Player();
        bossMonster = new BossMonster();

        progressBossHpSetting();
        progressPlayerNameSetting();
        progressPlayerStatusSetting();

    }

    private int progressBossHpSetting() {
        int bossMonsterHp = gameView.printBossHpSettingView();

        try {
            bossMonster.setHp(bossMonsterHp);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보스 체력은 100이상, 300이하여야합니다.");
            return progressBossHpSetting();
        }

        return END;
    }

    private int progressPlayerNameSetting() {
        String playerName = gameView.printPlayerNameSettingView();

        try {
            player.setName(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 플레이어의 이름은 5자 이하만 가능합니다.");
            return progressPlayerNameSetting();
        }

        return END;
    }

    private int progressPlayerStatusSetting() {
        List<Integer> playerStatus = gameView.printPlayerStatusSettingView();

        try {
            player.setStatus(playerStatus.get(0), playerStatus.get(1));
        } catch (IllegalArgumentException e) {
            System.out.println("HP와 MP의 합이 200이 되도록 입력해주세요.");
            return progressPlayerStatusSetting();
        }

        return END;
    }

    private void progressBattle() {
        while (true) {
            BattleInfoDto battleInfoDto = new BattleInfoDto(bossMonster, player);
            int attackTypeNum = gameView.printPlayerPhaseView(battleInfoDto, turnCount);
            AttackType attackType = new AttackType(attackTypeNum);
            player.attackBossMonster(bossMonster, attackType);
            if (battle.isVictory(bossMonster)) {
                endGameByVictory(battleInfoDto, turnCount);
                break;
            }

            int bossDamage = bossMonster.attackPlayer(player);
            gameView.printBossPhaseView(bossDamage);
            if (battle.isDefeat(player)) {
                endGameByDefeat(battleInfoDto, turnCount);
                break;
            }

            turnCount++;
        }
    }

    private void endGameByVictory(BattleInfoDto battleInfoDto, int turnCount) {
        gameView.printEndGameByVictoryView(battleInfoDto, turnCount);
    }

    private void endGameByDefeat(BattleInfoDto battleInfoDto, int turnCount) {
        gameView.printEndGameByDefeatView(battleInfoDto, turnCount);
    }
}
