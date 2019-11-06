package com.study.agent;

import java.io.File;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.jar.JarFile;

/**
 * @Author: yuqi
 * @Date: 2019-10-14 16:54
 */
public class AgentLauncher {

    public static void premain(final String featureString, final Instrumentation inst){

        System.out.println("premain featureString:" + featureString);

        /*inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain, byte[] classfileBuffer)
                    throws IllegalClassFormatException {
                System.out.println("premain load Class     :" + className);
                try {
                    inst.appendToBootstrapClassLoaderSearch(new JarFile(new File(
                            "/Users/yuqi12/.m2/repository/com/study/core/1.0-SNAPSHOT/core-1.0-SNAPSHOT-jar-with-dependencies.jar")
                    ));
                }catch (Exception e){

                }

                return classfileBuffer;
            }
        }, true);*/



    }

    public static void agentmain(final String featureString, final Instrumentation inst) {

        System.out.println("agentmain featureString:" + featureString);

        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain, byte[] classfileBuffer)
                    throws IllegalClassFormatException {
                System.out.println("agentmain load Class     :" + className);
                return classfileBuffer;
            }
        }, true);

    }

}
