import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/accounts/4242412'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""
{

}
""")
        headers {
            contentType(applicationJson())
        }
    }
}