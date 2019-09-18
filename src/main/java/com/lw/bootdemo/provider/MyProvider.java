package com.lw.bootdemo.provider;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: langwei
 * @date: 2018-12-02 17:31:49
 **/
public class MyProvider {

    public String selectOneById(Map param) {
        Class<?> clazz = (Class<?>) param.get("clazz");
        StringBuilder sb = new StringBuilder();
        sb.append("select ");
        // 利用反射获取表名和字段名
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column declaredAnnotation = field.getDeclaredAnnotation(Column.class);
                String column = declaredAnnotation.name();
                String fieldName = field.getName();
                sb.append(column + " as " + fieldName + ",");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        }
        Table annotation = clazz.getAnnotation(Table.class);
        String tableName = annotation.name();
        sb.append(" from " + tableName);
        sb.append(" where id = #{id}");
        return sb.toString();
    }

    public String select(Map param) {
        Object obj = param.get("t");
        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder();
        StringBuilder whereSb = new StringBuilder();
        sb.append("select ");
        whereSb.append(" where 1=1");
        // 利用反射获取表名和字段名
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column declaredAnnotation = field.getDeclaredAnnotation(Column.class);
                String column = declaredAnnotation.name();
                String fieldName = field.getName();
                sb.append(column + " as " + fieldName + ",");
                String methodName = "get" + captureName(fieldName);
                try {
                    Method method = clazz.getDeclaredMethod(methodName, null);
                    Object value = method.invoke(obj);
                    if (value != null) {
                        whereSb.append(" AND " + column + " = #{t." + fieldName + "}");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        if (sb.toString().endsWith(",")) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        }
        Table annotation = clazz.getAnnotation(Table.class);
        String tableName = annotation.name();
        sb.append(" from " + tableName);
        sb.append(whereSb);
        return sb.toString();

    }

    public static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);

    }

}
