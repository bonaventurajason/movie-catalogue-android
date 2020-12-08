package com.bonaventurajason.moviecatalogue.utils

import com.bonaventurajason.moviecatalogue.R
import com.bonaventurajason.moviecatalogue.data.FilmEntity

object DataDummy {

    fun generateDummyMovies(): List<FilmEntity> {

        val movies = ArrayList<FilmEntity>()

        movies.add(
            FilmEntity(
                "m1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "2018-10-05",
                "Drama, Romance, Music",
                "Bradley Cooper",
                0.75,
                R.drawable.poster_a_start_is_born
            )
        )
        movies.add(
            FilmEntity(
                "m2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019-02-14",
                "Action, Science Fiction, Adventure",
                "Robert Rodriguez",
                0.71,
                R.drawable.poster_alita
            )
        )
        movies.add(
            FilmEntity(
                "m3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-21",
                "Action, Adventure, Fantasy",
                "James Wan",
                0.69,
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            FilmEntity(
                "m4",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018-11-02",
                "Drama, Music",
                "Bryan Singer",
                0.8,
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            FilmEntity(
                "m5",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019-02-08",
                "Action, Crime, Thriller",
                "Hans Petter Moland",
                0.56,
                R.drawable.poster_cold_persuit
            )
        )
        movies.add(
            FilmEntity(
                "m6",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2018-11-21",
                "Drama",
                "Steven Caple Jr.",
                0.69,
                R.drawable.poster_creed
            )
        )
        movies.add(
            FilmEntity(
                "m7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-11-16",
                "Adventure, Fantasy, Drama",
                "David Yates",
                0.69,
                R.drawable.poster_crimes
            )
        )
        movies.add(
            FilmEntity(
                "m8",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2019-01-18",
                "Thriller, Drama, Science Fiction",
                "M. Night Shyamalan",
                0.66,
                R.drawable.poster_glass
            )
        )
        movies.add(
            FilmEntity(
                "m9",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "2019-02-22",
                "Animation, Family, Adventure",
                "Dean DeBlois",
                0.78,
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            FilmEntity(
                "m10",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-27",
                "Adventure, Action, Science Fiction",
                "Joe Russo",
                0.83,
                R.drawable.poster_infinity_war
            )
        )
        return movies
    }


    fun generateDummyTVShow(): List<FilmEntity> {

        val tvShow = ArrayList<FilmEntity>()

        tvShow.add(
            FilmEntity(
                "tv1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012-10-10",
                "Crime, Drama, Mystery, Action, Adventure",
                "Greg Berlanti",
                0.65,
                R.drawable.poster_arrow
            )
        )
        tvShow.add(
            FilmEntity(
                "tv2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019-02-15",
                "Sci-Fi & Fantasy, Action, Adventure",
                "Jeremy Carver",
                0.76,
                R.drawable.poster_doom_patrol
            )
        )
        tvShow.add(
            FilmEntity(
                "tv3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986-02-26",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "Akira Toriyama",
                0.80,
                R.drawable.poster_dragon_ball
            )
        )
        tvShow.add(
            FilmEntity(
                "tv4",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "2009-10-12",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "Unknown",
                0.76,
                R.drawable.poster_fairytail
            )
        )
        tvShow.add(
            FilmEntity(
                "tv5",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999-01-31",
                "Animation, Comedy",
                "Seth MacFarlane",
                0.69,
                R.drawable.poster_family_guy
            )
        )
        tvShow.add(
            FilmEntity(
                "tv6",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07",
                "Drama, Sci-Fi & Fantasy",
                "Greg Berlanti",
                0.76,
                R.drawable.poster_flash
            )
        )
        tvShow.add(
            FilmEntity(
                "tv7",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "2011-04-17",
                "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
                "Davic Benioff",
                0.83,
                R.drawable.poster_god
            )
        )
        tvShow.add(
            FilmEntity(
                "tv8",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "2014-09-22",
                "Drama, Fantasy, Crime",
                "Bruno Heller",
                0.74,
                R.drawable.poster_gotham
            )
        )
        tvShow.add(
            FilmEntity(
                "tv9",
                "Grey Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "2005-03-27",
                "Drama",
                "Shonda Rhimes",
                0.81,
                R.drawable.poster_grey_anatomy
            )
        )
        tvShow.add(
            FilmEntity(
                "tv10",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "2019-03-28",
                "Action & Adventure, Drama",
                "David Farr",
                0.74,
                R.drawable.poster_hanna
            )
        )

        return tvShow
    }

}