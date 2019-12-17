
public class ValidateLoginAdmin implements Validate {

	@Override
	public boolean validate(String iD, String password) {
		if (iD.equals("Admin") && password.equals("20175020")) {
			return true;
		} else
			return false;
	}
}
