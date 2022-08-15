package com.xp.container;

import jdk.internal.platform.Metrics;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MainAgent {
    public static void premain(String agentArgument) {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        Metrics metrics = Metrics.systemMetrics();
        if (metrics != null) {
            ContainerInfo containerInfo = new ContainerInfo(metrics);
            try {
                mbs.registerMBean(containerInfo,getObjectName());
            } catch (InstanceAlreadyExistsException|MBeanRegistrationException|NotCompliantMBeanException e) {
                e.printStackTrace();
            }
        }

    }
    public static ObjectName getObjectName() {
        try {
            return new ObjectName("java.lang:type=Container");
        } catch (MalformedObjectNameException mne) {
            throw new Error("Can't happen", mne);
        }
    }

    public static void main(String[] args) {
        premain(null);
    }
}
