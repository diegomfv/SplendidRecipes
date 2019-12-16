package com.diegomfv.splendidrecipesmvvm.data.server

//class TheMovieDbDataSource(private val theMovieDb: TheMovieDb) : RemoteDataSource {
//
//    override suspend fun getPopularMovies(apiKey: String, region: String): List<Movie> =
//        theMovieDb.service
//            .listPopularMoviesAsync(apiKey, region).await()
//            .results
//            .map { it.toDomainMovie() }
//}