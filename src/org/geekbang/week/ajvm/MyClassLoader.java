package org.geekbang.week.ajvm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * 描述:
 * 自定义Classloader
 *
 * @author lil
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> helloClass = new MyClassLoader().loadClass("Hello");
            Object helloInstance = helloClass.getDeclaredConstructor().newInstance();
            Arrays.stream(helloClass.getDeclaredMethods()).forEach(method -> {
                try {
                    // 调用方法
                    helloClass.getMethod(method.getName()).invoke(helloInstance);
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
            String filePath = this.getClass().getResource("").getPath();
            String suffix = ".xlass"; 
            // 读取文件转byte
            byte[] bytes = Files.readAllBytes(new File(filePath + name + suffix).toPath());
            if (0 == bytes.length) {
                throw new IOException("读取文件错误");
            }
            // 解码
            byte[] decode = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                decode[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, decode, 0, decode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
