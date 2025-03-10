package lab5.Commands;

import lab5.tools.ExecutionResponse;

public interface Executable {

    ExecutionResponse apply(String[] arguments);
}