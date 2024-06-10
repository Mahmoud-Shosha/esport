package com.stcs.esport.user.outadapter.adapter;

import com.stcs.esport.country.outadapter.sql.entity.CountryEntity;
import com.stcs.esport.country.outadapter.sql.repo.CountryRepo;
import com.stcs.esport.user.domain.model.Country;
import com.stcs.esport.user.domain.model.User;
import com.stcs.esport.user.domain.outport.CreateUserPort;
import com.stcs.esport.user.outadapter.entity.UserEntity;
import com.stcs.esport.user.outadapter.repo.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserAdapter implements CreateUserPort {

    private final UserEntityRepository userRepository;
    private final CountryRepo countryRepo;
    private final ModelMapper mapper;

    @Override
    public User createUser(User user) {
        CountryEntity countryEntity = countryRepo.findById(user.getNationality().getId())
                .orElse(null);
        UserEntity userEntity = UserEntity.builder()
                .id(UUID.randomUUID())
                .name(user.getName())
                .email(user.getEmail())
                .countryCode(user.getCountryCode())
                .mobileNumber(user.getMobileNumber())
                .nationality(countryEntity)
                .build();
        userRepository.save(userEntity);
        return buildUser(userEntity);
    }

    private User buildUser(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        user.setNationality(mapper.map(userEntity.getNationality(), Country.class));
        return user;
    }


}
