package com.study.agent;

import com.study.AccountTransformer;

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

        inst.addTransformer(new AccountTransformer());

        System.out.println("premain after");
    }

    public static void agentmain(final String featureString, final Instrumentation inst) {

        System.out.println("agentmain featureString:" + featureString);

        inst.addTransformer(new AccountTransformer());

        System.out.println("agentmain after");
    }

}
