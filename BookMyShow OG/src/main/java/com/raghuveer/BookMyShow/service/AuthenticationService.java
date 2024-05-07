package com.raghuveer.BookMyShow.service;

import com.raghuveer.BookMyShow.dto.request.LoginRequest;
import com.raghuveer.BookMyShow.dto.response.BasicResponse;
import com.raghuveer.BookMyShow.dto.response.LoginResponse;

public interface AuthenticationService {

    BasicResponse<LoginResponse> login(LoginRequest loginRequest);

}
