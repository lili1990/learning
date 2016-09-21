package app.jobs;

import jobs.annotation.OnApplicationStart;
import jobs.job.Job;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.ui.velocity.VelocityEngineFactory;
/*
 * 项目启动后初始化
 */
@OnApplicationStart
 public class StartUp extends Job {

	public void doJob() throws Exception {

		System.out.println("qqqqqqqqqqqqq");
	}



}
