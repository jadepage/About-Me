package com.jadepage.aboutme.repository

import com.jadepage.aboutme.models.Hobby

object HobbyRepository {

    val hobbies = mutableListOf<Hobby>(
        Hobby("Rugby",
                "I enjoy watching rugby, " +
                "the teams I support are the Springboks, Sharks and Saracens."
        ),
        Hobby("Out Doors",
            "I enjoy the outdoors, going on " +
                    "outdoor nature walks and exploring new places. "
        )
    )
}