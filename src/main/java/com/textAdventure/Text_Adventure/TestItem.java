package com.textAdventure.Text_Adventure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.textAdventure.Text_Adventure.Transformers.Deserialize.TestItemDeserializer;
import org.springframework.data.annotation.Id;

@JsonDeserialize(using = TestItemDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestItem {

    @Id
    int num;
    String str;

    public TestItem(int num, String str) {
        this.num = num;
        this.str = str;
    }

    public int getNum() {
        return num;
    }
    public String getStr() {
        return str;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public void setStr(String str) {
        this.str = str;
    }


    @Override
    public String toString() {
        String sb = "TestItem:\n" +
                String.format("num: %d\n", num) +
                String.format("str: %s", str);
        return sb;
    }


}
