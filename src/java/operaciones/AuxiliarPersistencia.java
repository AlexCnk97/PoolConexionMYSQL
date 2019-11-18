/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import anotaciones.AutoIncrement;
import anotaciones.Entity;
import anotaciones.FieldName;
import anotaciones.PrimaryKey;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DARQ
 */
public class AuxiliarPersistencia {
    
    public String getEntityName(Object entity) throws Exception{
        String nombre = "";
        Class clase = entity.getClass();
        Annotation[] anotaciones = clase.getAnnotationsByType(Entity.class);
        
        //Validamos que existan anotaciones
        if(anotaciones.length == 0){
            throw new Exception(String.format("Debe de agregar la anotación Entity a la clase %s", clase.getSimpleName()));
        }
        
        for (Annotation anotacion : anotaciones) {
            Entity e = (Entity) anotacion;
            nombre = e.table();
            
            if("".equals(nombre)){
                nombre = clase.getSimpleName();
            }
        }
        
        return nombre;
    }
    
    public List<FieldClass> getCampos(Object entity) throws Exception{
        ArrayList<FieldClass> campos = new ArrayList<>();
        Class clase = entity.getClass();
        Field[] fields = clase.getDeclaredFields();
        int nauto_increment = 0;
        for (Field field : fields) {
            FieldClass campo = new FieldClass();
            if(field.isAnnotationPresent(FieldName.class)){
                FieldName fc = field.getAnnotation(FieldName.class);
                campo.setNombre(fc.name());
            }else{
                campo.setNombre(field.getName());
            }
            //Preguntamos si el primer campo es considerado como autoincrement
            if(nauto_increment == 0){
                if(field.isAnnotationPresent(PrimaryKey.class)){
                    campo.setPrimary(true);
                    nauto_increment++;
                }else{
                 throw new Exception(String.format("La clase %s solo debe contener un campo como llave primaria (PrimaryKey).", clase.getSimpleName()));
                }
            }
            //Validamos si es autoincrement
            if(field.isAnnotationPresent(AutoIncrement.class)){
                if(campo.isPrimary()){
                    campo.setAutoincrement(true);
                }else{
                     throw new Exception("La anotación AutoIncrement solo puede asociarse a una llave primaria.");   
                }
            }
            //Validamos si tiene una notacion de not null
            if(field.isAnnotationPresent(NotNull.class)){
                campo.setNotnull(true);
            }
             try {                     
                 Field f = clase.getDeclaredField(field.getName());                     
                 f.setAccessible(true);                     
                 campo.setValor(field.get(entity));                             
             } catch (IllegalAccessException | IllegalArgumentException ex) {                 
                 throw ex;
             }                             
             campos.add(campo); 
        }
        return campos;
    }
}
