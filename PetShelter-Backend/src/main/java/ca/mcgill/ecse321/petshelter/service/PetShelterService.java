package ca.mcgill.ecse321.petshelter.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Used for checking for valid email
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.petshelter.model.*;
import ca.mcgill.ecse321.petshelter.dao.*;
import ca.mcgill.ecse321.petshelter.ErrorMessages;

@Service
public class PetShelterService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ApplicationRepository applicationRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommentRepository commentRepository;	
	@Autowired
	private DonationRepository donationRepository;	
	@Autowired
	private MessageRepository messageRepository;	
	@Autowired
	private PostingRepository postingRepository;
	@Autowired
	private ProfileRepository profileRepository;
	
	@Transactional
	public Client createClient(Date dob, String email, String password, String phoneNumber, 
							   String address, String firstName, String lastName) {

		// Checking if client exists already
		if (getClient(email) != null) {
			throw new IllegalArgumentException(ErrorMessages.accountExists);
		}

		// Checking if DOB is appropriate -- Need to add check for 18 years of age
		if (dob == null) {
			throw new IllegalArgumentException(ErrorMessages.invalidDOB);
		}

		// Checking if email is appropriate
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
		"[a-zA-Z0-9_+&*-]+)*@" + 
		"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
		"A-Z]{2,7}$"; 
		Pattern patEmail = Pattern.compile(emailRegex); 
		if (email == null || !(patEmail.matcher(email).matches())) {
			throw new IllegalArgumentException(ErrorMessages.invalidEmail);
		}

		// Checking if password is appropriate -- Longer than 6 chars?
		if (password == null || password.length() < 6) {
			throw new IllegalArgumentException(ErrorMessages.invalidPassword);
		}

		// Checking if phone number is appropriate
		String phoneNumberRegex = "^\\d-\\d-\\d-\\d-\\d-\\d-\\d-\\d-\\d-\\d$";
		Pattern patPhoneNumber = Pattern.compile(phoneNumberRegex); 
		if (phoneNumber == null || !(patPhoneNumber.matcher(phoneNumber).matches())) {
			throw new IllegalArgumentException(ErrorMessages.invalidPhoneNumber);
		}

		// Checking if address is appropriate
		if (address == null || address.equals("")) {
			throw new IllegalArgumentException(ErrorMessages.invalidAddress);
		}
		
		// Checking if names are appropriate
		if (firstName == null || firstName.equals("")) {
			throw new IllegalArgumentException(ErrorMessages.invalidFirstName);
		}
		if (lastName == null || lastName.equals("")) {
			throw new IllegalArgumentException(ErrorMessages.invalidLastName);
		}

		Client client = new Client();

		// Profile attributes
		client.setDateOfBirth(dob);
		client.setEmail(email);
		client.setPassword(password); // Just stored as string for now, can change later
		client.setPhoneNumber(phoneNumber);
		client.setAddress(address);
		client.setPostings(null);
		client.setComments(null);

		// Client attributes
		client.setFirstName(firstName);
		client.setLastName(lastName);
		client.setDonations(null);
		client.setMessages(null);
		client.setApplications(null);

		clientRepository.save(client);
		
		return client;
	}

	@Transactional
	public Client getClient(String email) {
		if (email != null) {
			Client client = clientRepository.findClientByEmail(email);
			if (client == null) {
				throw new IllegalArgumentException(ErrorMessages.accountDoesNotExist);
			}
			return client;
		}
		return null; 
	}
	
	@Transactional
	public Client deleteClient(String email) {
		if (email != null) {
			Client client = getClient(email);
			clientRepository.delete(client); 
			return client;
		}
		return null; 
	}
	
	@Transactional
	public boolean clientLogin(String email, String password) {
		if (email != null) {
			Client client = getClient(email);
			if (password.equals(client.getPassword())) { // Change if we end up storing passwords in ciphertext
				return true;
			}
		}
		return false;
	}
	
	@Transactional
	public Profile updateProfile() {
		return null;
	}
	
	@Transactional
	public Donation sendDonation() {
		return null;
	}
	
	@Transactional
	public Message sendMessage() {
		return null;
	}
	
	@Transactional
	public Comment commentOnPosting() {
		return null;
	}
	
	@Transactional
	public List<Posting> getPostings(){
		return null;
	}
	
	@Transactional
	public Posting createPosting() {
		return null;
	}
	
	@Transactional
	public Posting deletePosting() {
		return null;
	}
	
	@Transactional
	public Posting updatePostingInfo() {
		return null;
	}
	
	@Transactional
	public List<Application> getApplications(){
		return null;
	}
	
	@Transactional
	public Application selectFinalApplication(){
		return null;
	}
	
	@Transactional
	public Application createApplication(){
		return null;
	}
}