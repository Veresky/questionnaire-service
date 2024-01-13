package com.xiaohudu.questionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync // 异步
@EnableScheduling // 定时任务
@SpringBootApplication
public class QuestionnaireServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireServiceApplication.class, args);
	}

}
