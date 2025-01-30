package edu.sistrans.epsandes;

import org.springframework.boot.SpringApplication;

public class TestEpsandesApplication {
  public static void main(String[] args) {
    SpringApplication.from(Application::main).with(TestcontainersConfiguration.class).run(args);
  }
}
