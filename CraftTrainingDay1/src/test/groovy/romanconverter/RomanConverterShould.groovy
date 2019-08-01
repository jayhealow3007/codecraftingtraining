package romanconverter

import spock.lang.Specification

class RomanConverterShould extends Specification {

	RomanConverter converter = new RomanConverter();
	
	def "convert arabic number into roman number"() {
		def result = converter.convert(input)
		expect:
			result == expectedResult
		where:
			input || expectedResult
			1     || 'I'
			2	  || 'II'
			3	  || 'III'
			5	  || 'V'
			6	  || 'VI'
			10    || 'X'
			12    || 'XII'
			15    || 'XV'
			18    || 'XVIII'
			20	  || 'XX'
			30	  || 'XXX'
			35	  || 'XXXV'
			38    || 'XXXVIII'
			50    || 'L'
			53    || 'LIII'
			58	  || 'LVIII'
			63	  || 'LXIII'
			88	  || 'LXXXVIII'
			100	  || 'C'
			108	  || 'CVIII'
			317	  || 'CCCXVII'
			338	  || 'CCCXXXVIII'
			388	  || 'CCCLXXXVIII'
			500	  || 'D'
			528	  || 'DXXVIII'
			600	  || 'DC'
			753	  || 'DCCLIII'
			888	  || 'DCCCLXXXVIII'
			1000  || 'M'
 			3888  || 'MMMDCCCLXXXVIII'
			 4	  || 'IV'
	}
}
