package com.arch.edgeservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT
)
@Testcontainers
class EdgeServiceApplicationTests {

  private static final int REDIS_PORT = 6379;

  @Container
  static GenericContainer<?> redisContainer = new GenericContainer<>("redis:latest").withExposedPorts(REDIS_PORT);

  @DynamicPropertySource
  static void redisProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.redis.port", redisContainer::getFirstMappedPort);
    registry.add("spring.data.redis.host", redisContainer::getHost);
  }

  @Test
  void contextLoads() {
  }

}
