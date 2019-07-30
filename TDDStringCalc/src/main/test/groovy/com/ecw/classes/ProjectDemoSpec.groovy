package com.ecw.classes

import spock.lang.Specification

class ProjectDemoSpec extends Specification {

	def "Spock Test to check project setup"() {
		given:
			"No input paramters"
		when:
			def result = new ProjectDemo().isProjectSetup()
			println 'Result: '  +result
		then:
			result
	}
	
}
