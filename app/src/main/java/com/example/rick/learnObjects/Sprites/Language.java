package com.example.rick.learnObjects.Sprites;

import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class Language extends Sprite {
    private String lang;
    public Language(Image image, String lang, int x, int y, int height, int width) {
        super(image, x, y, height, width);
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
