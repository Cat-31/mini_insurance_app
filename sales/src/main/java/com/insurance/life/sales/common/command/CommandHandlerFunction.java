package com.insurance.life.sales.common.command;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface CommandHandlerFunction {
    void handler(Command command, CallBack callBack) throws InvocationTargetException, IllegalAccessException;
}
