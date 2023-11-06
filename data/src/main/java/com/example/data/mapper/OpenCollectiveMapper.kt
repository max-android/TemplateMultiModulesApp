package com.example.data.mapper

import com.example.common.double
import com.example.common.int
import com.example.data.dto.openCollective.EventDto
import com.example.data.dto.openCollective.LocationEventDto
import com.example.data.dto.openCollective.MemberDto
import com.example.domain.model.openCollective.EventModel
import com.example.domain.model.openCollective.LocationEventModel
import com.example.domain.model.openCollective.MemberModel

fun List<MemberDto>?.toListMemberModel(): List<MemberModel> {
    return this?.map(::toMemberModel) ?: emptyList()
}

private fun toMemberModel(memberDto: MemberDto): MemberModel {
    return MemberModel(
        image = memberDto.image.orEmpty(),
        website = memberDto.website.orEmpty(),
        role = memberDto.role.orEmpty(),
        description = memberDto.description.orEmpty(),
        type = memberDto.type.orEmpty(),
        lastTransactionAt = memberDto.lastTransactionAt.orEmpty(),
        memberId = memberDto.memberId.int(),
        createdAt = memberDto.createdAt.orEmpty(),
        name = memberDto.name.orEmpty(),
        company = memberDto.company.orEmpty(),
    )
}

fun List<EventDto>?.toListEventModel(): List<EventModel> {
    return this?.map(::toEventsModel) ?: emptyList()
}

private fun toEventsModel(eventDto: EventDto): EventModel {
    return EventModel(
        image = eventDto.image.orEmpty(),
        name = eventDto.name.orEmpty(),
        description = eventDto.description.orEmpty(),
        longDescription = eventDto.longDescription.orEmpty(),
        startsAt = eventDto.startsAt.orEmpty(),
        location = eventDto.location.toLocationEventModel(),
        id = eventDto.id.int().toString(),
        endsAt = eventDto.endsAt.orEmpty(),
        slug = eventDto.slug.orEmpty(),
        url = eventDto.url.orEmpty(),
        info = eventDto.info.orEmpty(),
    )
}

private fun LocationEventDto?.toLocationEventModel(): LocationEventModel {
    return LocationEventModel(
        address = this?.address.orEmpty(),
        name = this?.name.orEmpty(),
        lat = this?.lat.double(),
        jsonMemberLong = this?.jsonMemberLong.double()
    )
}

fun EventDto?.toEventModel(): EventModel {
    return EventModel(
        image = this?.image.orEmpty(),
        name = this?.name.orEmpty(),
        description = this?.description.orEmpty(),
        longDescription = this?.longDescription.orEmpty(),
        startsAt = this?.startsAt.orEmpty(),
        location = this?.location.toLocationEventModel(),
        id = this?.id.int().toString(),
        endsAt = this?.endsAt.orEmpty(),
        slug = this?.slug.orEmpty(),
        url = this?.url.orEmpty(),
        info = this?.info.orEmpty(),
    )
}