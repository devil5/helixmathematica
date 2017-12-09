package com.titanhelix.mathematica.data;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titanhelix.mathematica.data.dao.Gcd;
import com.titanhelix.mathematica.data.dao.Numbers;

@Service
public class IntegerQueue {

	private ConcurrentLinkedDeque<Integer> integerDequeu;

	@Autowired
	private NumbersRepository numbersRepository;

	@Autowired
	private GcdRepository gcdRepository;

	/*
	 * Numbers Repository
	 */
	public void save(Integer number) {
		getIntegerDequeu().add(number);
		numbersRepository.save(new Numbers(number));
	}

	public List<Integer> getAllNumbers() {
		return StreamSupport.stream(numbersRepository.findAll().spliterator(), false).map(Numbers::getNumber).collect(Collectors.toList());
	}

	/*
	 * GCD Repository
	 */
	public int getGcd() {
		int gcd = BigInteger.valueOf(getIntegerDequeu().poll()).gcd(BigInteger.valueOf(getIntegerDequeu().poll())).intValue();
		gcdRepository.save(new Gcd(gcd));
		return gcd;
	}

	public Integer getGcdSum() {
		return StreamSupport.stream(gcdRepository.findAll().spliterator(), false).mapToInt(Gcd::getGcd).sum();
	}

	public List<Integer> getGcdList() {
		return StreamSupport.stream(gcdRepository.findAll().spliterator(), false).map(Gcd::getGcd).collect(Collectors.toList());
	}

	/*
	 * Lazy Load the Dequeue
	 */
	private ConcurrentLinkedDeque<Integer> getIntegerDequeu() {
		if (integerDequeu == null) {
			integerDequeu = new ConcurrentLinkedDeque<Integer>();
		}

		return integerDequeu;
	}

}
