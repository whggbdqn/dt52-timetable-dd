package cn.bdqn.converter;


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
public interface ConverterPojo<T1, T2> {

    /**
     * 
     * @Description (将一个对象转换成另一个对象)
     * @param vo
     * @return
     * @throws Exception 
     */
     T2 convert(T1 vo) throws Exception;
}
