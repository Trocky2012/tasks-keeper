package com.starengtech.tasksKeeper.entities.Enum;

public enum NoteStatus {
    
    CREATED,
    ACTIVE,
    DONE,
    DELETED;

    static
    public final NoteStatus[] values = values();

    public NoteStatus prev() {
        return values[(ordinal() - 1  + values.length) % values.length];
    }

    public NoteStatus next() {
        return values[(ordinal() + 1) % values.length];
    }

}
