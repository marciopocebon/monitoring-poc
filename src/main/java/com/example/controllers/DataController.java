package com.example.controllers;

import com.example.services.explorer.Explorer;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Author: ddubson
 */
@RestController
public class DataController {
    @Autowired
    Explorer explorer;

    @RequestMapping("/host/init.d")
    public List<String> getInitD() throws Exception {
        return explorer.listDaemons();
    }

    @RequestMapping("/host/cpuinfo")
    public Map<String, String> getCPUInfo() throws Exception {
        JSch jSch = new JSch();
        Session session = jSch.getSession("vagrant", "192.168.33.10", 22);
        session.setPassword("vagrant");
        Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        String command = "cat /proc/cpuinfo";
        session.connect();
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(command);

        channel.setInputStream(null);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        channel.setOutputStream(stream);
        channel.connect(10000);

        channel.disconnect();
        session.disconnect();
        String[] arr = new String(stream.toByteArray()).split("\n");
        Map<String, String> kvs = new HashMap<>();
        for (String kv : arr) {
            String[] keyValue = kv.split("\\:");
            String value = "";
            if (keyValue.length > 1) {
                value = keyValue[1].trim();
            }

            kvs.put(keyValue[0].trim(), value);
        }

        return kvs;
    }
}
