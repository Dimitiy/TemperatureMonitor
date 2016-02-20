package com.android.shiz.temperaturemonitor.listener;

/**
 * Created by OldMan on 19.02.2016.
 */
public interface Observable<T> {
    /**
     * Регистрирует нового прослушивателя
     */
    public void addObserver(T listener);

    /**
     * Удаляет ранее зарегистрированного прослушивателя
     */
    public void removeObserver(T listener);
    /**
     * Оповещаем зарегистрированного прослушивателя
     */
    public void notifyObservers(float temperature);

}
