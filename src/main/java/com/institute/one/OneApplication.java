package com.institute.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.institute.one.users.domain.entity.PermissionEntity;
import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.persistence.repository.IUserRepository;
import com.institute.one.utilities.enums.RoleEnum;

@SpringBootApplication
public class OneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IUserRepository userRepository) {

		return args -> {

			// System.out.println("Hello World");

			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMINISTRADOR)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.PROFESOR)
					.permissionList(Set.of(readPermission, updatePermission))
					.build();

			RoleEntity roleGuest = RoleEntity.builder()
					.roleEnum(RoleEnum.ALUMNO)
					.permissionList(Set.of(readPermission))
					.build();

			UserEntity userManuel = UserEntity.builder()
					.username("manuel")
					.password("1234")
					.isEnabled(true)
					.AccountNoExpired(true)
					.AccountNoLocked(true)
					.CredentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
			UserEntity userFernando = UserEntity.builder()
					.username("fernando")
					.password("1234")
					.isEnabled(true)
					.AccountNoExpired(true)
					.AccountNoLocked(true)
					.CredentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();
			UserEntity userGeraldine = UserEntity.builder()
					.username("geraldine")
					.password("1234")
					.isEnabled(true)
					.AccountNoExpired(true)
					.AccountNoLocked(true)
					.CredentialNoExpired(true)
					.roles(Set.of(roleGuest))
					.build();

			userRepository.saveAll(Set.of(userManuel, userFernando, userGeraldine));
		};
	}

}
