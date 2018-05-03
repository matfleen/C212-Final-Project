
public class FeeStatus {

	double amtDue;

	// FeeStatus Constructor
	public FeeStatus(double amtDue) {
		this.amtDue = amtDue;

	}

	// subtracts the amount paid from the amount owed
	// @param: the amount being paid towards the fine
	public void payFee(double amt) {
		amtDue -= amt;
	}

}
