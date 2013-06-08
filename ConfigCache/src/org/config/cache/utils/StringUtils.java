package org.config.cache.utils;

import java.lang.reflect.Field;
import org.config.cache.StringArray;

/**
 * @author chenjie
 * 2012-12-5
 */
public final class StringUtils {

	/**
	 * �ж�ָ�����ַ����Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public final static boolean isEmpty(String str){
		
		return str == null || str.trim().length() == 0;
		
	}
	
	
	/**
	 * ��str��delim���зָ������ǿ��ַ���Ҳ��Ϊһ�����õ�Ԫ��
	 * @param str
	 * @param delim
	 * @return
	 */
	public final static StringArray split(String str, String delim){
		if(isEmpty(str)){
			return null;
		}
		
		System.out.println(str);
		String[] elems = str.split(delim);
		
		return new StringArray(elems);
	}
	
	/**
	 * ��ָ�����ַ���ת��Ϊint
	 * @param str
	 * @return
	 */
	public final static int toInt(String str){
		if(isEmpty(str)){
			return 0;
		}
		
		Double d = Double.parseDouble(str);
		
		return d.intValue();
		
	}
	
	/**
	 * ��ָ�����ַ���ת��Ϊlong
	 * @param str
	 * @return
	 */
	public final static long toLong(String str){
		
		if(isEmpty(str)){
			return 0;
		}
		
		Double d = Double.parseDouble(str);
		
		return d.longValue();
	}
	
	/**
	 * ��ָ�����ַ���ת��Ϊfloat
	 * @param str
	 * @return
	 */
	public final static float toFloat(String str){
		if(isEmpty(str)){
			return 0.0f;
		}
		
		Double d = Double.parseDouble(str);
		
		return d.floatValue();
	}
	
	/**
	 * ��ָ�����ַ���ת��Ϊdouble
	 * @param str
	 * @return
	 */
	public final static double toDouble(String str){
		if(isEmpty(str)){
			return 0;
		}
		
		Double d = Double.parseDouble(str);
		
		return d;
	}
	
	/**
	 * ���ָ����ʵ����ÿһ��ֵ
	 * @param entityClass
	 * @param instance
	 * @return
	 */
	public final static String toString(Class<?> entityClass, Object instance){
		Field[] fields = entityClass.getDeclaredFields();
		if(fields != null){
			StringBuilder sb = new StringBuilder();
			
			for(Field f : fields){
				int modifiers = f.getModifiers();
				if(modifiers != 25){
					try {
						f.setAccessible(true);
						Object value = f.get(instance);
						
						if(value instanceof Integer[]){
							Integer[] values = (Integer[])value;
							for(int i=0; i<values.length;i++){
								sb.append(f.getName()).append(":").append(values[i]).append("	");
							}
						}else {
							sb.append(f.getName()).append(":").append(value).append("	");
						}
						
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}

			}
			
			return sb.toString();
		}
		
		return null;
	}
	
}