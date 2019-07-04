import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/accounts/1'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""
{
    "id":"1",
    "customerId": "12",
    "type": "CURRENT",
    "active": true,
    "transactionLimit": 1000,
    "balance": 0
}
""")
        headers {
            contentType(applicationJson())
        }
    }
}