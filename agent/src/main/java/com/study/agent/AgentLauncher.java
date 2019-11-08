package com.study.agent;

import com.study.Transformer;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

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

        inst.addTransformer(new Transformer(),true);
        try {
            inst.retransformClasses(new Class<?>[]{Class.forName("com.study.Account")});
        } catch (Exception e) {
            System.out.println("agentmain after error"+e);
        }

        System.out.println("agentmain after");
    }

}
