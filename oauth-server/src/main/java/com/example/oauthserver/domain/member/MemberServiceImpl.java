package com.example.oauthserver.domain.member;

import com.example.oauthserver.api.request.AddMember;
import com.example.oauthserver.api.response.github.GithubUserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

//    private static final Role DEFAULE_ROLE = new Role()

    @Override
    public void singUp(AddMember addMember) {
//        Member member = Member.builder()
//                .email(addMember.getEmail())
//                .password(addMember.getPassword1())
//                .username(addMember.getUsername())
//                //TODO 디폴트 User권한 설정
////                .roles()
//                .build();
//
//        memberRepository.save(member);
    }

    @Override
    public Member githubSignUp(GithubUserProfile githubUserProfile) {
        Optional<Member> githubMember = memberRepository.findByEmailAndUsername(githubUserProfile.getEmail(), githubUserProfile.getName());

        Member member = githubMember.orElse(
                memberRepository.save(
                        Member
                                .builder()
                                .username(githubUserProfile.getName())
                                .email(githubUserProfile.getEmail())
                                .socialProfile("GITHUB")
                                .userRole(UserRole.USER)
                                .build()));

        log.info(githubMember.toString());
        log.info(member.toString());

        return member;
        //TODO security 로그인 로직
    }
}
