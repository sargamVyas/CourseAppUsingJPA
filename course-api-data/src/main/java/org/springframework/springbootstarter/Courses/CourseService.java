package org.springframework.springbootstarter.Courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	/*
	 * private List<Topic> topics= new ArrayList<>(Arrays.asList(new
	 * Topic("Spring","Spring FrameWork","Sprin FrameWork Description"), new
	 * Topic("Core","Core Java","Core Java Description"), new
	 * Topic("SpringBoot","Spring Boot FrameWork","Spring Boot Description")));
	 */
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		
		return courses;
		
	}
	
	public Optional<Course> getCourse(String id)
	{
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		/*
		 * for(int i=0;i<topics.size();i++) { Topic t=topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); return; } }
		 */
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
//		topics.removeIf(t-> t.getId().equals(id));
		
		courseRepository.deleteById(id);
	}

	
}
