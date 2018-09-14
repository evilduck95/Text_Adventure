package com.textAdventure.Text_Adventure;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.textAdventure.Text_Adventure.Json.Deserialize.TestItemDeserializer;

@JsonDeserialize(using = TestItemDeserializer.class)
public class TestItem {

    int num;
    String str;

    // Constructor ==[]
    public TestItem(int num, String str) {
        this.num = num;
        this.str = str;
    }

    // Getters (#) ==>
    public int getNum() {
        return num;
    }

    public String getStr() {
        return str;
    }

    // Setters ==> [#]
    public void setNum(int num) {
        this.num = num;
    }

    public void setStr(String str) {
        this.str = str;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TestItem:\n")
                .append(String.format("num: %d\n", num))
                .append(String.format("str: %s", str));

        return sb.toString();
    }


}
