package net.sreerammanatt.ProductApp.Utils;

import net.sreerammanatt.ProductApp.Enums.Exceptions;

import java.util.Arrays;

 public  class ExceptionUtils {

    public static Exceptions deCodeExceptionWithNumber(Integer num) {
        return  Arrays.stream(Exceptions.values())
                        .filter(x -> num.equals(x.getExceptionNumber()))
                        .findAny().orElse(null);


    }


}
