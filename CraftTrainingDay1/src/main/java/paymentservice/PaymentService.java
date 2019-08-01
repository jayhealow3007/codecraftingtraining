package paymentservice;

public class PaymentService {
	
	private final UserValidator validator;
	private final PaymentGateway gateway;
	
	public PaymentService(UserValidator validator, PaymentGateway gateway) {
		this.validator = validator;
		this.gateway = gateway;
	}

	public void processPayment(User user, PaymentDetails paymentDetails) throws InvalidUserException {
		if(!this.validator.validate(user)) {
			throw new InvalidUserException();
		}
		this.gateway.pay(paymentDetails);
	}
}
