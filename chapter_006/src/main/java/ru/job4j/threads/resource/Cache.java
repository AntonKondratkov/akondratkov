package ru.job4j.threads.resource;
 /**
 * Класс показывает один из способов синхронизации метода.
 * @author Anton Kondratkov
 * @since 10.05.2020
 */
public final class Cache {
    private static Cache cache;

    private synchronized static Cache instOf() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}
