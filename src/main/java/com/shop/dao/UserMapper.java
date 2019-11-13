package com.shop.dao;

import com.shop.domain.User;
import com.shop.domain.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserByName(String name);
}