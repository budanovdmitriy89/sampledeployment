package com.companyname.devops.sampledeployment.reposiroty;

import com.companyname.devops.sampledeployment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
