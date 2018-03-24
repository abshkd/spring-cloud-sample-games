import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description """
        should return a list of games
"""
    request {
        urlPath "/gameslist"
        headers {
            header "Authorization": "Bearer VALID_TOKEN"
        }
        method GET()
    }
    response {
        status 200
        body("game1, game2, game3")
    }


}