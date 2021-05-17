package Banco;

public class Cliente {

	private String CustomerID; // Não nulo
	private String Nome; // Não nulo
	private String Contact_name;
	private String Contact_title;
	private String Address;
	private String City;
	private String Region;
	private String Postal_code;
	private String Country;
	private String Phone;
	private String Fax;

	public Cliente() {
		CustomerID = "";
		Nome = "";
		Contact_name = "";
		Contact_title = "";
		Address = "";
		City = "";
		Region = "";
		Postal_code = "";
		Country = "";
		Phone = "";
		Fax = "";
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getContact_name() {
		return Contact_name;
	}

	public void setContact_name(String contact_name) {
		Contact_name = contact_name;
	}

	public String getContact_title() {
		return Contact_title;
	}

	public void setContact_title(String contact_title) {
		Contact_title = contact_title;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getPostal_code() {
		return Postal_code;
	}

	public void setPostal_code(String postal_code) {
		Postal_code = postal_code;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public void tratarNulo() {
		if (CustomerID == null) {
			CustomerID = "";
		}

		if (Nome == null) {
			Nome = "";
		}
		if (Contact_name == null) {
			Contact_name = "";
		}
		if (Contact_title == null) {
			Contact_title = "";
		}
		if (Address == null) {
			Address = "";
		}
		if (City == null) {
			City = "";
		}
		if (Region == null) {
			Region = "";
		}
		if (Postal_code == null) {
			Postal_code = "";
		}
		if (Country == null) {
			Country = "";
		}
		if (Phone == null) {
			Phone = "";
		}
		if (Fax == null) {
			Fax = "";
		}
	}
	
	public void tratarBranco() {
		if (CustomerID == "") {
			CustomerID = null;
		}

		if (Nome == "") {
			Nome = null;
		}
		if (Contact_name == "") {
			Contact_name = null;
		}
		if (Contact_title == "") {
			Contact_title = null;
		}
		if (Address == "") {
			Address = null;
		}
		if (City == "") {
			City = null;
		}
		if (Region == "") {
			Region = null;
		}
		if (Postal_code == "") {
			Postal_code = null;
		}
		if (Country == "") {
			Country = null;
		}
		if (Phone == "") {
			Phone = null;
		}
		if (Fax == "") {
			Fax = null;
		}
	}

}
