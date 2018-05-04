package com.example.resource.config.security;

import com.example.resource.advice.InvalidJwtException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오전 10:27
 */
public class HeaderTokenExtractorTest {

    private HeaderTokenExtractor extractor = new HeaderTokenExtractor();
    private String header;

    @Before
    public void setUp(){
        this.header = "Bearer alerkgnalknggaeklnglaekrn";
    }

    @Rule
    public ExpectedException expectedExcetption = ExpectedException.none();

    @Test
    public void TEST_JWT_EXTRACT(){
        expectedExcetption.expect(InvalidJwtException.class);
        expectedExcetption.expectMessage("올바른 토큰 정보가 아닙니다.");
        assertThat(extractor.extract(this.header),is("alerkgnalknggaeklnglaekrn"));
        assertThat(extractor.extract(""),is(expectedExcetption));
        assertThat(extractor.extract("bearer araweraweflawknf"),is(expectedExcetption));
    }

}
