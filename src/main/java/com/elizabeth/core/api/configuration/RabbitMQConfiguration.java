package com.elizabeth.core.api.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.elizabeth.core.infrastructure.amqp.TaskReceiver;

@Configuration
public class RabbitMQConfiguration {

	@Bean
	public Queue hello() {
		return new Queue("events");
	}

	private static class ReceiverConfiguration {

		@Bean
		public TaskReceiver receiver() {
			return new TaskReceiver();
		}

	}

}
