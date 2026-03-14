package com.gaurav.projects.loveable_clone.mapper;

import com.gaurav.projects.loveable_clone.dto.member.MemberResponse;
import com.gaurav.projects.loveable_clone.entity.ProjectMember;
import com.gaurav.projects.loveable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target="userId",source="id")
    @Mapping(target="role", constant="OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);


    @Mapping(target="userId", source="user.id")
    @Mapping(target="email",source="user.email")
    @Mapping(target="name", source="user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);

}
