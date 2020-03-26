package com.ninos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.Numeric.CheckNumeric;
import com.ninos.exception.UnSupprtedMathException;
import com.ninos.operations.SimpleMath;

@RestController
public class CalculatorController {
	
	       SimpleMath math = new SimpleMath();
	
	
	@GetMapping("/sum/{one}/{tow}")
	public Double sum(@PathVariable("one") String numberone,@PathVariable("tow") String numbertow) throws Exception {
		if( !CheckNumeric.isNumeric(numberone) ||  !CheckNumeric.isNumeric(numbertow)  ) {
			throw new UnSupprtedMathException("Please set a mumeric value");
		}
		return math.sum(Double.parseDouble(numberone), Double.parseDouble(numbertow));
	}
	
	
	@GetMapping("/sub/{one}/{tow}")
	public Double sub(@PathVariable("one") String numberone,@PathVariable("tow") String numbertow) throws Exception {
		if( !CheckNumeric.isNumeric(numberone) ||  !CheckNumeric.isNumeric(numbertow)  ) {
			throw new UnSupprtedMathException("Please set a mumeric value");
		}
		return math.sub(Double.parseDouble(numberone), Double.parseDouble(numbertow));
	}
	
	
	
	@GetMapping("/mult/{one}/{tow}")
	public Double mult(@PathVariable("one") String numberone,@PathVariable("tow") String numbertow) throws Exception {
		if( !CheckNumeric.isNumeric(numberone) ||  !CheckNumeric.isNumeric(numbertow)  ) {
			throw new UnSupprtedMathException("Please set a mumeric value");
		}	
		return math.mul(Double.parseDouble(numberone), Double.parseDouble(numbertow));	
	}
	
	
	@GetMapping("/div/{one}/{tow}")
	public Double division(@PathVariable("one") String numberone,@PathVariable("tow") String numbertow) throws Exception {
		if( !CheckNumeric.isNumeric(numberone) ||  !CheckNumeric.isNumeric(numbertow)  ) {
			throw new UnSupprtedMathException("Please set a mumeric value");
		}	
		return math.div(Double.parseDouble(numberone), Double.parseDouble(numbertow));	
	}
	
	
	
	@GetMapping("/ave/{one}/{tow}")
	public Double Avetage(@PathVariable("one") String numberone,@PathVariable("tow") String numbertow) throws Exception {
		if( !CheckNumeric.isNumeric(numberone) ||  !CheckNumeric.isNumeric(numbertow)  ) {
			throw new UnSupprtedMathException("Please set a mumeric value");
		}	
		return math.ave(Double.parseDouble(numberone), Double.parseDouble(numbertow));	
	}
	
	
	
	@GetMapping("/sqrt/{number}")
	public Double SquareRoot(@PathVariable("number") String number) throws Exception {
		if( !CheckNumeric.isNumeric(number)  ) {
			throw new UnSupprtedMathException("Please set a mumeric value");
		}
		return math.sqrt(Double.parseDouble(number));
	}
	
	
	
	
	

}
