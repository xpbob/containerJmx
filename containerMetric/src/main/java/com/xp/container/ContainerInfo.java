package com.xp.container;


import jdk.internal.platform.Metrics;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class ContainerInfo implements ContainerInfoMXBean {
    final Metrics containerMetrics ;

    public ContainerInfo(Metrics containerMetrics) {
        this.containerMetrics = containerMetrics;
    }


    @Override
    public String getProvider() {
        return containerMetrics.getProvider();
    }

    @Override
    public long getCpuPeriod() {
        return containerMetrics.getCpuPeriod();
    }

    @Override
    public long getCpuQuota() {
        return containerMetrics.getCpuQuota();
    }

    @Override
    public long getCpuShares() {
        return 0;
    }

    @Override
    public long getEffectiveCpuCount() {
        return containerMetrics.getEffectiveCpuCount();
    }

    @Override
    public long getMemorySoftLimit() {
        return containerMetrics.getMemorySoftLimit();
    }

    @Override
    public long getMemoryLimit() {
        return containerMetrics.getMemoryLimit();
    }

    @Override
    public long getMemoryAndSwapLimit() {
        return containerMetrics.getMemoryAndSwapLimit();
    }

}