package com.ouyang.think_in_java4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ShowMultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("id:" + threadInfo.getThreadId()
                    + " name:" + threadInfo.getThreadName());
        }
        //id:6 name:Monitor Ctrl-Break
        //id:5 name:Attach Listener
        //id:4 name:Signal Dispatcher
        //id:3 name:Finalizer
        //id:2 name:Reference Handler
        //id:1 name:main
    }
}
