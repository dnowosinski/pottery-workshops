package com.pottery_workshops.pottery_workshops.repository;

import com.pottery_workshops.pottery_workshops.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
