package com.examples;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newuser")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3616129179135433663L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private Long id;

	@Column(name = "user_name")
	private String employeeName;
}
