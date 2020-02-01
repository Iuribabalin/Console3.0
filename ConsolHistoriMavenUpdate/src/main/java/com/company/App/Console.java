package com.company.App;

public class Console {
    /**
     * функция отвечает за вывод сообщений в консоль
     * @param param
     */
    public void printPrompt(String param){
        if(param.equals("")) {
            System.out.print(">>");
        }else{
            System.out.println(param);
        }
    }

}
