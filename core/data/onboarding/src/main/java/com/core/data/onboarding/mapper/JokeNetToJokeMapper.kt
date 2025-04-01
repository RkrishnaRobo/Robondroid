package com.core.data.onboarding.mapper

import com.core.common.mapper.Mapper
import com.core.data.onboarding.model.JokeNet
import com.core.domain.onboarding.model.Joke
import javax.inject.Inject

class JokeNetToJokeMapper @Inject constructor() : Mapper<JokeNet, Joke> {
    override fun map(param: JokeNet): Joke {
        return Joke(
            id = param.id ?: 0,
            type = param.type.orEmpty(),
            punchline = param.punchline.orEmpty(),
            setup = param.setup.orEmpty()
        )
    }
}
