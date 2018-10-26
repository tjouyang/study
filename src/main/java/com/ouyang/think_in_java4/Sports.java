package com.ouyang.think_in_java4;

public interface Sports {

    enum BALL implements Sports {
        BASKETBALL, BADMINTON, FOOTBALL, TABLE_TENNIS
    }

    enum RUN implements Sports {
        LOW, FAST
    }

    default String CustomToString() {
        return toString();
    }
}
