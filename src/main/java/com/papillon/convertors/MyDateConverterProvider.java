package com.papillon.convertors;

import com.papillon.datatypes.MyDate;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

/**
 * Created by papillon on 5/8/2017.
 */
@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType.getName().equals(MyDate.class.getName())){
            return new ParamConverter<T>() {
                @Override
                public T fromString(String value) {
                    Calendar requestedDate = Calendar.getInstance();
                    if(value.equalsIgnoreCase("tomorrow")){
                        requestedDate.add(Calendar.DATE,1);
                    } else if(value.equalsIgnoreCase("yesterday")){
                        requestedDate.add(Calendar.DATE,-1);
                    } else
                        requestedDate.add(Calendar.DATE,0);
                    MyDate md = new MyDate();
                    md.setDate(requestedDate.get(Calendar.DATE));
                    md.setMonth(requestedDate.get(Calendar.MONTH));
                    md.setYear(requestedDate.get(Calendar.YEAR));
                    return rawType.cast(md);
                }

                @Override
                public String toString(T value) {
                    if(value==null)
                        return null;
                    else
                        return value.toString();
                }
            };
        } else
            return null;
    }
}
