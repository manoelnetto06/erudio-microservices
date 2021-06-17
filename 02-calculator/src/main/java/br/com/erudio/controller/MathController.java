package br.com.erudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.convertes.NumberConverter;

@RestController
public class MathController 
{		
	//private SimpleMath math = new SimpleMath();

	@Autowired 
	private SimpleMath math;
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double findById(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
		{
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}

		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}	

	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
		{
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}			

		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/mut/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mut(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
		{
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}

		return math.mut(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
		{
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}

		if(NumberConverter.convertToDouble(numberTwo) == 0) 
		{
			throw new UnsuportedMathOperationException("Division zero.");
		}

		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
		{
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}

		return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/square/{numberOne}", method=RequestMethod.GET)
	public Double square(@PathVariable("numberOne") String numberOne) throws Exception {
		if(!NumberConverter.isNumeric(numberOne)) 
		{
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}						

		return math.square(NumberConverter.convertToDouble(numberOne));
	}
}