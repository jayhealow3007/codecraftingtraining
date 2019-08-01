package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGenerator {

	public String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(new Date());
	}
}
