# 📚 기능 목록
## 👨‍🦱 플레이어 정보 - Player
> 플레이어의 정보가 있는 엔티티 클래스
- 이름
  - 플레이어의 이름은 5자 이하만 가능하다.
  - 예외 처리 - ``validatePlayerName``
    - 🚫 플레이어 이름이 6자 이상일 경우
- HP, MP
  - 플레이어의 초기 HP와 MP 합은 200이다.
  - 예외 처리 - ``validatePlayerStatus``
    - 🚫 플레이어의 초기 HP와 MP 합이 200이 아닌 경우
</br>

## 🐺 보스 몬스터 정보 - BossMonster
> 보스 몬스터의 정보가 있는 엔티티 클래스
- HP
  - 보스 몬스터의 초기 HP는 100이상 300이하이다.
  - 예외 처리 - ``validateBossStatus``
    - 🚫 보스 몬스터의 초기 HP가 100미만 300초과일 경우
- 진행 턴 수 -  ``turnCount``
</br>

## 📝 초기 세팅 - InitialSetting
> 보스 몬스터의 HP와 플레이어의 이름, HP, MP를 세팅하는 서비스 클래스
- 플레이어의 초기 정보를 저장한다. - ``setPlayerStatus``
- 보스 몬스터의 초기 정보를 저장한다. - ``setBossMonsterStatus``
</br>

## ⚔️ 전투 진행 - Battle
> 전투를 진행하는 서비스 클래스
- 플레이어가 보스 몬스터를 공격한다. - ``attackBossMonster``
- 보스 몬스터가 플레이어를 공격한다. - ``attackPlayer``
- 보스 레이드가 종료됐는지 확인한다. - ``isBattleEnd``
</br>

## 🎮 게임 프로그램 - GameController
> 게임을 진행하는 컨트롤러 클래스
- 게임을 시작한다. - ``play``
- 플레이어와 보스 몬스터의 초기 능력치를 세팅한다. - ``setInitialStatus``
- 전투를 진행한다. - ``progressBattle``
</br>

## 🖥️ 게임 화면 - GameView
> 게임 화면을 출력하며 사용자의 입력을 받는 뷰 클래스
- 초기 능력치를 세팅하는 화면을 출력하고 사용자의 입력을 받는다. - ``printStatusSettingView``
- 전투 화면을 출력하고 사용자의 입력을 받는다. - ``printBattleView``
- 결과 화면을 출력한다. - ``printResultView``
</br>

## ⛔ 예외 처리 - Validator
> 예외를 처리하는 클래스
- 사용자가 잘못된 값을 입력할 경우 ``IllegalArgumentException``을 발생시킨다.
- "[ERROR]"로 시작하는 에러 메시지를 출력한다.
    - 플레이어 이름의 잘못된 값에 대한 예외 - ``validatePlayerName``
    - 플레이어 능력치의 잘못된 값에 대한 예외 - ``validatePlayerStatus``
    - 보스 몬스터 능력치의 잘못된 값에 대한 예외 - ``validateBossStatus``
</br>
