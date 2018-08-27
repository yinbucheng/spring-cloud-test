package cn.intellif.springtestall;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class BeanUtils {
    private static Set<Class> primitiveWrapperClass = new HashSet<>();

    static{
        primitiveWrapperClass.add(Boolean.class);
        primitiveWrapperClass.add(Byte.class);
        primitiveWrapperClass.add(Character.class);
        primitiveWrapperClass.add(Double.class);
        primitiveWrapperClass.add(Integer.class);
        primitiveWrapperClass.add(Long.class);
        primitiveWrapperClass.add(Short.class);
    }

    /**
     * 是否基础类型int/int/int[]
     * @param clazz
     * @return
     */
    public static boolean isSimpleType(Class clazz){
        if(!clazz.isArray()){
            return clazz.isPrimitive()||Enum.class.isAssignableFrom(clazz) ||
                    CharSequence.class.isAssignableFrom(clazz) ||
                    Number.class.isAssignableFrom(clazz) ||
                    Date.class.isAssignableFrom(clazz) ||
                    URI.class == clazz || URL.class == clazz ||
                    Locale.class == clazz || Class.class == clazz||primitiveWrapperClass.contains(clazz);
        }
        clazz = clazz.getComponentType();
        return isSimpleType(clazz);
    }

}