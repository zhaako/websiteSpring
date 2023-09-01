package kz.springboot.springbootdemo.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Items> items = new ArrayList<>();

    static {
        items.add(new Items(1L,"Iphone 11 pro max",400000));
        items.add(new Items(2L,"Xiaomi Redmi note 9",200000));
        items.add(new Items(1L,"Samsung Galaxy note 11",320000));
        items.add(new Items(1L,"Nokia 3110",15000));
    }
    private static Long id = 5L;

    public static ArrayList<Items> getItems(){
        return items;
    }

    public static void addItem(Items item){
        item.setId(id);
        items.add(item);
        id++;
    }
}
