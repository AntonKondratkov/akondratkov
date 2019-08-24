package ru.job4j.calculator;

import java.util.function.Consumer;
/**
 * Engineer calculator
 *
 * @author Kondratkov Anton
 * @since 24.08.2019
 */
public class EngineerCalculator extends InteractCalc {

    public EngineerCalculator(Input input, Consumer<String> output) {
        super(input, output);
    }

    class Cos implements ArithmeticOperation {

        @Override
        public Double execute(Double hold, Double input) {
            return Math.cos(hold);
        }

        @Override
        public CalculatorInputType nextInputType() {
            return CalculatorInputType.OPERATION;
        }
    }

    class Sin implements ArithmeticOperation {

        @Override
        public Double execute(Double hold, Double input) {
            return Math.sin(hold);
        }

        @Override
        public CalculatorInputType nextInputType() {
            return CalculatorInputType.OPERATION;
        }
    }

    @Override
    protected void loadOperations() {
        super.loadOperations();
        addOperation("sin", new Sin());
        addOperation("cos", new Cos());
    }
}