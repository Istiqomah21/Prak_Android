package com.example.tugas4;

import com.example.tugas4.Menu;

import java.util.ArrayList;

public class MenuData {
    private static String[] menuNames = {
            "Super Besar 2",
            "Crispy Box",
            "Super Family",
            "Wingers",
            "Mocha Float",
            "Cream Soup",
    };

    private static String[] menuImages = {
            "https://files.kfcku.com/uploads/media/dummy/food/kfc-web_super-besar2_l.png",
            "https://files.kfcku.com/uploads/media/dummy/food/kfc-web_crispy-box_l.png",
            "https://files.kfcku.com/uploads/media/food-menu/spesial/thumbnail/kfc-web_super-familyhcc_t.png",
            "https://files.kfcku.com/uploads/media/dummy/food/kfc-web_wingers_l.png",
            "https://files.kfcku.com/uploads/media/food-menu/drinks/large/kfc-web_mocha-float_l_1.png",
            "https://files.kfcku.com/uploads/media/dummy/food/kfc-web_creamsoup_l.png",
    };

    private static String[] menuDetails = {
            "Nasi + 2 ptg Ayam + Minuman",
            "Nasi + Ayam + Chicken Strips + Minuman",
            "5 Pcs Chicken + 3 Rice + 3 Cups Coca-Cola Med",
            "Wingers",
            "Mocha Float",
            "Cream Soup",
    };

    private static String[] menuHarga = {
            "Rp55.000",
            "Rp48.000",
            "Rp142.500",
            "Rp23.000",
            "Rp12.500",
            "Rp12.500",
    };

    static ArrayList<Menu> getListData(){
        ArrayList<Menu> list = new ArrayList<>();

        for (int position = 0; position < menuNames.length; position++){
            Menu menu = new Menu(
                    menuNames[position],
                    menuDetails[position],
                    menuImages[position],
                    menuHarga[position]
            );
            list.add(menu);
        }
        return list;
    }
}
