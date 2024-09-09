package com.finartz.userregistration.entity;

public enum OptionEnum {
    EXCELLENT(5, "Üstün başarılı performans"),
    VERY_GOOD(4, "Çok başarılı performans"),
    GOOD(3, "Başarılı performans"),
    AVERAGE(2, "Geliştirilmesi gereken performans"),
    POOR(1, "Yetersiz performans"),
    NO_OPINION(0, "Fikrim yok");

    private final int score;
    private final String description;

    OptionEnum(int score, String description) {
        this.score = score;
        this.description = description;
    }

    public int getScore(){
        return score;
    }

    public String getDescription(){
        return description;
    }
    
}
