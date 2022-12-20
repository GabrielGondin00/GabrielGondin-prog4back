package Reflexão;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.persistence.Column;

import br.ueg.application.exceptions.service.ServiceException;

public class Nullreflexao<Entidade>{
	
    public void  ValidarCampoNulo(Entidade entidade) {
    	Class<?> clas = entidade.getClass();
    	Field [] fields  = clas.getDeclaredFields();
    	
    	for(Field field : fields) {
    		if(field.isAnnotationPresent(Column.class)) {
    			Column anotation = field.getAnnotation(Column.class);
    			if(anotation.nullable() == false) {
    				try {
    					field.setAccessible(true);
						if(field.get(entidade) ==null || field.get(entidade).toString().isEmpty()) {
							throw new ServiceException("Campos em branco");
						}
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    		}
    	}
	
}
}
