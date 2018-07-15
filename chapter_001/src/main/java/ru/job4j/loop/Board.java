package ru.job4j.loop;
/**
 *Class Board - в данном классе происходит построение шахматной доски.
 *@author Anton Kondratkov
 *@since 19.11.2017
 */
public class Board {
    /**
     * Метод строит шахматную доску.
     * @param width - ширина доски.
     * @param height - высота доски.
     * @return - строку содержащую построенную доску.
     */

    public String paint(int width, int height) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    result.append("X");
                } else {
                    result.append(" ");
                }
            }
            result.append(System.getProperty("line.separator"));
        }
        return result.toString();
    }
}
