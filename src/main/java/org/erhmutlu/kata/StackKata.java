package org.erhmutlu.kata;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackKata {

    private Stack<Integer> stack;

    private List<List<Command>> transactionCommands;

    public StackKata() {
        stack = new Stack<>();
        transactionCommands = new LinkedList<>();
    }

    public void push(int value) {
        if (transactionCommands.size() > 0) {
            List<Command> currentTransactionCommands = retrieveCurrentTransactionCommands();
            currentTransactionCommands.add(createPushCommand(value));
        }
        stack.push(value);
    }

    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        }

        return 0;
    }

    public void pop() {
        if (!stack.isEmpty()) {
            Integer topValue = stack.peek();
            if (transactionCommands.size() > 0) {
                List<Command> currentTransactionCommands = retrieveCurrentTransactionCommands();
                currentTransactionCommands.add(createPopCommand(topValue));
            }
            stack.pop();
        }
    }

    public void begin() {
        transactionCommands.add(new LinkedList<>());
    }

    public boolean rollback() {
        if (hasNotActiveTransaction()) {
            return false;
        }

        List<Command> currentTransactionCommands = retrieveCurrentTransactionCommands();
        for (int i = currentTransactionCommands.size() - 1; i >= 0; i--) {
            Command command = currentTransactionCommands.get(i);
            if (CommandType.isPushCommand(command.getCommandType())) {
                stack.pop();
            } else {
                stack.push(command.getValue());
            }
        }
        removeLastTransaction();
        return true;
    }

    public boolean commit() {
        if (hasNotActiveTransaction()) {
            return false;
        }

        if (transactionCommands.size() > 1) {
            List<Command> currentCommands = retrieveCurrentTransactionCommands();
            transactionCommands.get(transactionCommands.size() - 2).addAll(currentCommands);
        }

        removeLastTransaction();
        return true;
    }

    private boolean hasNotActiveTransaction() {
        return transactionCommands.size() == 0;
    }

    private List<Command> retrieveCurrentTransactionCommands() {
        return transactionCommands.get(transactionCommands.size() - 1);
    }

    private void removeLastTransaction() {
        transactionCommands.remove(transactionCommands.size() - 1);
    }

    private Command createPushCommand(int value) {
        Command command = new Command();
        command.setCommandType(CommandType.PUSH);
        command.setValue(value);
        return command;
    }

    private Command createPopCommand(int value) {
        Command command = new Command();
        command.setCommandType(CommandType.POP);
        command.setValue(value);
        return command;
    }

    class Command {
        private CommandType commandType;
        private Integer value;

        public CommandType getCommandType() {
            return commandType;
        }

        public void setCommandType(CommandType commandType) {
            this.commandType = commandType;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    enum CommandType {
        PUSH, POP;

        static boolean isPushCommand(CommandType commandType) {
            return PUSH.equals(commandType);
        }

        static boolean isPopCommand(CommandType commandType) {
            return POP.equals(commandType);
        }
    }


    public static void main(String[] args) {
        StackKata sol = new StackKata();
        System.out.println(sol.top());
//        sol.push(4);
//        sol.begin();                    // start transaction 1
//        sol.push(7);                    // stack: [4,7]
//        sol.begin();                    // start transaction 2
//        sol.push(2);                    // stack: [4,7,2]
//        sol.rollback();
//
//        System.out.println(sol.top());
//        sol.begin();                    // start transaction 3
//        sol.push(10);                   // stack: [4,7,10]
//        sol.commit();
//        System.out.println(sol.top());
//        sol.rollback();
//        System.out.println(sol.top());
//        sol.commit();
    }

}
