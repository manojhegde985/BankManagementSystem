package com.example.bank.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bank.dto.BankDto;
import com.example.bank.entity.Bank;
@Repository
public class BankRepository implements IBankRepository {

	  private JdbcTemplate jdbcTemplate;
	  
	  public BankRepository(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	  
	@Override
	public int count() {
		
		return 0;
	}

	@Override
	public BankDto save(BankDto customer) {
		
		String sql = "INSERT INTO customer (cid,fname,lname,address,username,password)"
                + " VALUES (?, ?, ?, ?,?,?)";
    jdbcTemplate.update(sql, customer.getCid(), customer.getFname(),customer.getLname(),
            customer.getAddress(), customer.getUsername(),customer.getPassword());
	return customer;
	}

	@Override
	public List<BankDto> findAll() {
		String sql = "SELECT * FROM customer";
	    List<BankDto> listCustomer = jdbcTemplate.query(sql, new RowMapper<BankDto>() {
		
	    	 public BankDto mapRow(ResultSet rs, int rowNum) throws SQLException {
	             BankDto customer = new BankDto();
	  
	             customer.setCid(rs.getInt("cid"));
	             customer.setFname(rs.getString("fname"));
	             customer.setLname(rs.getString("lname"));
	             customer.setAddress(rs.getString("address"));
	             customer.setUsername(rs.getString("username"));
	             customer.setPassword(rs.getString("password"));
	  
	             return customer;
	         }
	  
	     });
	  
	     return listCustomer;
	}

	@Override
	public BankDto findById(int cid) {
		 String sql = "SELECT * FROM customer WHERE customer_id=" + cid;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<BankDto>() {
		    	 public BankDto extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                BankDto contact = new BankDto();
	                contact.setCid(rs.getInt("cid"));
	                contact.setFname(rs.getString("fname"));
	                contact.setLname(rs.getString("lname"));
	                contact.setAddress(rs.getString("address"));
	                contact.setUsername(rs.getString("username"));
	                contact.setPassword(rs.getString("password"));
	                return contact;
	            }
	 
	            return null;
	        }
	 
	    });
	}

}
