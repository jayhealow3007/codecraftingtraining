package TDD

import spock.lang.Specification

class TDDDemoSepc extends Specification{ 

	def 'test case to check true false'(){
		expect :
		1 == 1
	}
}

