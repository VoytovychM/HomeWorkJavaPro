package homework20240612;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// 1. Создать список ArrayList. Наполнить данными. Через рефлексию вывести
// информацию о размере внутреннего массива, увеличить размер внутреннего массива вызовом приватного метода grow().
public class ReflectionTask {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        ArrayList arrayList = new ArrayList<>(5);
        arrayList.add("String");


        Field internalArray = arrayList.getClass().getDeclaredField("elementData");
        internalArray.setAccessible(true);
        Object[] elementData = (Object[]) internalArray.get(arrayList);
        System.out.println(elementData.length);

        Method methodGrow = arrayList.getClass().getDeclaredMethod("grow", int.class);
        methodGrow.setAccessible(true);
        methodGrow.invoke(arrayList, 10);
        elementData = (Object[]) internalArray.get(arrayList);
        System.out.println(elementData.length);


    }
}
