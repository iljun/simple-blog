package com.example.oauthserver.domain.member;

import com.example.oauthserver.api.request.AddMember;
import com.example.oauthserver.domain.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

//    private static final Role DEFAULE_ROLE = new Role()

    @Override
    public void singUp(AddMember addMember){
        Member member = Member.builder()
                .email(addMember.getEmail())
                .password(addMember.getPassword1())
                .username(addMember.getUsername())
                //TODO 디폴트 User권한 설정
//                .roles()
                .build();

        memberRepository.save(member);
    }
}
