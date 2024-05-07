package com.raghuveer.BookMyShow.service;


import java.util.List;

import com.raghuveer.BookMyShow.dto.request.RegisterRequest;
import com.raghuveer.BookMyShow.dto.response.BasicResponse;
import com.raghuveer.BookMyShow.entity.User;
import com.raghuveer.BookMyShow.enumerated.Role;



public interface AdminService {

    BasicResponse<String> register(RegisterRequest registerRequest, Role role) throws Exception;

    List<User> findAll();
    
}
