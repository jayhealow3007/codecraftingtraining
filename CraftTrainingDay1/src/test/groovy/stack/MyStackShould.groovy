package stack

import spock.lang.IgnoreRest
import spock.lang.Specification

class MyStackShould extends Specification{
	
	CustomStack stackObj = new CustomStack();
	
	def "throw an exception if popped when empty"() {
		given: ''
			def exception
			stackObj = new CustomStack();
		when:
			stackObj.pop();
		then:
			exception = thrown(EmptyStackException)
	}
	
	def "pop the last object pushed"() {
		expect:
			stackObj.push(1) 
			1 == stackObj.pop();
			stackObj.push("stringFirstObject")
			stackObj.push("stringSecondObject")
			"stringSecondObject" == stackObj.pop();
			"stringFirstObject" == stackObj.pop();
			stackObj.push(null)
			null == stackObj.pop();
	}
}
