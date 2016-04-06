package com.example.services.explorer.impl;

import com.example.core.ssh.client.SSHClient;
import com.example.services.explorer.Explorer;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Author: ddubson
 */
public class LinuxExplorer implements Explorer {
    private static String INIT_D_COMMAND = "ls /etc/init.d/";
    SSHClient client;
    JSch jSch;

    @Autowired
    public LinuxExplorer(JSch jSch, SSHClient client) {
        this.client = client;
        this.jSch = jSch;
    }

    @Override
    public List<String> listDaemons() {
        Session session = null;
        ChannelExec channel = null;
        String[] daemons = null;
        try {
            session = jSch.getSession("vagrant", "192.168.33.10", 22);
            session.setPassword("vagrant");
            Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(INIT_D_COMMAND);

            channel.setInputStream(null);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            channel.setOutputStream(stream);
            channel.connect(10000);

            daemons = new String(stream.toByteArray()).split("\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                channel.disconnect();
            }

            if (session != null) {
                session.disconnect();
            }
        }

        return Arrays.asList(daemons);
    }
}
