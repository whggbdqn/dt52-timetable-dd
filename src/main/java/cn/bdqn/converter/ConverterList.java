package cn.bdqn.converter;

import java.util.List;

/**
 * 
 * @ClassName Convertor
 * @Description 
 * @author yw
 * @Date 2018年2月3日 下午5:25:46
 * @version 1.0.0
 * @param <T1>
 * @param <T2>
 */
public interface ConverterList<T1, T2> {
    /**
     * 
     * @Description (将一个集合对象转换成另一个集合对象)
     * @param list
     * @return
     * @throws Exception 
     */
    List<T2> convert(List<T1> list) throws Exception;

}
