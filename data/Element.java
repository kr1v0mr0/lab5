package lab5.data;

import lab5.tools.Validatable;

public abstract class Element implements  Comparable<MusicBand>, Validatable {
    abstract public int getId();
}
