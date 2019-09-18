package com.lw.bootdemo.provider;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;

/**
 * @author: langwei
 * @date: 2018-12-02 22:47:25
 **/
public class MyTkProvider extends MapperTemplate {
    public MyTkProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String selectOr(MappedStatement ms) {
        Class<?> clazz = getEntityClass(ms);
        StringBuilder sb = new StringBuilder();
        StringBuilder whereSb = new StringBuilder();
        sb.append("select ");
        whereSb.append(" <where>");
        // 利用反射获取表名和字段名
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column declaredAnnotation = field.getDeclaredAnnotation(Column.class);
                String column = declaredAnnotation.name();
                String fieldName = field.getName();
                sb.append(column + " as " + fieldName + ",");

                whereSb.append("<if test=\"" + fieldName + " != null\"> or " + column + " = #{" + fieldName + "}</if>");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        }
        Table annotation = clazz.getAnnotation(Table.class);
        String tableName = annotation.name();
        sb.append(" from " + tableName);
        whereSb.append(" </where>");
        sb.append(whereSb);
        return sb.toString();
    }

}
