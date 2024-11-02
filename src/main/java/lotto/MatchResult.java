package lotto;

public enum MatchResult {
    NO_MATCH(0, false) {
        @Override
        public void win(WinningStatics statics) {
        }
    },
    FIFTH_PLACE(3, false) {
        @Override
        public void win(WinningStatics statics) {
            statics.winFifth();
        }
    },
    FOURTH_PLACE(4, false) {
        @Override
        public void win(WinningStatics statics) {
            statics.winFourth();
        }
    },
    THIRD_PLACE(5, false) {
        @Override
        public void win(WinningStatics statics) {
            statics.winThird();
        }
    },
    SECOND_PLACE(5, true) {
        @Override
        public void win(WinningStatics statics) {
            statics.winSecond();
        }
    },
    FIRST_PLACE(6, false) {
        @Override
        public void win(WinningStatics statics) {
            statics.winFirst();
        }
    };

    public abstract void win(WinningStatics statics);

    private final int match;
    private final boolean bonus;

    MatchResult(int match, boolean bonus) {
        this.match = match;
        this.bonus = bonus;
    }

    public static MatchResult valueOf(int match, boolean bonus) {
        if (match == 5) {
            return bonus ? SECOND_PLACE : THIRD_PLACE;
        }
        for (MatchResult result : values()) {
            if (result.match == match) {
                return result;
            }
        }
        return NO_MATCH;
    }
}
