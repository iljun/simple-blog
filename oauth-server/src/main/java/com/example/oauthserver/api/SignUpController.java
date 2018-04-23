package com.example.oauthserver.api;

import com.example.oauthserver.advice.BadRequest;
import com.example.oauthserver.api.request.AddMember;
import com.example.oauthserver.api.response.ResponseDto;
import com.example.oauthserver.api.response.ResponseStatus;
import com.example.oauthserver.domain.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/signUp")
public class SignUpController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value ="", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> singUpMember(@RequestBody @Valid AddMember addMember, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            throw new BadRequest(bindingResult.getFieldError().getDefaultMessage());

        memberService.singUp(addMember);
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg("회원가입")
                        .status(HttpStatus.CREATED)
                        .build(),
                HttpStatus.CREATED
        );
    }
}
