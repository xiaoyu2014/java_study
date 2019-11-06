package com.study.core;


import com.sun.tools.attach.VirtualMachine;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: yuqi
 * @Date: 2019-10-14 16:55
 */
public class CoreLauncher {

    public CoreLauncher(final String targeJvmPid,
                        final String agentJarPath,
                        final String token) throws Exception{

        System.out.println("agent");
        //加载agent
        attachAgent(targeJvmPid, agentJarPath, token);
    }

    //加载agent
    public void attachAgent(final String targetJvmPid,
                            final String agentJarPath,
                            final String cfg) throws Exception{

        VirtualMachine virtualMachine = null;
        try{
            virtualMachine = VirtualMachine.attach(targetJvmPid);
            if(virtualMachine != null){
                virtualMachine.loadAgent(agentJarPath, cfg);
            }
        }finally {
            if(null != virtualMachine){
                virtualMachine.detach();
            }
        }

    }

    public static void main(String[] args) {
        try {

            // check args
            if (args.length != 3
                    || StringUtils.isBlank(args[0])
                    || StringUtils.isBlank(args[1])
                    || StringUtils.isBlank(args[2])) {
                throw new IllegalArgumentException("illegal args");
            }

            new CoreLauncher(args[0], args[1], args[2]);
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.err.println("core load jvm failed : " + t.getMessage());
            System.exit(-1);
        }
    }

}
