package com.example;

import com.example.core.ssh.client.SSHClient;
import com.example.core.ssh.client.impl.JSchSSHClient;
import com.jcraft.jsch.JSch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public SSHClient sshClient() {
        return new JSchSSHClient(jSch());
    }

    @Bean
    public JSch jSch() {
        return new JSch();
    }
}
