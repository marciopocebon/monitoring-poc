package com.example.core.ssh.client.impl;

import com.example.core.ssh.client.SSHClient;
import com.example.core.ssh.session.SSHSession;
import com.example.core.ssh.session.impl.JSchSSHSession;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: ddubson
 */
public class JSchSSHClient implements SSHClient {
    JSch jSch;
    SSHSession session;

    @Autowired
    public JSchSSHClient(JSch jSch) {
        this.jSch = jSch;
    }

    @Override
    public SSHSession getSSHSession() {
        return session;
    }

    @Override
    public SSHSession connect(String user, String host, int port) {
        SSHSession session = null;
        try {
            session = new JSchSSHSession(this.jSch.getSession(user, host, port));
        } catch (JSchException e) {
            System.out.println(e.getMessage());
        }

        return session;
    }
}
