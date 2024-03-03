package com.dev.air.util;

import com.dev.air.value.Value;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValueInstance {

    public List<Value> getValues() {
        final List<Value> values = new ArrayList<>();

        for(final Field field : getClass().getDeclaredFields()) {
            try{
                field.setAccessible(true);

                final Object o = field.get(this);

                if(o instanceof Value) {
                    values.add((Value) o);
                }
            }catch(IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return values;
    }

}
