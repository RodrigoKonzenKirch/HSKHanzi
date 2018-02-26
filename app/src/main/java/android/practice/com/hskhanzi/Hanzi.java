package android.practice.com.hskhanzi;

import java.io.Serializable;

/**
 * Holds values of a hanzi character
 */
class Hanzi implements Serializable{
    private String id;
    private String hsk;
    private String hanzi;
    private String pinyin;
    private String english;
    private String level;
    public static final int LEVEL_MIN_VALUE = 0;
    public static final int LEVEL_MAX_VALUE = 4;

    Hanzi(String id, String hsk, String hanzi, String pinyin, String english, String level){
        this.id = id;
        this.hsk = hsk;
        this.hanzi = hanzi;
        this.pinyin = pinyin;
        this.english = english;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHsk() {
        return hsk;
    }

    public void setHsk(String hsk) {
        this.hsk = hsk;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
