package guru.springframework;

import guru.springframework.controllers.MyController;
import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean("fakeDataSource");
		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean("fakeJmsBroker");

		System.out.println("user: " + fakeDataSource.getUser());
		System.out.println("password: " + fakeDataSource.getPassword());
		System.out.println("url: " + fakeDataSource.getUrl());


		System.out.println("JmsUser: " + fakeJmsBroker.getUsername());
		System.out.println("JmsPassword: " + fakeJmsBroker.getPassword());
		System.out.println("JmsUrl: " + fakeJmsBroker.getUrl());

	}
}
