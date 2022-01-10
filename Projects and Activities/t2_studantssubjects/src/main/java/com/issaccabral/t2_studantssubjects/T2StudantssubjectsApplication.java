package com.issaccabral.t2_studantssubjects;

import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.entity.StudentHasSubject;
import com.issaccabral.t2_studantssubjects.entity.Subject;
import com.issaccabral.t2_studantssubjects.repository.StudentHasSubjectRepository;
import com.issaccabral.t2_studantssubjects.repository.StudentRepository;
import com.issaccabral.t2_studantssubjects.repository.SubjectRepository;
import com.issaccabral.t2_studantssubjects.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@SpringBootApplication

public class T2StudantssubjectsApplication implements CommandLineRunner {
	@Autowired
	View view;
	public static void main(String[] args){
//		SpringApplication.run(T2StudantssubjectsApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(T2StudantssubjectsApplication.class);
		builder.headless(false).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		view.run();
	}
}
