package com.lquan.boot.converter;

import com.lquan.boot.bean.Persion;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author lquan
 * @create 2022- 12-03 下午6:47
 * @description  自定义消息转换器MessageConverter
 *
 */
public class LquanMessageConverter implements HttpMessageConverter<Persion> {
    /**
     * Indicates whether the given class can be read by this converter.
     *
     * @param clazz     the class to test for readability
     * @param mediaType the media type to read (can be {@code null} if not specified);
     *                  typically the value of a {@code Content-Type} header.
     * @return {@code true} if readable; {@code false} otherwise
     *
     * 不关心读是否支持读转换功能
     */
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    /**
     * Indicates whether the given class can be written by this converter.
     *
     * @param clazz     the class to test for writability
     * @param mediaType the media type to write (can be {@code null} if not specified);
     *                  typically the value of an {@code Accept} header.
     * @return {@code true} if writable; {@code false} otherwise
     *
     * 只要写功能的Class类是Persion类型就支持写
     *
     */
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        if(clazz.isAssignableFrom(Persion.class)){
            return true;
        }
        return false;
    }

    /**
     * Return the list of media types supported by this converter. The list may
     * not apply to every possible target element type and calls to this method
     * should typically be guarded via {@link #canWrite(Class, MediaType)
     * canWrite(clazz, null}. The list may also exclude MIME types supported
     * only for a specific class. Alternatively, use
     * {@link #getSupportedMediaTypes(Class)} for a more precise list.
     *
     * @return the list of supported media types
     *
     * 服务器要统计所欲MessageConverter都能写出那些内容类型
     *
     * 告诉系统支持application/x-lquan
     *
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {

        return MediaType.parseMediaTypes("application/x-lquan");
    }


    /**
     * Read an object of the given type from the given input message, and returns it.
     *
     * @param clazz        the type of object to return. This type must have previously been passed to the
     *                     {@link #canRead canRead} method of this interface, which must have returned {@code true}.
     * @param inputMessage the HTTP input message to read from
     * @return the converted object
     * @throws IOException                     in case of I/O errors
     * @throws HttpMessageNotReadableException in case of conversion errors
     */
    @Override
    public Persion read(Class<? extends Persion> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**
     * Write a given object to the given output message.
     *
     * @param persion       the object to write to the output message. The type of this object must have previously been
     *                      passed to the {@link #canWrite canWrite} method of this interface, which must have returned {@code true}.
     * @param contentType   the content type to use when writing. May be {@code null} to indicate that the
     *                      default content type of the converter must be used. If not {@code null}, this media type must have
     *                      previously been passed to the {@link #canWrite canWrite} method of this interface, which must have
     *                      returned {@code true}.
     * @param outputMessage the message to write to
     * @throws IOException                     in case of I/O errors
     * @throws HttpMessageNotWritableException in case of conversion errors
     */
    @Override
    public void write(Persion persion, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义协议数据的写出
        String data = "lquan:" + persion.getUserName()+";"+persion.getAge()+";"+persion.getBirth();

        // 写出去
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());

    }
}
