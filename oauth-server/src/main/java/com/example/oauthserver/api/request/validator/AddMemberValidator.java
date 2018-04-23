package com.example.oauthserver.api.request.validator;

import com.example.oauthserver.api.request.AddMember;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AddMemberValidator implements Validator{

    private static final String EMAILREGX = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+$";
    private static final Pattern PATTERN = Pattern.compile(EMAILREGX);
    @Override
    public boolean supports(Class<?> clazz){
        return AddMember.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        AddMember addMember = (AddMember)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","name.required","이름을 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","email.required","이메일을 입력하세요");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password1","password1.required","패스워드를 입력하세요");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password2","password2.required","패스워드를 입력하세요.");

        if(!addMember.getPassword1().equals(addMember.getPassword2()))
            errors.rejectValue("password1","패스워드가 일치하지 않습니다.");

        if(addMember.getPassword1().trim().length()<6)
            errors.rejectValue("password1","패스워드는 6자 이상으로 입력하세요.");

        if(addMember.getPassword2().trim().length()<6)
            errors.rejectValue("password2","패스워드는 6자 이상으로 입력하세요.");

        Matcher matcher = PATTERN.matcher(addMember.getEmail());

        if(!matcher.find())
            errors.rejectValue("email","email 양식을 맞춰서 입력해주세요.");
    }

}
