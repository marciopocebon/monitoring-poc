package com.example.core.ssh.client;

import com.example.core.ssh.session.SSHSession;

/**
 * Author: ddubson
 */
public interface SSHClient {
    SSHSession getSSHSession();

    SSHSession connect(String user, String host, int port);
}
