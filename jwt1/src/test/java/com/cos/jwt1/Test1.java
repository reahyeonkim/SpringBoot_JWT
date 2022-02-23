package com.cos.jwt1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Test1 {

    @Test
    public void Collection_Test(){
        String[] str = {"ROLE_USER","ROLE_ADMIN","ROLE_MANAGER"};
        List<String>list = Arrays.asList(str);
        for (String s :list){
            System.out.println(s);
        }
    }
}
