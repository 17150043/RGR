package Test;

import junit.framework.TestCase;

import Program.SalaryCalcMain;

public class GallyamovTest1 extends TestCase {

	public void testSalaryCalcMain(){
		SalaryCalcMain calc = new SalaryCalcMain();
		TestCase.assertEquals(24806.00, calc.calcSalary(25920.0, 2592.0, 3706.0));
	}
	
}
