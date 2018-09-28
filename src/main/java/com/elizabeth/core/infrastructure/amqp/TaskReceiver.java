package com.elizabeth.core.infrastructure.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

import com.elizabeth.core.domain.Lead;

@RabbitListener(queues = "events")
public class TaskReceiver {

	@RabbitHandler
	public void receive(Lead lead) throws InterruptedException {
		StopWatch watch = new StopWatch();
		watch.start();
		System.out.println(" [x] Received '" + lead + "'");
		doWork(lead);
		watch.stop();
		System.out.println(" [x] Done in " + watch.getTotalTimeSeconds() + "s");
	}
	
	private void doWork(Lead lead) throws InterruptedException {
		System.out.println(" [x] Distribute to respective princess '" + lead + "'");
		Thread.sleep(1000);
    }

}
