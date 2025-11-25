package jpa_study.service;


import jpa_study.dto.AddUserReqDto;
import jpa_study.dto.ApiRespDto;
import jpa_study.dto.EditUserReqDto;
import jpa_study.entity.User;
import jpa_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ApiRespDto<?> addUser(AddUserReqDto addUserReqDto){
        Optional<User> foundUser = userRepository.findByUsername(addUserReqDto.getUsername());

        if (foundUser.isPresent()){
            return new ApiRespDto<>("failed", "니 이름이 이거가? 있는거다 다른거 해라", addUserReqDto.getUsername());
        }
        return new ApiRespDto<>("success", "추가했다 함 보봐", userRepository.save(addUserReqDto.toEntity()));
    }
    public ApiRespDto<?> getUserAll(){
        return new ApiRespDto<>("success", "전체조회 성공", userRepository.findAll());
}
    public ApiRespDto<?> getUserByUserId(Integer userId){
    Optional<User> foundUser = userRepository.findById(userId);
    if (foundUser.isEmpty()){
        return new ApiRespDto<>("failed", "게시물 없다 이것아 ㅋㅋ뭐하냐", null);
    }
    return new ApiRespDto<>("success", "단단건건조조회회", foundUser.get());
    }
    public ApiRespDto<?> getUserListByUserId(Integer userId){
        return new ApiRespDto<>("success", "유저 조회 게시물이다", userRepository.findAllByUserId(userId));
    }
    public ApiRespDto<?> editUser(EditUserReqDto editUserReqDto){
        Optional<User>foundUser = userRepository.findById(editUserReqDto.getUserId());
        if (foundUser.isEmpty()){
            return new ApiRespDto<>("failed", "해당 게시물 없다고", null);
        }
        User user  = foundUser.get();
        user.setUsername(editUserReqDto.getUsername());
        user.setPassword(editUserReqDto.getPassword());
        user.setUpdateDt(LocalDateTime.now());
        return new ApiRespDto<>("success", "했다........성공", userRepository.save(user));
    }
    public ApiRespDto<?> removeUser(Integer userId){
        Optional<User> foundUser = userRepository.findById(userId);
        if (foundUser.isEmpty()){
            return new ApiRespDto<>("failed", "없는거 그만 찾아봐라 안나온다", null);
        }
        userRepository.deleteById(userId);
        return new ApiRespDto<>("success","성공 삭제 홍홍홍", null);
    }
}
