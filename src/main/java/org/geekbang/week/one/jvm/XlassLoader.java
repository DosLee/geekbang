package org.geekbang.week.one.jvm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * 描述:
 *
 * @author lil
 */
public class XlassLoader extends ClassLoader {
    public static void main(String[] args) {
        process(args);
    }

    /**
     * 处理方法
     *
     * @param args 需要加载的类的名称
     */
    private static void process(String[] args) {
        // 判端是否输入参数
        String className = Optional.ofNullable(args).filter(Objects::nonNull)
                .map(arg -> args[0])
                .filter(Objects::nonNull)
                .filter(str -> 0 < str.length())
                .orElseThrow(IllegalArgumentException::new);
        try {
            Class<?> loadClass = new XlassLoader().loadClass(className);
            Method[] methods = loadClass.getDeclaredMethods();
            Object instance = loadClass.getDeclaredConstructor().newInstance();
            Arrays.stream(methods).forEach(method -> {
                String m = method.getName();
                System.out.println("列出方法名称: " + m);
                try {
                    // 调用方法
                    loadClass.getMethod(m).invoke(instance);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            });
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String path = this.getClass().getResource("/").getPath();
            byte[] fileBytes = Files.readAllBytes(Paths.get(path + name + ".xlass"));
            if (0 == fileBytes.length) {
                throw new IOException("文件未找到或文件为空!");
            }
            byte[] decoderByte = decoder(fileBytes);
            return defineClass(name, decoderByte, 0, decoderByte.length);
        } catch (IOException e) {
            e.printStackTrace();
            return null; 
        }
        //try (InputStream resource = this.getClass().getClassLoader().getResourceAsStream(path + ".xlass");) {
        //    if (resource == null) {
        //        throw new IOException("没有找到文件!");
        //    }
        //    int available = resource.available();
        //    if (available == 0) {
        //        throw new IOException("忽略空文件");
        //    }
        //    byte[] bytes = new byte[available];
        //    resource.read(bytes);
        //    byte[] decoderByte = decoder(bytes);
        //    return defineClass(name, decoderByte, 0, decoderByte.length);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //    return null;
        //}
    }

    /**
     * 解密xlass文件
     *
     * @param bytes xlass文件字节
     * @return 解密后的字节流
     */
    private byte[] decoder(byte[] bytes) {
        byte[] byteCopy = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            byteCopy[i] = (byte) (255 - bytes[i]);
        }
        return byteCopy;
    }
}
