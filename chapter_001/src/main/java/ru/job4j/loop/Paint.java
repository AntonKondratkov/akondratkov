package ru.job4j.loop;
/**
 *Class piramid - в данном классе происходит построение пирамиды.
 *@author Anton Kondratkov
 *@since 19.11.2017
 */
public class Paint {
    /**
     * Метод строит пирамиду.
     * @param h - высота пирамиды.
     * @return - строку содержащую построенную пирамиду.
     */
    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h * 2; j++) {
                if (j > h - 2 - i && j < h + i) {
                    builder.append("^");
                } else if (j < h) {
                    builder.append(" ");
                }
            }
            builder.append(System.getProperty("line.separator"));
            }
        return builder.toString();
    }
}
