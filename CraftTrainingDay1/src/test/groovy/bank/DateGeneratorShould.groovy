package bank

import spock.lang.Specification

class DateGeneratorShould extends Specification {

	def "return current system date"() {
		def result = new DateGenerator().getDate()
		expect:
			new Date().toString() == result
	}
	
}
