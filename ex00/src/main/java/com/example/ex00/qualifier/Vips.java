package com.example.ex00.qualifier;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@Qualifier("vips")
public class Vips implements Resturant{
    int price = Resturant.steakPrice - 20000;

    public int getPrice(){
        return steakPrice - 20000;
    }

    @Override
    public boolean useSaladBar() {
        return true;
    }
}
