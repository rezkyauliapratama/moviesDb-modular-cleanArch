package id.co.rezkyauliapratama.featurehome.data.datasource.source.mock

import id.co.rezkyauliapratama.feature_home.R
import id.co.rezkyauliapratama.featurehome.data.datasource.model.ListMoviesDto
import id.co.rezkyauliapratama.featurehome.data.datasource.model.MovieDtoBean

class MovieMockDataFactory {
    companion object {

        fun create(): ListMoviesDto = generateMovies()

        private fun generateMovies(): ListMoviesDto {
            return ListMoviesDto(moviesDto = generateMoviesBean())
        }

        private fun generateMoviesBean(): List<MovieDtoBean> {
            return arrayListOf(
                MovieDtoBean(
                    id = 0,
                    posterPath = R.drawable.poster_avengerinfinity,
                    title = "Avengers: Infinity War",
                    popularity = 4.3,
                    releaseDate = "April 27, 2018",
                    overview = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
                ),
                MovieDtoBean(
                    id = 1,
                    posterPath = R.drawable.poster_spiderman,
                    title = "Spider-Man: Into the Spider-Verse",
                    popularity = 4.3,
                    releaseDate = "December 14, 2018",
                    overview = "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."
                ),
                MovieDtoBean(
                    id = 2,
                    posterPath = R.drawable.poster_venom,
                    title = "Venom",
                    popularity = 3.0,
                    releaseDate = "October 5, 2018",
                    overview = "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own."
                ),
                MovieDtoBean(
                    id = 3,
                    posterPath = R.drawable.poster_bumblebee,
                    title = "Bumblebee",
                    popularity = 3.2,
                    releaseDate = "December 21, 2018",
                    overview = "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug."
                ),
                MovieDtoBean(
                    id = 4,
                    posterPath = R.drawable.poster_a_star,
                    title = "A Star Is Born",
                    popularity = 3.3,
                    releaseDate = "October 5, 2018",
                    overview = "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
                ),
                MovieDtoBean(
                    id = 5,
                    posterPath = R.drawable.poster_mortalengine,
                    title = "Mortal Engines",
                    popularity = 3.0,
                    releaseDate = "December 14, 2018",
                    overview = "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever."
                ),
                MovieDtoBean(
                    id = 6,
                    posterPath = R.drawable.poster_marrypopins,
                    title = "Mary Poppins Returns",
                    popularity = 3.3,
                    releaseDate = "December 19, 2018",
                    overview = "In Depression-era London, a now-grown Jane and Michael Banks, along with Michael's three children, are visited by the enigmatic Mary Poppins following a personal loss. Through her unique magical skills, and with the aid of her friend Jack, she helps the family rediscover the joy and wonder missing in their lives."
                ),
                MovieDtoBean(
                    id = 7,
                    posterPath = R.drawable.poster_aquaman,
                    title = "Aquaman",
                    popularity = 3.2,
                    releaseDate = "December 21, 2018",
                    overview = "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
                ),
                MovieDtoBean(
                    id = 8,
                    posterPath = R.drawable.poster_bohemian,
                    title = "Bohemian Rhapsody",
                    popularity = 4.2,
                    releaseDate = "November 2, 2018",
                    overview = "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
                ),
                MovieDtoBean(
                    id = 9,
                    posterPath = R.drawable.poster_deadpool,
                    title = "Deadpool 2",
                    popularity = 3.5,
                    releaseDate = "May 10, 2018",
                    overview = "Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life."
                )

            )
        }


    }
}