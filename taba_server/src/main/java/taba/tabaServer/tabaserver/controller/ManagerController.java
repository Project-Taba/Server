package taba.tabaServer.tabaserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taba.tabaServer.tabaserver.dto.global.AuthenticationResponse;
import taba.tabaServer.tabaserver.dto.global.ResponseDto;
import taba.tabaServer.tabaserver.dto.managerdto.CreateManagerDto;
import taba.tabaServer.tabaserver.dto.managerdto.ManagerLoginDto;
import taba.tabaServer.tabaserver.exception.CommonException;
import taba.tabaServer.tabaserver.exception.ErrorCode;
import taba.tabaServer.tabaserver.repository.ManagerRepository;
import taba.tabaServer.tabaserver.service.ManagerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/managers")
public class ManagerController {
    private final ManagerService managerService;
    private final ManagerRepository managerRepository;

    @PostMapping("/register")
    public ResponseDto<?> registerManager(@RequestBody CreateManagerDto createManagerDto){
        return ResponseDto.ok(managerService.createManager(createManagerDto));
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody ManagerLoginDto managerLoginDto){
        String token = managerService.login(managerLoginDto);
        if(token != null){
            return ResponseDto.ok(new AuthenticationResponse(token));
        } else {
            return ResponseDto.fail(new CommonException(ErrorCode.LOGIN_FAILURE));
        }
    }
}