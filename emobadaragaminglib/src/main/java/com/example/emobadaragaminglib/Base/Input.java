package com.example.emobadaragaminglib.Base;

import java.util.List;

/**
 * this interface is used to map between the types of different events
 * TODO: Implement the Touch_hold
 */
public interface Input {
    /**
     * Enumeration and Organization of Work
     */
    class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;
        public static final int TOUCH_HOLD = 3;

        public int type;
        public int x, y;
        public int pointer;
    }

    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<TouchEvent> getTouchEvents();
}
