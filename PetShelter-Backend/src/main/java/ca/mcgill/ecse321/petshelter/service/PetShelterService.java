package ca.mcgill.ecse321.petshelter.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.petshelter.model.*;
import ca.mcgill.ecse321.petshelter.dao.*;

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
	public Client createClient() {
		return null;
	}
	
	@Transactional
	public Client deleteClient() {
		return null;
	}
	
	@Transactional
	public boolean clientLogin() {
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
