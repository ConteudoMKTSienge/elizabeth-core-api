package com.elizabeth.core.infrastructure.amqp;

import com.elizabeth.core.domain.EventProducer;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizabeth.core.domain.Lead;

@Service
public class EventProducerImpl implements EventProducer {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue queue;
	
	public void send(Lead lead) {
		template.convertAndSend(queue.getName(), lead);
	}

}
