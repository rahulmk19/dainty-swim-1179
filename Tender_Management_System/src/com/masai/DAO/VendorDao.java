package com.masai.DAO;

import java.util.List;

import com.masai.DTO.Bidder;
import com.masai.DTO.BidderImpl;
import com.masai.DTO.Tender;
import com.masai.DTO.Vendor;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public interface VendorDao {
	
	public Vendor AuthenticateVendor(String username) throws VendorException;

	public List<Tender> viewAllTender() throws TenderException;

	public void placeBidAgainstTender(BidderImpl br) throws TenderException;

	public Bidder viewStatusOfBid(String BidId) throws BidderException;

	public List<Bidder> viewOwnBidHistory() throws BidderException;

	public void changeDetailsVendor(Vendor vendor);
}
