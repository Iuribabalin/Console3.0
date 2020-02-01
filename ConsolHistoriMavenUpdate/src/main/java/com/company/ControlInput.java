package com.company;

public class ControlInput {
    /**
     * Класс обрабатывает введённу строку
      * @param Input
     * @return out
     */
    public String sanitize(String Input){
        Input = Input.trim();

        String[] arr = Input.split(" ");
        StringBuilder out = new StringBuilder();

        out.append(arr[0]).append(": ");

        for(int i = 1; i<arr.length;i++)
            out.append(arr[i]).append(" ");

        return out.toString();
    }
}
