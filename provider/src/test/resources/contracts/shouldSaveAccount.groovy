import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/accounts'
        body("""
  {
  "id":"5d1e0fa8dcf3ba2284a17140",
  "customerId":"4143124",
   "type":"CURRENT",
   "active":true,
   "transactionLimit":1000.0,
   "balance":0.0
  }
    """)
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 201
        body("""
{
    "id":"5d1e0fa8dcf3ba2284a17140",
    "customerId": "4143124",
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
    priority 1
}