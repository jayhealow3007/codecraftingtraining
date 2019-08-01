package paymentservice

import spock.lang.Specification

class PaymentServiceShould extends Specification{

	private User user;
	private PaymentDetails paymentDetails;
	private PaymentGateway gateway;
	private UserValidator validator;
	
	def setup() {
		user = new User();
		paymentDetails = new PaymentDetails();
		gateway = Mock();
		validator = Stub();
	}
	
	def 'throw an exception for invalid user'() {
		given:
			validator.validate(user) >> false
			PaymentService paymentService = new PaymentService(validator, gateway);
		when:
			paymentService.processPayment(user, paymentDetails)
		then:
			thrown(InvalidUserException) 
			0 * gateway.pay(paymentDetails)
	}
	
	def 'process a payment for valid user'() {
		given:
			validator.validate(user) >> true
			PaymentService paymentService = new PaymentService(validator, gateway);
		when:
			paymentService.processPayment(user, paymentDetails)
		then: 
			1 * gateway.pay(paymentDetails)
	}
}
