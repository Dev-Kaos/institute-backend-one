package com.institute.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import com.institute.one.users.domain.entity.PermissionEntity;
import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.users.domain.entity.UserBasicAuthEntity;
import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.persistence.repository.IUserBasicAuthRepository;
import com.institute.one.users.persistence.repository.IUserRepository;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.RoleEnum;
import com.institute.one.utilities.enums.StateEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class OneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IUserRepository userRepository, IUserBasicAuthRepository userBasicAuthRepository) {

		return args -> {

			// System.out.println("Hello World");

			PermissionEntity crearPermission = PermissionEntity.builder()
					.name("CREAR")
					.build();

			PermissionEntity leerPermission = PermissionEntity.builder()
					.name("LEER")
					.build();

			PermissionEntity actualizarPermission = PermissionEntity.builder()
					.name("ACTUALIZAR")
					.build();

			PermissionEntity borrarPermission = PermissionEntity.builder()
					.name("BORRAR")
					.build();

			PermissionEntity modificarPermission = PermissionEntity.builder()
					.name("MODIFICAR")
					.build();
			PermissionEntity evaluarPermission = PermissionEntity.builder()
					.name("EVALUAR")
					.build();
			PermissionEntity administrarPermission = PermissionEntity.builder()
					.name("ADMINISTAR")
					.build();
			PermissionEntity pagarPermission = PermissionEntity.builder()
					.name("PAGAR")
					.build();
			PermissionEntity realizarPermission = PermissionEntity.builder()
					.name("REALIZAR")
					.build();
			PermissionEntity desarrollarPermission = PermissionEntity.builder()
					.name("DESAROLLAR")
					.build();

			RoleEntity rolAdministrador = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMINISTRADOR)
					.permissionList(Set.of(administrarPermission, leerPermission, modificarPermission,
							actualizarPermission, borrarPermission))
					.build();

			RoleEntity rolProfesor = RoleEntity.builder()
					.roleEnum(RoleEnum.PROFESOR)
					.permissionList(Set.of(evaluarPermission, leerPermission, actualizarPermission, borrarPermission))
					.build();

			RoleEntity rolAlumno = RoleEntity.builder()
					.roleEnum(RoleEnum.ALUMNO)
					.permissionList(Set.of(realizarPermission, leerPermission, actualizarPermission))
					.build();

			RoleEntity rolAcudiente = RoleEntity.builder()
					.roleEnum(RoleEnum.ACUDIENTE)
					.permissionList(Set.of(pagarPermission, leerPermission, actualizarPermission))
					.build();

			RoleEntity rolDesarrollador = RoleEntity.builder()
					.roleEnum(RoleEnum.DESARROLLADOR)
					.permissionList(
							Set.of(desarrollarPermission, administrarPermission, evaluarPermission, pagarPermission,
									leerPermission, modificarPermission, actualizarPermission, borrarPermission))
					.build();

			// TODO: date formatter
			String strDate = "2024-05-24"; // String representation of date
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; // ISO-8601 date format

			// Parse the String into a LocalDate object
			LocalDate localDate = LocalDate.parse(strDate, formatter);

			// TODO: date formatter
			

			UserEntity userManuel = new UserEntity();
			userManuel.setName("manuel");
			userManuel.setSurname("vela");
			userManuel.setDocType(DocTypeEnum.CEDULA_CIUDADANIA);
			userManuel.setDocNumber("12345678");
			userManuel.setBirthDate(localDate);
			userManuel.setEmail("email@gmail.com");
			userManuel.setPhone("3452345235");
			userManuel.setGender(GenderEnum.MASCULINO);
			userManuel.setProfileImage("urldelaImagen");
			userManuel.setNickname("kaos");
			userManuel.setState(StateEnum.ACTIVO);
			

			UserBasicAuthEntity userAuthManuel = new UserBasicAuthEntity();
			userAuthManuel.setUsername("manuel");
			userAuthManuel.setPassword("1234");
			userAuthManuel.setEnabled(true);
			userAuthManuel.setAccountNoExpired(true);
			userAuthManuel.setAccountNoLocked(true);
			userAuthManuel.setCredentialNoExpired(true);
			userAuthManuel.setRoles(Set.of(rolDesarrollador, rolAdministrador));

			userManuel.setUserAuth(userAuthManuel);
			userAuthManuel.setUser(userManuel);
			userRepository.save(userManuel);


			// UserEntity userManuel = UserEntity.builder()
			// 		.name("manuel")
			// 		.surname("vela")
			// 		.docType(DocTypeEnum.CEDULA_CIUDADANIA)
			// 		.docNumber("12345678")
			// 		.birthDate(localDate)
			// 		.email("email@gmail.com")
			// 		.phone("3452345235")
			// 		.gender(GenderEnum.MASCULINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("kaos")
			// 		.state(StateEnum.ACTIVO)					
			// 		.build();

			// UserBasicAuthEntity userAuthManuel = UserBasicAuthEntity.builder()
			// 		.username("manuel")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.AccountNoExpired(true)
			// 		.AccountNoLocked(true)
			// 		.CredentialNoExpired(true)
			// 		.roles(Set.of(rolDesarrollador, rolAdministrador))
			// 		.user(userManuel)
			// 		.build();
			// 		userRepository.save(userManuel);
			// 		userManuel.setUserAuth(userAuthManuel);
					



			// // TODO: date formatter

			// UserEntity userFernando = UserEntity.builder()
			// 		.name("fernando")
			// 		.surname("osorio")
			// 		.docType(DocTypeEnum.TARJETA_IDENTIDAD)
			// 		.docNumber("57457")
			// 		.birthDate(localDate)
			// 		.email("email@gmail.com")
			// 		.phone("34252345")
			// 		.gender(GenderEnum.MASCULINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("fercho")
			// 		.state(StateEnum.ACTIVO)
			// 		.build();

			// UserBasicAuthEntity userAuthFernando = UserBasicAuthEntity.builder()
			// 		.username("fernando")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.AccountNoExpired(true)
			// 		.AccountNoLocked(true)
			// 		.CredentialNoExpired(true)
			// 		.roles(Set.of(rolDesarrollador, rolProfesor))
			// 		.user(userFernando)
			// 		.build();

			// // TODO: date formatter

			// UserEntity userGeraldine = UserEntity.builder()
			// 		.name("gerald")
			// 		.surname("leyton")
			// 		.docType(DocTypeEnum.CEDULA_CIUDADANIA)
			// 		.docNumber("12345678")
			// 		.birthDate(localDate)
			// 		.email("email@gmail.com")
			// 		.phone("3452345235")
			// 		.gender(GenderEnum.FEMENINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("yeya")
			// 		.state(StateEnum.ACTIVO)
			// 		.build();

			// UserBasicAuthEntity userAuthGeraldine = UserBasicAuthEntity.builder()
			// 		.username("geraldine")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.AccountNoExpired(true)
			// 		.AccountNoLocked(true)
			// 		.CredentialNoExpired(true)
			// 		.roles(Set.of(rolAlumno, rolAdministrador))
			// 		.user(userGeraldine)
			// 		.build();

			// 		// TODO: date formatter
					
			// 		UserEntity userAlejandra = UserEntity.builder()					
			// 		.name("alejandra")
			// 		.surname("rojas")
			// 		.docType(DocTypeEnum.CEDULA_EXTRANJERA)
			// 		.docNumber("12345678")
			// 		.birthDate(localDate)
			// 		.email("email@gmail.com")
			// 		.phone("3452345235")
			// 		.gender(GenderEnum.FEMENINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("ale")
			// 		.state(StateEnum.ACTIVO)
			// 		.build();

			// 		UserBasicAuthEntity userAuthAlejandra = UserBasicAuthEntity.builder()
			// 		.username("alejandra")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.AccountNoExpired(true)
			// 		.AccountNoLocked(true)
			// 		.CredentialNoExpired(true)
			// 		.roles(Set.of(rolAcudiente))
			// 		.user(userAlejandra)
			// 		.build();
					
			// 		// TODO: date formatter

			// 		UserEntity userEliana = UserEntity.builder()					
			// 		.name("eliana")
			// 		.surname("perez")
			// 		.docType(DocTypeEnum.CEDULA_CIUDADANIA)
			// 		.docNumber("547457")
			// 		.birthDate(localDate)
			// 		.email("email@gmail.com")
			// 		.phone("2435234")
			// 		.gender(GenderEnum.FEMENINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("eli")
			// 		.state(StateEnum.ACTIVO)
			// 		.build();

			// 		UserBasicAuthEntity userAuthEliana = UserBasicAuthEntity.builder()
			// 		.username("eliana")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.AccountNoExpired(true)
			// 		.AccountNoLocked(true)
			// 		.CredentialNoExpired(true)
			// 		.roles(Set.of(rolDesarrollador, rolAdministrador))
			// 		.user(userEliana)
			// 		.build();

			// userRepository.saveAll(Set.of(userManuel, userFernando, userGeraldine, userAlejandra, userEliana));
			// userBasicAuthRepository.saveAll(Set.of(userAuthManuel, userAuthFernando, userAuthGeraldine,userAuthAlejandra,userAuthEliana));
		};
	}

}
