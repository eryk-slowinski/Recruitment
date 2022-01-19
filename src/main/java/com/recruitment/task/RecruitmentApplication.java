package com.recruitment.task;


import com.recruitment.task.globals.Globals;
import com.recruitment.task.utils.CSVHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecruitmentApplication {

	public static void main(String[] args) {
		CSVHandler.loadFromDir("src/main/java/com/recruitment/task/data");
		Globals.loadUsers();
		SpringApplication.run(RecruitmentApplication.class, args);
	}
}
