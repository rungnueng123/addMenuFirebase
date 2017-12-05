package com.rungnueng.com.firebaseaddvalue;

/**
 * Created by RUNGNUENG on 4/12/2560.
 */

public class Menu {

    String Name;
    String NameThai;
    String Description;
    String Ingredient;
    String ImgUrl;
    
    public Menu(){

    }

    public Menu(String name, String nameThai, String description, String ingredient, String imgUrl) {
        Name = name;
        NameThai = nameThai;
        Description = description;
        Ingredient = ingredient;
        ImgUrl = imgUrl;
    }

    public String getName() {
        return Name;
    }

    public String getNameThai() {
        return NameThai;
    }

    public String getDescription() {
        return Description;
    }

    public String getIngredient() {
        return Ingredient;
    }

    public String getImgUrl() {
        return ImgUrl;
    }
}
