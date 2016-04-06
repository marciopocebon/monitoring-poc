package com.example;

import com.example.core.ssh.client.SSHClient;
import com.example.core.ssh.client.impl.JSchSSHClient;
import com.example.services.explorer.Explorer;
import com.example.services.explorer.impl.LinuxExplorer;
import com.jcraft.jsch.JSch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Configuration
public class Application extends WebMvcConfigurerAdapter {
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

    @Bean
    public Explorer explorer() {
        return new LinuxExplorer(jSch(), sshClient());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Forward root to webapp/index.html
        registry.addViewController("/").setViewName("/index.html");
    }
}
