package com.doctorhere.base.user.model.mapper;

import com.doctorhere.base.user.model.Role;
import com.doctorhere.base.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "roles", source = "roles")
    User toEntity(String username, String password, List<Role> roles);

}
