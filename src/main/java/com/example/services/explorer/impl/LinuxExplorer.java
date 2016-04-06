package com.example.services.explorer.impl;

import com.example.core.ssh.client.SSHClient;
import com.example.core.ssh.session.SSHSession;
import com.example.services.explorer.Explorer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: ddubson
 */
public class LinuxExplorer implements Explorer {
    SSHClient client;

    @Autowired
    public LinuxExplorer(SSHClient client) {
        this.client = client;
    }

    @Override
    public String listDaemons() {
        SSHSession session = client.connect("vagrant", "192.168.33.10", 22);
        return null;

    }
}
