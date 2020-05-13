package SpringAnnotations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	private List<FortuneService> fsList;
	private FortuneService fortuneService;
	public TennisCoach(){
		System.out.println("Inside default constructor");
	}
	@Autowired
	public TennisCoach(List<FortuneService> fortuneServiceList) {
		fsList=fortuneServiceList;
	}
	/*@Autowired
	public void setFortuneService(FortuneService fs) {
		System.out.println("Inside setter method");
		fortuneService=fs;
	}*/
	/*@Autowired
	public TennisCoach(FortuneService fs) {
		fortuneService=fs;
	}*/
	public void setFortuneService(List<FortuneService> fs) {
		System.out.println("Inside setter method");
		fsList=fs;
	}
	@Override
	public String getDailyWorkout() {
		return "Practice everyday";
	}

	@Override
	public List<FortuneService> getDailyFortune() {
		return fsList;
	}

}
