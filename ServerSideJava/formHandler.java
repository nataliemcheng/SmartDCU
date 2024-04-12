package groupC.dcuSmartDashboard;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class formHandler {
	
	//Skips using js
	@PostMapping("/occupancyForm")
	public static String roomOccupancyForm(@RequestParam String campus, @RequestParam String date, @RequestParam String timeIn, @RequestParam String timeOut, @RequestParam String roomNumber, @RequestParam String occupantName, @RequestParam String purpose, @RequestParam String contact) {
		System.out.println(campus);
		return "/index";
	}

	
}
