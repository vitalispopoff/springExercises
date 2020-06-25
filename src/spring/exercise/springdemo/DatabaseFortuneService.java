package spring.exercise.springdemo;

import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
	
	// create an array of strings
	private ArrayList<String> fortuneData = new ArrayList<>();
	
	//	create a random number generator	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
//		if (fortuneData.size()==0) setFortuneData();
				
		int 
			index = myRandom.nextInt(fortuneData.size());		
		String 
			theFortune = fortuneData.get(index);

		return theFortune;
	}
	
	@PostConstruct
	public void setFortuneData() {
		
		System.out.println(" ..."+this.getClass()+" : @postConstruct setFortuneData");
		String 
			source = "src\\externalFortunes.txt";
		
		try(Stream<String> stream = Files.lines(Paths.get(source))){
			stream.forEach(fortuneData::add);			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}