import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SessionScoped
@ManagedBean

public class indexBean {
	
	private String fName;
    private String fNameFail;
    private String lName;
    private String lNameFail;
    private String address;
    private String addressFail;
    private String city;
    private String cityFail;
    private String state;
    private String stateFail;
    private String zip;
    private String zipFail;
    private String cNumber;
    private String cNumberFail;
    private String cDate;
    private String dateFail;
    private String sCode;
    private String sCodeFail;
    private String cExists;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
    
    /**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the fNameFail
	 */
	public String getfNameFail() {
		return fNameFail;
	}

	/**
	 * @param fNameFail the fNameFail to set
	 */
	public void setfNameFail(String fNameFail) {
		this.fNameFail = fNameFail;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the lNameFail
	 */
	public String getlNameFail() {
		return lNameFail;
	}

	/**
	 * @param lNameFail the lNameFail to set
	 */
	public void setlNameFail(String lNameFail) {
		this.lNameFail = lNameFail;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the addressFail
	 */
	public String getAddressFail() {
		return addressFail;
	}

	/**
	 * @param addressFail the addressFail to set
	 */
	public void setAddressFail(String addressFail) {
		this.addressFail = addressFail;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the cityFail
	 */
	public String getCityFail() {
		return cityFail;
	}

	/**
	 * @param cityFail the cityFail to set
	 */
	public void setCityFail(String cityFail) {
		this.cityFail = cityFail;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the stateFail
	 */
	public String getStateFail() {
		return stateFail;
	}

	/**
	 * @param stateFail the stateFail to set
	 */
	public void setStateFail(String stateFail) {
		this.stateFail = stateFail;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the zipFail
	 */
	public String getZipFail() {
		return zipFail;
	}

	/**
	 * @param zipFail the zipFail to set
	 */
	public void setZipFail(String zipFail) {
		this.zipFail = zipFail;
	}

	/**
	 * @return the cNumber
	 */
	public String getcNumber() {
		return cNumber;
	}

	/**
	 * @param cNumber the cNumber to set
	 */
	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	/**
	 * @return the cNumberFail
	 */
	public String getcNumberFail() {
		return cNumberFail;
	}

	/**
	 * @param cNumberFail the cNumberFail to set
	 */
	public void setcNumberFail(String cNumberFail) {
		this.cNumberFail = cNumberFail;
	}

	/**
	 * @return the date
	 */
	public String getcDate() {
		return cDate;
	}

	/**
	 * @param date the date to set
	 */
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	/**
	 * @return the dateFail
	 */
	public String getDateFail() {
		return dateFail;
	}

	/**
	 * @param dateFail the dateFail to set
	 */
	public void setDateFail(String dateFail) {
		this.dateFail = dateFail;
	}

	/**
	 * @return the sCode
	 */
	public String getsCode() {
		return sCode;
	}

	/**
	 * @param sCode the sCode to set
	 */
	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	/**
	 * @return the sCodeFail
	 */
	public String getsCodeFail() {
		return sCodeFail;
	}

	/**
	 * @param sCodeFail the sCodeFail to set
	 */
	public void setsCodeFail(String sCodeFail) {
		this.sCodeFail = sCodeFail;
	}

	/**
	 * @return the cExists
	 */
	public String getcExists() {
		return cExists;
	}

	/**
	 * @param cExists the cExists to set
	 */
	public void setcExists(String cExists) {
		this.cExists = cExists;
	}

	/**
     * No-Argument Constructor
     */
    public indexBean() {}
    
    /**
     * doValid()
     * 
     * Method runs on submit
     */
    public void checkIsValid() {
    		
    	// if CheckAllFields returns true check the file to see if there are any matches for user input
    	if(checkAllFields()){
    	//file location
    	String file = "c:/Users/Gary/workspace/CST235_Java_Servlets/MemberInfo.txt";
    	//How the fields in the record are split
        String split = ", ";
        //Gets each line read from file
        String line = null;    
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	//If line is not null it will read line
            while ((line = br.readLine()) != null) {

                //uses ", " as a separator of the fields and places them in an array in lower case and compares them to all fields from html doc in lowercase.
            	//This insures that there are no issues with casing.
                String[] mInfo = line.split(split);
                //Checks each individual line and matches it to the user input
                if( mInfo[0].toLowerCase().equals( fName.toLowerCase()) 
                	&& mInfo[1].toLowerCase().equals(lName.toLowerCase())
                	&& mInfo[2].toLowerCase().equals(address.toLowerCase())
                	&& mInfo[3].toLowerCase().equals(city.toLowerCase())
                	&& mInfo[4].toLowerCase().equals(state.toLowerCase())
                	&& mInfo[5].toLowerCase().equals(zip.toLowerCase())
                	&& mInfo[6].toLowerCase().equals(cNumber.toLowerCase())
                	&& mInfo[7].toLowerCase().equals(cDate.toLowerCase())
                	&& mInfo[8].toLowerCase().equals(sCode.toLowerCase())
                	){ 
                	//if true returns the following
                	setcExists("The credit card entered is in our file"); return;}
                	//if false returns
                else{
                		setcExists("The credit card entered is not in our file");	
                	}
                	
        }} catch (IOException e) {
            e.printStackTrace();
        }

    	}
    }

    // method to check all fields
	private boolean checkAllFields(){
		//Set both string and number regex patterns
	    String sPattern = "[^a-zA-Z0-9-]";
	    String nPattern = "[^0-9]";
	    
	    // Check fName
	    if (Pattern.compile(sPattern).matcher(fName).find() || fName.equals("")){
	        fName = "Please enter a First Name with only alphabetical or hyphen characters";
	        return false;
	    }     
	    // Check lName
	    if (Pattern.compile(sPattern).matcher(lName).find() || lName.equals("") ) {
	    	lNameFail = "Please enter a Last Name with only alphabetical or hyphen characters";
	        return false;
	    }else lNameFail = "";   
	    // Check address
	    if (address.equals("")) {
	    	addressFail = "Please enter a street address";
	        return false;
	    }else addressFail = "";      
	    // Check city
	    if (city.equals("") || Pattern.compile(sPattern).matcher(city).find()) {
	    	cityFail = "Please enter a City";
	        return false;
	    }else cityFail = "";    
	    // Check state
	    if (state.equals("") || state.length() > 2 || Pattern.compile(sPattern).matcher(state).find() ) {
	    	stateFail = "Please enter a State using only an abbreviation of 2 characters";
	        return false;
	    }  else stateFail = "";   
	    // Check zip
	    if (zip.equals("") || zip.length() != 5 || Pattern.compile(nPattern).matcher(zip).find()) {
	    	zipFail = "Please enter a 5 digit Zip code containing only numeric characters";
	        return  false;
	    }else zipFail = "";      
	    // Check card
	    if (cNumber.equals("") || cNumber.length() != 16 || Pattern.compile(nPattern).matcher(cNumber).find() ) {
	    	cNumberFail = "Please enter a card number that contains 16 numeric characters";
	        return  false;
	  }else cNumberFail = "";    
	    // Check Exp Date
	    	try{
	    		sdf.parse(cDate);
	    		dateFail = ""; 
	    	}catch(ParseException e){
	    		dateFail = "Please enter a valid Expiration Date in the following format mm/dd/yyyy";
		        return false;
	    	}	
	    	if (cDate.length() != 10){
	    		dateFail = "Please enter a valid Expiration Date in the following format mm/dd/yyyy";
		        return false;
	    	}
	    //Check sCode
	    if (sCode.length() != 3 || Pattern.compile(nPattern).matcher(sCode).find()){
	    	sCodeFail = "Please enter a security code containing 3 numeric digits";
	    	return false;
	    }else sCodeFail = ""; 
		
		return true;
	}

}
