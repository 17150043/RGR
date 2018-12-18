package Test;

import junit.framework.TestCase;

import Program.SalaryCalcMain;

public class GallyamovTest2 extends TestCase {

	public void testSalaryCalcMain(){
		SalaryCalcMain calc = new SalaryCalcMain();
		TestCase.assertEquals(21000.0, calc.calcPribil(100, 10, 21));
	}
	
}
