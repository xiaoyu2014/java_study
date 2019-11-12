package com.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @Author: yuqi
 * @Date: 2019-11-08 11:49
 */
public class AttachTransformer implements ClassFileTransformer {

    public static final String accountOperation2 = "/Users/yuqi12/Documents/gitproject/javastudy/module/target/classes/com/study/Account.attach.class";

    public static byte[] getBytesFromFile(String fileName) {
        File file = new File(fileName);
        InputStream is = null;
        try{
            is = new FileInputStream(file);
            long length = file.length();
            byte[] bytes = new byte[(int) length];

            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset <bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Could not completely read file "
                        + file.getName());
            }
            System.out.println(fileName + "已替换");
            return bytes;
        } catch (Exception e) {
            System.out.println("error occurs in _ClassTransformer!"
                    + e.getClass().getName());
            return null;
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public byte[] transform(ClassLoader l, String className, Class<?> c,
                            ProtectionDomain pd, byte[] b) throws IllegalClassFormatException {
        System.out.println("transform:"+className);
        if (!className.equals("com/study/Account")) {
            return null;
        }
        return getBytesFromFile(accountOperation2);

    }
}
