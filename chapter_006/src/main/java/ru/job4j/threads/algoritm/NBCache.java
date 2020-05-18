package ru.job4j.threads.algoritm;

import java.util.concurrent.ConcurrentHashMap;

public class NBCache {
    private ConcurrentHashMap<Integer, Base> cache;

    public NBCache() {
        cache = new ConcurrentHashMap<>();
    }

    public void add(Base model) {
        cache.put(model.getId(), model);
    }

    public Base update(Base model, String name) {
        int result = cache.get(model.getId()).getVersion();
        return cache.computeIfPresent(model.getId(),
                (id, value) -> {
                    try {
                        if (result == value.getVersion()) {
                            cache.get(id).setName(name);
                            cache.get(id).increment();
                        } else {
                            throw new OptimisticException(Thread.currentThread().getName());
                        }
                    } catch (OptimisticException oe) {
                        oe.getMessage();
                    }
                    return value;
                }
        );
    }

    public void delete(Base model) {
        cache.remove(model.getId());
    }

    static class Base {
        private int id;
        private int version;
        private String name;

        public Base(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void increment() {
            version++;
        }

        public int getId() {
            return id;
        }

        public int getVersion() {
            return version;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Base{"
                    + "id=" + getId()
                    + ", version=" + getVersion()
                    + ", name='" + getName() + '\''
                    + '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NBCache nbCache = new NBCache();
        Base base = new Base(1, "Bob");

        nbCache.add(base);

        Thread thread1 = new Thread(() -> System.out.println(nbCache.update(base, "Tom")), "Thread #1");

        Thread thread2 = new Thread(() -> System.out.println(nbCache.update(base, "Tim")), "Thread #2");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
