package com.ouyang.think_in_java4;

public class Instance {

    public static int instanceCount = 0;

    private Instance() {

    }

    public static Instance makeInstance() {
        instanceCount++;
        return new Instance();
    }

    @Override
    protected void finalize() throws Throwable {
        instanceCount--;
        super.finalize();
    }
}
