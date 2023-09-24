package com.insurance.life.sales.common.command;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandExecutor {

    private Map<String, CommandHandlerFunction> context = new HashMap<>();

    public CommandExecutor(List<BaseCommandHandler> handlerList) {
        handlerList.stream().forEach(handler -> {
            Arrays.stream(handler.getClass().getMethods()).forEach(method -> {
                if (method.isAnnotationPresent(CommandHandler.class)) {
                    String commandName = method.getParameterTypes()[0].getName();
                    context.put(commandName, (cmd, callback) -> {
                        Object ret = method.invoke(handler, cmd);
                        if (callback != null && ret != null) {
                            callback.callBack(ret);
                        }
                    });
                }
            });
        });
    }

    public void execute(Command cmd, CallBack callBack) {
        try {
            context.get(cmd.getClass().getName()).handler(cmd, callBack);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute(Command cmd) {
        execute(cmd, null);
    }
}
