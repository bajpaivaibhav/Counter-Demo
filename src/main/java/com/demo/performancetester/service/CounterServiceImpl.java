package com.demo.performancetester.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.performancetester.exception.ResourceNotFoundException;
import com.demo.performancetester.models.Counter;
import com.demo.performancetester.repository.CounterRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j(topic = "RegLogging")
public class CounterServiceImpl implements CounterService {

	static int count = 1;

	@Autowired
	private CounterRepository counterRepository;

	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW, readOnly = false)
	@Override
	public Counter updateCounter(Counter counter) {
		counter.setId(1);
		counter.setCount(count++);
		Optional<Counter> counterDb = this.counterRepository.findById(counter.getId());

		if (counterDb.isPresent()) {
			log.info("count : " + counter.getCount());
			Counter counterUpdate = counterDb.get();
			counterUpdate.setCount(counter.getCount());
			counterRepository.save(counterUpdate);
			return counterUpdate;
		} else {
			log.error("exception occured while updating db");
			throw new ResourceNotFoundException("Record not found with id : " + counter.getId());
		}

	}

}
