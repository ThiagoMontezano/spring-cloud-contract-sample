package com.montezano.provider;

import com.montezano.provider.http.AccountController;
import com.montezano.provider.gateway.AccountGatewayInMemory;
import com.montezano.provider.usecase.AccountCrud;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

//@RunWith(SpringRunner.class)
public class AccountMvcTest {


    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new AccountController(getAccountCrud()));
    }

    private AccountCrud getAccountCrud(){
        return new AccountCrud(new AccountGatewayInMemory());
    }
}
