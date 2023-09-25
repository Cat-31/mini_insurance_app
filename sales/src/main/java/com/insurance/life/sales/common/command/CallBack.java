package com.insurance.life.sales.common.command;

@FunctionalInterface
public interface CallBack<T> {
    void callBack(T o);
}
