package com.ecw.classes

import spock.lang.Specification
import spock.lang.Unroll

class StringCalculatorSpec extends Specification {
	@Unroll("Test case for String calculator caseNo: #caseNo, input:#numbers")
	def "Test case for String Calculator"() {
		given:
			"Any no. of inputs separated by delimeters"
			numbers
		when:
			def result = new StringCalculator().add(numbers)
		
		then:
			result == expectedResult
		where:
			caseNo | numbers            || expectedResult
			1      | null               || 0
			2      | ""                 || 0
			3      | "1"                || 1
			4      | "1,2"              || 3
			5      | "1,2,3"            || 6
			6      | "1\n2,3"           || 6
			7      | "1,\n"             || 1
			8      | "//|\n1|2,3"       || 6
	}
}
