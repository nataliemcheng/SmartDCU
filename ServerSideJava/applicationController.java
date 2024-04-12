package groupC.dcuSmartDashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class applicationController {
	
	//Allows server to interface with browser
	@GetMapping("/{page}")
	public static String openPage(@PathVariable String page) {
		return page;
	}
}
