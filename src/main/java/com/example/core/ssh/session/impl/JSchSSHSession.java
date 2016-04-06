package com.example.core.ssh.session.impl;

import com.example.core.ssh.session.SSHSession;
import com.jcraft.jsch.Session;

/**
 * Author: ddubson
 */
public class JSchSSHSession implements SSHSession {
    Session session;

    public JSchSSHSession(Session session) {
        this.session = session;
    }

}
