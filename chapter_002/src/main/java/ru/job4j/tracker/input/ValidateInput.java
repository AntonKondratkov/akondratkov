package ru.job4j.tracker.input;

/**
 * @author Anton Kondratkov
 * @since 18.07.18.
 * В данном классе перекрываем поведение метода ask из родительского класса.
 **/
public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate again");
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            }
        } while (invalid);
        return value;
    }
}
