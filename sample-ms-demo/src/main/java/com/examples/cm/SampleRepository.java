package com.examples.cm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examples.Employee;

@Repository
public class SampleRepository extends JpaRepository<Employee, Long> {

}
