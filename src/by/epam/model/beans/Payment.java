package by.epam.model.beans;

public class Payment {
	private String amountPaid;
	private String formOfPaymentTypeCode;
	private String currencyCode;
	
	public Payment() {
		
	}

	public Payment(String amountPaid, String formOfPaymentTypeCode, String currencyCode) {
		this.amountPaid = amountPaid;
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
		this.currencyCode = currencyCode;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public String getFormOfPaymentTypeCode() {
		return formOfPaymentTypeCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public void setFormOfPaymentTypeCode(String formOfPaymentTypeCode) {
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
