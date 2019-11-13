package com.shop.service;

import java.util.List;

import com.shop.domain.User;

public interface UserService {
	User  selectUserByName(String name);
}
