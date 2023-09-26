package bossmonster.exception;

import java.awt.print.PrinterIOException;
import java.util.StringTokenizer;

public class Validator {

    final String PREFIX = "[ERROR] ";
    final String regex = "^[^0]\\d*";

    public void validateBossStatus(String hp) {
        if (!hp.matches(regex)) {
            throw new IllegalArgumentException(PREFIX + "보스 체력은 100이상, 300이하의 정수로 입력해주세요.");
        }

        int hpNum = Integer.parseInt(hp);
        if (hpNum < 100 || hpNum > 300) {
            throw new IllegalArgumentException(PREFIX + "보스 체력은 100이상, 300이하여야합니다.");
        }
    }

    public void validatePlayerName(String playerName) {
        if (playerName.length() > 5) {
            throw new IllegalArgumentException(PREFIX + "플레이어의 이름은 5자 이하만 가능합니다.");
        }
    }

    public void validatePlayerStatus(String status) {
        StringTokenizer st = new StringTokenizer(status, ",");
        String hp = st.nextToken();

        if (!st.hasMoreTokens()) {
            throw new IllegalArgumentException(PREFIX + "HP와 MP를 콤마(,)로 구분하여 입력해주세요. (예: 100,100)");
        }

        String mp = st.nextToken();

        if (!hp.matches(regex) || !mp.matches(regex)) {
            throw new IllegalArgumentException(PREFIX + "HP와 MP를 콤마(,)로 구분하여 정수로 입력해주세요. (예: 100,100)");
        }

        int hpNum = Integer.parseInt(hp);
        int mpNum = Integer.parseInt(mp);

        if (hpNum + mpNum != 200) {
            throw new IllegalArgumentException(PREFIX + "HP와 MP의 합이 200이 되도록 입력해주세요.");
        }
    }
}
