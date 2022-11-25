package model;

//interface inheritance
public interface SEC extends DBOperations {

	/*all methods are implicitly public abstract*/
	void listMutualFundOffer();
	void submitRegistrationForm();
	void submitGeneralInformationSheet();
}
