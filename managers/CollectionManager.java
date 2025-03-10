package lab5.managers;

import lab5.data.MusicBand;

import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {
    private int currentId = 1;
    private HashMap<Integer, MusicBand> collection = new HashMap<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final DumpManager dumpManager;

    public CollectionManager(DumpManager dumpManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.dumpManager = dumpManager;
    }
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }
    public HashMap<Integer, MusicBand> getCollection() {
        return collection;
    }
    public MusicBand byId(int id) { return collection.get(id); }
    public boolean isСontain(MusicBand e) { return e == null || byId(e.getId()) != null; }
    public int getFreeId() {
        while (byId(++currentId) != null);
        return currentId;
    }
    public boolean add(MusicBand a) {
        if (isСontain(a)) return false;
        collection.put(a.getId(), a);
        update();
        return true;
    }

    public boolean update(MusicBand a) {
        if (!isСontain(a)) return false;
        collection.remove(byId(a.getId()));
        collection.put(a.getId(), a);
        update();
        return true;
    }
    public boolean remove(int id) {
        var a = byId(id);
        if (a == null) return false;
        collection.remove(a.getId());
        update();
        return true;
    }
    public void update() {
        List<Map.Entry<Integer, MusicBand>> list = new ArrayList<>(collection.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, MusicBand>>() {
            public int compare(Map.Entry<Integer, MusicBand> o1, Map.Entry<Integer, MusicBand> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        collection = new HashMap<>();

        for (Map.Entry<Integer, MusicBand> entry : list) {
            collection.put(entry.getKey(), entry.getValue());
        }
    }

    public boolean init() {
        collection.clear();
        collection = dumpManager.readCollection();
        lastInitTime = LocalDateTime.now();
        update();
        return true;
    }
    public void saveCollection() {
        dumpManager.writeCollection(collection);
        lastSaveTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) return "Коллекция пуста!";

        StringBuilder info = new StringBuilder();
        for (var MusicBand : collection.values()) {
            info.append(MusicBand+"\n\n");
        }
        return info.toString().trim();
    }
}