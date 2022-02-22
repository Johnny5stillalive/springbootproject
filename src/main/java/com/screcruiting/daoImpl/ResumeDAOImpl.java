
package com.screcruiting.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ResumeDAO;
import com.screcruiting.demo.entity.Resume;
import com.screcruiting.demo.repository.ResumeRepository;

@Service
@ComponentScan(basePackages = "com.screcruiting")
public class ResumeDAOImpl implements ResumeDAO {

	@Autowired
	private ResumeRepository resumeRepository;

	@Override
	public void saveOrUpdateResume(Resume resume) {
		System.out.println("Resume Saved or Updated.");
		resumeRepository.save(resume);

	}

	@Override
	public Iterable<Resume> listAllResume() {
		return resumeRepository.findAll();
	}

	@Override
	public void deleteResume(int id) {
		resumeRepository.deleteById(id);

	}

	@Override
	public Resume getResumeByID(int id) {
		try {
			return resumeRepository.findById(id).get();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}


}
