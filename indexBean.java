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
    private String bFName;
    private String lName;
    private String bLName;
    private String address;
    private String baddress;
    private String city;
    private String bcity;
    private String state;
    private String bstate;
    private String zip;
    private String bzip;
    private String cNumber;
    private String bCNumber;
    private String cDate;
    private String bdate;
    private String sCode;
    private String bsCode;
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
	 * @return the bFName
	 */
	public String getbFName() {
		return bFName;
	}

	/**
	 * @param bFName the bFName to set
	 */
	public void setbFName(String bFName) {
		this.bFName = bFName;
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
	 * @return the bLName
	 */
	public String getbLName() {
		return bLName;
	}

	/**
	 * @param bLName the bLName to set
	 */
	public void setbLName(String bLName) {
		this.bLName = bLName;
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
	 * @return the baddress
	 */
	public String getBaddress() {
		return baddress;
	}

	/**
	 * @param baddress the baddress to set
	 */
	public void setBaddress(String baddress) {
		this.baddress = baddress;
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
	 * @return the bcity
	 */
	public String getBcity() {
		return bcity;
	}

	/**
	 * @param bcity the bcity to set
	 */
	public void setBcity(String bcity) {
		this.bcity = bcity;
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
	 * @return the bstate
	 */
	public String getBstate() {
		return bstate;
	}

	/**
	 * @param bstate the bstate to set
	 */
	public void setBstate(String bstate) {
		this.bstate = bstate;
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
	 * @return the bzip
	 */
	public String getbzip() {
		return bzip;
	}

	/**
	 * @param bzip the bzip to set
	 */
	public void setbzip(String bzip) {
		this.bzip = bzip;
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
	 * @return the bCNumber
	 */
	public String getbCNumber() {
		return bCNumber;
	}

	/**
	 * @param bCNumber the bCNumber to set
	 */
	public void setbCNumber(String bCNumber) {
		this.bCNumber = bCNumber;
	}

	/**
	 * @return the cDate
	 */
	public String getcDate() {
		return cDate;
	}

	/**
	 * @param cDate the cDate to set
	 */
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	/**
	 * @return the bdate
	 */
	public String getBdate() {
		return bdate;
	}

	/**
	 * @param bdate the bdate to set
	 */
	public void setBdate(String bdate) {
		this.bdate = bdate;
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
	 * @return the bsCode
	 */
	public String getBsCode() {
		return bsCode;
	}

	/**
	 * @param bsCode the bsCode to set
	 */
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
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
	        bFName = "Please enter a First Name with only alphabetical or hyphen characters";
	        return false;
	    }else bFName = "";  
	    // Check lName
	    if (Pattern.compile(sPattern).matcher(lName).find() || lName.equals("") ) {
	    	bLName = "Please enter a Last Name with only alphabetical or hyphen characters";
	        return false;
	    }else bLName = "";   
	    // Check address
	    if (address.equals("")) {
	    	baddress = "Please enter a street address";
	        return false;
	    }else baddress = "";      
	    // Check city
	    if (city.equals("") || Pattern.compile(sPattern).matcher(city).find()) {
	    	bcity = "Please enter a City";
	        return false;
	    }else bcity = "";    
	    // Check state
	    if (state.equals("") || state.length() > 2 || Pattern.compile(sPattern).matcher(state).find() ) {
	    	bstate = "Please enter a State using only an abbreviation of 2 characters";
	        return false;
	    }  else bstate = "";   
	    // Check zip
	    if (zip.equals("") || zip.length() != 5 || Pattern.compile(nPattern).matcher(zip).find()) {
	    	bzip = "Please enter a 5 digit Zip code containing only numeric characters";
	        return  false;
	    }else bzip = "";      
	    // Check card
	    if (cNumber.equals("") || cNumber.length() != 16 || Pattern.compile(nPattern).matcher(cNumber).find() ) {
	    	bCNumber = "Please enter a card number that contains 16 numeric characters";
	        return  false;
	  }else bCNumber = "";    
	    // Check Exp Date
	    	try{
	    		sdf.parse(cDate);
	    		bdate = ""; 
	    	}catch(ParseException e){
	    		bdate = "Please enter a valid Expiration Date in the following format mm/dd/yyyy";
		        return false;
	    	}	
	    	if (cDate.length() != 10){
	    		bdate = "Please enter a valid Expiration Date in the following format mm/dd/yyyy";
		        return false;
	    	}
	    //Check sCode
	    if (sCode.length() != 3 || Pattern.compile(nPattern).matcher(sCode).find()){
	    	bsCode = "Please enter a security code containing 3 numeric digits";
	    	return false;
	    }else bsCode = ""; 
		
		return true;
	}

}
