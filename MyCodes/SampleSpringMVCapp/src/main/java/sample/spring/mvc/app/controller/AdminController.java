package sample.spring.mvc.app.controller;

import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controller/admin")
public class AdminController {

	private static final Logger LOGGER = Logger.getLogger(AdminController.class);

	public AdminController() {
		super();
		BasicConfigurator.configure();
		String text = "\n\n\n\n" + "-------------------------------------------------------------------\n"
				+ "Instance of \"AdminController\" class has been created successfully.\n"
				+ "-------------------------------------------------------------------" + "\n\n\n";
		LOGGER.info(text);
	}

	@RequestMapping("/welcome")
	@ResponseBody
	public String welcome() {
		return "<b>[" + new Date() + "]: Welcome from \"AdminController\". :)</b>";
	}

	@RequestMapping("/page")
	public String welcomePage() {
		return "adminpage";
	}
}
