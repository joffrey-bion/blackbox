package com.joffrey_bion.games.blackbox.model;

public class EntryPort {

    private Side side;
    private int index;
    private PortState state;
    private int detourNumber;
    private EntryPort twin;

    public EntryPort(Side side, int index) {
        this.side = side;
        this.index = index;
        this.state = PortState.UNKNOWN;
        this.detourNumber = -1;
        this.twin = null;
    }

    public Side getSide() {
        return side;
    }

    public int getIndex() {
        return index;
    }

    void setState(PortState state) {
        if (this.state != PortState.UNKNOWN) {
            throw new RuntimeException("Entry port state (" + side + "," + index + ") already set.");
        }
        this.state = state;
    }

    public PortState getState() {
        return state;
    }

    void setTwin(EntryPort twin) {
        if (this.twin != null) {
            throw new RuntimeException("Twin already set.");
        }
        this.twin = twin;
    }

    public EntryPort getTwin() {
        return twin;
    }

    @Override
    public String toString() {
        switch (state) {
        case UNKNOWN:
            return " ";
        case HIT:
            return "H";
        case REFLECT:
            return "R";
        case DETOUR:
            return "D";
        }
        return null;
    }
}
