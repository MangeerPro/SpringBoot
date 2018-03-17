package com.cocky.boot;

import com.cocky.boot.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.PrintStream;

@RestController
@SpringBootApplication  /* 组合注解，包含了@Configuration、@EnableAutoConfiguration、@ComponentScan
						 * @EnableAutoConfiguration让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置
						 */
@ImportResource()
public class BootApplication {

	@Autowired
	private AuthorSettings authorSettings;

	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;

	@RequestMapping("/author")
	public String getAuthor() {
		return authorSettings.toString();
	}
	@RequestMapping("/")
	public String index() {
		return "Book name:" + bookName + "| Book Author:" + bookAuthor;
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BootApplication.class);
		//springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}
}
