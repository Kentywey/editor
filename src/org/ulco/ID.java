package org.ulco;

public class ID {
    static public int ID = 0;
    private static ID INSTANCE = null;

    private ID() {
    }

    public int currentId() {
        return ID;
    }

    public int nextId() {
        return ++ID;
    }

    public static ID getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ID();
        }
        return INSTANCE;
    }
}