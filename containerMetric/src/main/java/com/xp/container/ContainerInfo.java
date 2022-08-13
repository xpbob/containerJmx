package com.xp.container;


import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class ContainerInfoImpl implements ContainerInfoMXBean {
    final Metrics containerMetrics ;

    public ContainerInfoImpl(Metrics containerMetrics) {
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

    @Override
    public ObjectName getObjectName() {
        try {
            return new ObjectName("java.lang:type=Container");
        } catch (MalformedObjectNameException mne) {
            throw new Error("Can't happen", mne);
        }
    }
}