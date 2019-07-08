package com.montezano.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.montezano.consumer.dataContract.AccountDataContract;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.montezano:provider:+:stubs:8080"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ApplicationTests {

	private RestTemplate restTemplate = new RestTemplate();

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void validate_shouldSaveAccount() throws Exception {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");

		final AccountDataContract accountDataContract = objectMapper.readValue("{\"active\":true,\"balance\":0.0,\"customerId\":\"4143124\",\"id\":\"5d1e0fa8dcf3ba2284a17140\",\"transactionLimit\":1000.0,\"type\":\"CURRENT\"}",
				AccountDataContract.class);

		final HttpEntity<AccountDataContract> entity = new HttpEntity<>(accountDataContract, httpHeaders);

		final ResponseEntity<AccountDataContract> responseEntity = restTemplate.exchange(
				"http://localhost:8080/accounts", HttpMethod.POST, entity, AccountDataContract.class);

		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.CREATED));

		assertThat(responseEntity.getBody().getId(), is(accountDataContract.getId()));
		assertThat(responseEntity.getBody().getCustomerId(), is(accountDataContract.getCustomerId()));
		assertThat(responseEntity.getBody().getType(), is(accountDataContract.getType()));
		assertThat(responseEntity.getBody().isActive(), is(accountDataContract.isActive()));
		assertThat(responseEntity.getBody().getTransactionLimit(), is(accountDataContract.getTransactionLimit()));
		assertThat(responseEntity.getBody().getBalance(), is(accountDataContract.getBalance()));
	}

	@Test
	public void validate_shouldFindAnAccount() throws Exception {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");

		final HttpEntity entity = new HttpEntity(httpHeaders);

		final ResponseEntity<AccountDataContract> responseEntity = restTemplate.exchange(
				"http://localhost:8080/accounts/1", HttpMethod.GET, entity, AccountDataContract.class);

		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));

		final AccountDataContract accountDataContract = objectMapper.readValue("{\n" +
				"   \"id\":\"1\",\n" +
				"   \"customerId\":\"12\",\n" +
				"   \"type\":\"CURRENT\",\n" +
				"   \"active\":true,\n" +
				"   \"transactionLimit\":1000,\n" +
				"   \"balance\":0\n" +
				"}", AccountDataContract.class);

		assertThat(responseEntity.getBody().getId(), is(accountDataContract.getId()));
		assertThat(responseEntity.getBody().getCustomerId(), is(accountDataContract.getCustomerId()));
		assertThat(responseEntity.getBody().getType(), is(accountDataContract.getType()));
		assertThat(responseEntity.getBody().isActive(), is(accountDataContract.isActive()));
		assertThat(responseEntity.getBody().getTransactionLimit(), is(accountDataContract.getTransactionLimit()));
		assertThat(responseEntity.getBody().getBalance(), is(accountDataContract.getBalance()));
	}

	@Test
	public void validate_shouldNotFindAnAccount() throws Exception {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");

		final HttpEntity entity = new HttpEntity(httpHeaders);

		final ResponseEntity<String> responseEntity = restTemplate.exchange(
				"http://localhost:8080/accounts/4242412", HttpMethod.GET, entity, String.class);

		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));

		assertThat(responseEntity.getBody(), isEmptyOrNullString());
	}

}
