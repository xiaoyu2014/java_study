package com.study.agent;

import com.study.Transformer;

import java.io.File;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.jar.JarFile;

/**
 * @Author: yuqi
 * @Date: 2019-10-14 16:54
 */
public class AgentLauncher {

    public static void premain(final String featureString, final Instrumentation inst){

        System.out.println("premain featureString:" + featureString);

        inst.addTransformer(new Transformer(),true);

        System.out.println("premain after");
    }

    public static void agentmain(final String featureString, final Instrumentation inst) {

        System.out.println("agentmain featureString:" + featureString);

        try {
            //inst.appendToBootstrapClassLoaderSearch(new JarFile(new File("/Users/yuqi12/.m2/repository/com/study/module/1.0-SNAPSHOT/module-1.0-SNAPSHOT.jar")));
            inst.addTransformer(new Transformer(),true);
            inst.retransformClasses(new Class<?>[]{Class.forName("com.study.Account")});
        } catch (Exception e) {
            System.out.println("agentmain after error"+e);
        }

        System.out.println("agentmain after");
    }

}
