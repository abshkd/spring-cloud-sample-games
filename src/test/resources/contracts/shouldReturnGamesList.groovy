import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description """
        should return a list of games
"""
    request {
        urlPath "/gameslist"
        method GET()
    }
    response {
        status 200
        body("games1, games2, games3")
    }

}