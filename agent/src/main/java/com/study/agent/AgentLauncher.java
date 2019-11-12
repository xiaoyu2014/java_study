package com.study.agent;

import com.study.AttachTransformer;
import com.study.AgentTransformer;

import java.lang.instrument.Instrumentation;

/**
 * @Author: yuqi
 * @Date: 2019-10-14 16:54
 */
public class AgentLauncher {

    public static void premain(final String featureString, final Instrumentation inst){

        System.out.println("agent featureString:" + featureString);

        inst.addTransformer(new AgentTransformer(),true);

        System.out.println("agent after");
    }

    public static void agentmain(final String featureString, final Instrumentation inst) {

        System.out.println("attach featureString:" + featureString);

        try {
            inst.addTransformer(new AttachTransformer(),true);
            inst.retransformClasses(new Class<?>[]{Class.forName("com.study.Account")});
        } catch (Exception e) {
            System.out.println("attach after error"+e);
        }

        System.out.println("agentmain after");
    }

}
